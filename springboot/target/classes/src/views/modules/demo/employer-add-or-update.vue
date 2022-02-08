<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="name">
      <el-input v-model="dataForm.name" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="pwd">
      <el-input v-model="dataForm.pwd" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="tel">
      <el-input v-model="dataForm.tel" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="email">
      <el-input v-model="dataForm.email" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="companyId">
      <el-input v-model="dataForm.companyId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="所在地区" prop="area">
      <el-input v-model="dataForm.area" placeholder="所在地区"></el-input>
    </el-form-item>
    <el-form-item label="" prop="registerTime">
      <el-input v-model="dataForm.registerTime" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="state">
      <el-input v-model="dataForm.state" placeholder=""></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          id: 0,
          name: '',
          pwd: '',
          tel: '',
          email: '',
          companyId: '',
          area: '',
          registerTime: '',
          state: ''
        },
        dataRule: {
          name: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          pwd: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          tel: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          email: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          companyId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          area: [
            { required: true, message: '所在地区不能为空', trigger: 'blur' }
          ],
          registerTime: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          state: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/demo/employer/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.name = data.employer.name
                this.dataForm.pwd = data.employer.pwd
                this.dataForm.tel = data.employer.tel
                this.dataForm.email = data.employer.email
                this.dataForm.companyId = data.employer.companyId
                this.dataForm.area = data.employer.area
                this.dataForm.registerTime = data.employer.registerTime
                this.dataForm.state = data.employer.state
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/demo/employer/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'name': this.dataForm.name,
                'pwd': this.dataForm.pwd,
                'tel': this.dataForm.tel,
                'email': this.dataForm.email,
                'companyId': this.dataForm.companyId,
                'area': this.dataForm.area,
                'registerTime': this.dataForm.registerTime,
                'state': this.dataForm.state
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
