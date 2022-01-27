<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="userId">
      <el-input v-model="dataForm.userId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="name">
      <el-input v-model="dataForm.name" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="sex">
      <el-input v-model="dataForm.sex" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="出生年月" prop="birthday">
      <el-input v-model="dataForm.birthday" placeholder="出生年月"></el-input>
    </el-form-item>
    <el-form-item label="籍贯" prop="nativePlace">
      <el-input v-model="dataForm.nativePlace" placeholder="籍贯"></el-input>
    </el-form-item>
    <el-form-item label="民族" prop="national">
      <el-input v-model="dataForm.national" placeholder="民族"></el-input>
    </el-form-item>
    <el-form-item label="政治面貌" prop="politicalAffiliation">
      <el-input v-model="dataForm.politicalAffiliation" placeholder="政治面貌"></el-input>
    </el-form-item>
    <el-form-item label="现居地" prop="presentArea">
      <el-input v-model="dataForm.presentArea" placeholder="现居地"></el-input>
    </el-form-item>
    <el-form-item label="" prop="tel">
      <el-input v-model="dataForm.tel" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="email">
      <el-input v-model="dataForm.email" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="毕业高校" prop="graduatedUniversity">
      <el-input v-model="dataForm.graduatedUniversity" placeholder="毕业高校"></el-input>
    </el-form-item>
    <el-form-item label="主修专业" prop="major">
      <el-input v-model="dataForm.major" placeholder="主修专业"></el-input>
    </el-form-item>
    <el-form-item label="学历" prop="degree">
      <el-input v-model="dataForm.degree" placeholder="学历"></el-input>
    </el-form-item>
    <el-form-item label="个人介绍" prop="personalIntroduction">
      <el-input v-model="dataForm.personalIntroduction" placeholder="个人介绍"></el-input>
    </el-form-item>
    <el-form-item label="期望薪水" prop="expectedSalary">
      <el-input v-model="dataForm.expectedSalary" placeholder="期望薪水"></el-input>
    </el-form-item>
    <el-form-item label="求职岗位" prop="expectedJob">
      <el-input v-model="dataForm.expectedJob" placeholder="求职岗位"></el-input>
    </el-form-item>
    <el-form-item label="求职地区" prop="expectedArea">
      <el-input v-model="dataForm.expectedArea" placeholder="求职地区"></el-input>
    </el-form-item>
    <el-form-item label="项目经验" prop="projectExperience">
      <el-input v-model="dataForm.projectExperience" placeholder="项目经验"></el-input>
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
          userId: '',
          name: '',
          sex: '',
          birthday: '',
          nativePlace: '',
          national: '',
          politicalAffiliation: '',
          presentArea: '',
          tel: '',
          email: '',
          graduatedUniversity: '',
          major: '',
          degree: '',
          personalIntroduction: '',
          expectedSalary: '',
          expectedJob: '',
          expectedArea: '',
          projectExperience: '',
          state: ''
        },
        dataRule: {
          userId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          name: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          sex: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          birthday: [
            { required: true, message: '出生年月不能为空', trigger: 'blur' }
          ],
          nativePlace: [
            { required: true, message: '籍贯不能为空', trigger: 'blur' }
          ],
          national: [
            { required: true, message: '民族不能为空', trigger: 'blur' }
          ],
          politicalAffiliation: [
            { required: true, message: '政治面貌不能为空', trigger: 'blur' }
          ],
          presentArea: [
            { required: true, message: '现居地不能为空', trigger: 'blur' }
          ],
          tel: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          email: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          graduatedUniversity: [
            { required: true, message: '毕业高校不能为空', trigger: 'blur' }
          ],
          major: [
            { required: true, message: '主修专业不能为空', trigger: 'blur' }
          ],
          degree: [
            { required: true, message: '学历不能为空', trigger: 'blur' }
          ],
          personalIntroduction: [
            { required: true, message: '个人介绍不能为空', trigger: 'blur' }
          ],
          expectedSalary: [
            { required: true, message: '期望薪水不能为空', trigger: 'blur' }
          ],
          expectedJob: [
            { required: true, message: '求职岗位不能为空', trigger: 'blur' }
          ],
          expectedArea: [
            { required: true, message: '求职地区不能为空', trigger: 'blur' }
          ],
          projectExperience: [
            { required: true, message: '项目经验不能为空', trigger: 'blur' }
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
              url: this.$http.adornUrl(`/demo/resume/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.userId = data.resume.userId
                this.dataForm.name = data.resume.name
                this.dataForm.sex = data.resume.sex
                this.dataForm.birthday = data.resume.birthday
                this.dataForm.nativePlace = data.resume.nativePlace
                this.dataForm.national = data.resume.national
                this.dataForm.politicalAffiliation = data.resume.politicalAffiliation
                this.dataForm.presentArea = data.resume.presentArea
                this.dataForm.tel = data.resume.tel
                this.dataForm.email = data.resume.email
                this.dataForm.graduatedUniversity = data.resume.graduatedUniversity
                this.dataForm.major = data.resume.major
                this.dataForm.degree = data.resume.degree
                this.dataForm.personalIntroduction = data.resume.personalIntroduction
                this.dataForm.expectedSalary = data.resume.expectedSalary
                this.dataForm.expectedJob = data.resume.expectedJob
                this.dataForm.expectedArea = data.resume.expectedArea
                this.dataForm.projectExperience = data.resume.projectExperience
                this.dataForm.state = data.resume.state
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
              url: this.$http.adornUrl(`/demo/resume/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'userId': this.dataForm.userId,
                'name': this.dataForm.name,
                'sex': this.dataForm.sex,
                'birthday': this.dataForm.birthday,
                'nativePlace': this.dataForm.nativePlace,
                'national': this.dataForm.national,
                'politicalAffiliation': this.dataForm.politicalAffiliation,
                'presentArea': this.dataForm.presentArea,
                'tel': this.dataForm.tel,
                'email': this.dataForm.email,
                'graduatedUniversity': this.dataForm.graduatedUniversity,
                'major': this.dataForm.major,
                'degree': this.dataForm.degree,
                'personalIntroduction': this.dataForm.personalIntroduction,
                'expectedSalary': this.dataForm.expectedSalary,
                'expectedJob': this.dataForm.expectedJob,
                'expectedArea': this.dataForm.expectedArea,
                'projectExperience': this.dataForm.projectExperience,
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
