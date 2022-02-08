<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="jobId">
      <el-input v-model="dataForm.jobId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="工作地区" prop="areaId">
      <el-input v-model="dataForm.areaId" placeholder="工作地区"></el-input>
    </el-form-item>
    <el-form-item label="招聘人数" prop="recruitingNumber">
      <el-input v-model="dataForm.recruitingNumber" placeholder="招聘人数"></el-input>
    </el-form-item>
    <el-form-item label="薪水" prop="salary">
      <el-input v-model="dataForm.salary" placeholder="薪水"></el-input>
    </el-form-item>
    <el-form-item label="职位信息" prop="jobInfo">
      <el-input v-model="dataForm.jobInfo" placeholder="职位信息"></el-input>
    </el-form-item>
    <el-form-item label="专业要求" prop="majorId">
      <el-input v-model="dataForm.majorId" placeholder="专业要求"></el-input>
    </el-form-item>
    <el-form-item label="学历要求" prop="degreeId">
      <el-input v-model="dataForm.degreeId" placeholder="学历要求"></el-input>
    </el-form-item>
    <el-form-item label="性别要求;0-男;1-女;2-不限" prop="sex">
      <el-input v-model="dataForm.sex" placeholder="性别要求;0-男;1-女;2-不限"></el-input>
    </el-form-item>
    <el-form-item label="人事管理人employer" prop="hrId">
      <el-input v-model="dataForm.hrId" placeholder="人事管理人employer"></el-input>
    </el-form-item>
    <el-form-item label="" prop="tel">
      <el-input v-model="dataForm.tel" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="email">
      <el-input v-model="dataForm.email" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="time">
      <el-input v-model="dataForm.time" placeholder=""></el-input>
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
          jobId: '',
          areaId: '',
          recruitingNumber: '',
          salary: '',
          jobInfo: '',
          majorId: '',
          degreeId: '',
          sex: '',
          hrId: '',
          tel: '',
          email: '',
          time: ''
        },
        dataRule: {
          jobId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          areaId: [
            { required: true, message: '工作地区不能为空', trigger: 'blur' }
          ],
          recruitingNumber: [
            { required: true, message: '招聘人数不能为空', trigger: 'blur' }
          ],
          salary: [
            { required: true, message: '薪水不能为空', trigger: 'blur' }
          ],
          jobInfo: [
            { required: true, message: '职位信息不能为空', trigger: 'blur' }
          ],
          majorId: [
            { required: true, message: '专业要求不能为空', trigger: 'blur' }
          ],
          degreeId: [
            { required: true, message: '学历要求不能为空', trigger: 'blur' }
          ],
          sex: [
            { required: true, message: '性别要求;0-男;1-女;2-不限不能为空', trigger: 'blur' }
          ],
          hrId: [
            { required: true, message: '人事管理人employer不能为空', trigger: 'blur' }
          ],
          tel: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          email: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          time: [
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
              url: this.$http.adornUrl(`/demo/recruitment/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.jobId = data.recruitment.jobId
                this.dataForm.areaId = data.recruitment.areaId
                this.dataForm.recruitingNumber = data.recruitment.recruitingNumber
                this.dataForm.salary = data.recruitment.salary
                this.dataForm.jobInfo = data.recruitment.jobInfo
                this.dataForm.majorId = data.recruitment.majorId
                this.dataForm.degreeId = data.recruitment.degreeId
                this.dataForm.sex = data.recruitment.sex
                this.dataForm.hrId = data.recruitment.hrId
                this.dataForm.tel = data.recruitment.tel
                this.dataForm.email = data.recruitment.email
                this.dataForm.time = data.recruitment.time
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
              url: this.$http.adornUrl(`/demo/recruitment/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'jobId': this.dataForm.jobId,
                'areaId': this.dataForm.areaId,
                'recruitingNumber': this.dataForm.recruitingNumber,
                'salary': this.dataForm.salary,
                'jobInfo': this.dataForm.jobInfo,
                'majorId': this.dataForm.majorId,
                'degreeId': this.dataForm.degreeId,
                'sex': this.dataForm.sex,
                'hrId': this.dataForm.hrId,
                'tel': this.dataForm.tel,
                'email': this.dataForm.email,
                'time': this.dataForm.time
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
