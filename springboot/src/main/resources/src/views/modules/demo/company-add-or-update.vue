<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="name">
      <el-input v-model="dataForm.name" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="shortName">
      <el-input v-model="dataForm.shortName" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="jopId">
      <el-input v-model="dataForm.jopId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="number">
      <el-input v-model="dataForm.number" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="auditInformation">
      <el-input v-model="dataForm.auditInformation" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="info">
      <el-input v-model="dataForm.info" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="registerTime">
      <el-input v-model="dataForm.registerTime" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="address">
      <el-input v-model="dataForm.address" placeholder=""></el-input>
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
          shortName: '',
          jopId: '',
          number: '',
          auditInformation: '',
          info: '',
          registerTime: '',
          address: '',
          state: ''
        },
        dataRule: {
          name: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          shortName: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          jopId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          number: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          auditInformation: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          info: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          registerTime: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          address: [
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
              url: this.$http.adornUrl(`/demo/company/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.name = data.company.name
                this.dataForm.shortName = data.company.shortName
                this.dataForm.jopId = data.company.jopId
                this.dataForm.number = data.company.number
                this.dataForm.auditInformation = data.company.auditInformation
                this.dataForm.info = data.company.info
                this.dataForm.registerTime = data.company.registerTime
                this.dataForm.address = data.company.address
                this.dataForm.state = data.company.state
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
              url: this.$http.adornUrl(`/demo/company/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'name': this.dataForm.name,
                'shortName': this.dataForm.shortName,
                'jopId': this.dataForm.jopId,
                'number': this.dataForm.number,
                'auditInformation': this.dataForm.auditInformation,
                'info': this.dataForm.info,
                'registerTime': this.dataForm.registerTime,
                'address': this.dataForm.address,
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
