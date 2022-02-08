<template>
  <div class="mod-config">
    <el-form :inline="true" :model="dataForm" @keyup.enter.native="getDataList()">
      <el-form-item>
        <el-input v-model="dataForm.key" placeholder="参数名" clearable></el-input>
      </el-form-item>
      <el-form-item>
        <el-button @click="getDataList()">查询</el-button>
        <el-button v-if="isAuth('demo:resume:save')" type="primary" @click="addOrUpdateHandle()">新增</el-button>
        <el-button v-if="isAuth('demo:resume:delete')" type="danger" @click="deleteHandle()" :disabled="dataListSelections.length <= 0">批量删除</el-button>
      </el-form-item>
    </el-form>
    <el-table
      :data="dataList"
      border
      v-loading="dataListLoading"
      @selection-change="selectionChangeHandle"
      style="width: 100%;">
      <el-table-column
        type="selection"
        header-align="center"
        align="center"
        width="50">
      </el-table-column>
      <el-table-column
        prop="id"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="userId"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="name"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="sex"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="birthday"
        header-align="center"
        align="center"
        label="出生年月">
      </el-table-column>
      <el-table-column
        prop="nativePlace"
        header-align="center"
        align="center"
        label="籍贯">
      </el-table-column>
      <el-table-column
        prop="national"
        header-align="center"
        align="center"
        label="民族">
      </el-table-column>
      <el-table-column
        prop="politicalAffiliation"
        header-align="center"
        align="center"
        label="政治面貌">
      </el-table-column>
      <el-table-column
        prop="presentArea"
        header-align="center"
        align="center"
        label="现居地">
      </el-table-column>
      <el-table-column
        prop="tel"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="email"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        prop="graduatedUniversity"
        header-align="center"
        align="center"
        label="毕业高校">
      </el-table-column>
      <el-table-column
        prop="major"
        header-align="center"
        align="center"
        label="主修专业">
      </el-table-column>
      <el-table-column
        prop="degree"
        header-align="center"
        align="center"
        label="学历">
      </el-table-column>
      <el-table-column
        prop="personalIntroduction"
        header-align="center"
        align="center"
        label="个人介绍">
      </el-table-column>
      <el-table-column
        prop="expectedSalary"
        header-align="center"
        align="center"
        label="期望薪水">
      </el-table-column>
      <el-table-column
        prop="expectedJob"
        header-align="center"
        align="center"
        label="求职岗位">
      </el-table-column>
      <el-table-column
        prop="expectedArea"
        header-align="center"
        align="center"
        label="求职地区">
      </el-table-column>
      <el-table-column
        prop="projectExperience"
        header-align="center"
        align="center"
        label="项目经验">
      </el-table-column>
      <el-table-column
        prop="state"
        header-align="center"
        align="center"
        label="">
      </el-table-column>
      <el-table-column
        fixed="right"
        header-align="center"
        align="center"
        width="150"
        label="操作">
        <template slot-scope="scope">
          <el-button type="text" size="small" @click="addOrUpdateHandle(scope.row.id)">修改</el-button>
          <el-button type="text" size="small" @click="deleteHandle(scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      @size-change="sizeChangeHandle"
      @current-change="currentChangeHandle"
      :current-page="pageIndex"
      :page-sizes="[10, 20, 50, 100]"
      :page-size="pageSize"
      :total="totalPage"
      layout="total, sizes, prev, pager, next, jumper">
    </el-pagination>
    <!-- 弹窗, 新增 / 修改 -->
    <add-or-update v-if="addOrUpdateVisible" ref="addOrUpdate" @refreshDataList="getDataList"></add-or-update>
  </div>
</template>

<script>
  import AddOrUpdate from './resume-add-or-update'
  export default {
    data () {
      return {
        dataForm: {
          key: ''
        },
        dataList: [],
        pageIndex: 1,
        pageSize: 10,
        totalPage: 0,
        dataListLoading: false,
        dataListSelections: [],
        addOrUpdateVisible: false
      }
    },
    components: {
      AddOrUpdate
    },
    activated () {
      this.getDataList()
    },
    methods: {
      // 获取数据列表
      getDataList () {
        this.dataListLoading = true
        this.$http({
          url: this.$http.adornUrl('/demo/resume/list'),
          method: 'get',
          params: this.$http.adornParams({
            'page': this.pageIndex,
            'limit': this.pageSize,
            'key': this.dataForm.key
          })
        }).then(({data}) => {
          if (data && data.code === 0) {
            this.dataList = data.page.list
            this.totalPage = data.page.totalCount
          } else {
            this.dataList = []
            this.totalPage = 0
          }
          this.dataListLoading = false
        })
      },
      // 每页数
      sizeChangeHandle (val) {
        this.pageSize = val
        this.pageIndex = 1
        this.getDataList()
      },
      // 当前页
      currentChangeHandle (val) {
        this.pageIndex = val
        this.getDataList()
      },
      // 多选
      selectionChangeHandle (val) {
        this.dataListSelections = val
      },
      // 新增 / 修改
      addOrUpdateHandle (id) {
        this.addOrUpdateVisible = true
        this.$nextTick(() => {
          this.$refs.addOrUpdate.init(id)
        })
      },
      // 删除
      deleteHandle (id) {
        var ids = id ? [id] : this.dataListSelections.map(item => {
          return item.id
        })
        this.$confirm(`确定对[id=${ids.join(',')}]进行[${id ? '删除' : '批量删除'}]操作?`, '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$http({
            url: this.$http.adornUrl('/demo/resume/delete'),
            method: 'post',
            data: this.$http.adornData(ids, false)
          }).then(({data}) => {
            if (data && data.code === 0) {
              this.$message({
                message: '操作成功',
                type: 'success',
                duration: 1500,
                onClose: () => {
                  this.getDataList()
                }
              })
            } else {
              this.$message.error(data.msg)
            }
          })
        })
      }
    }
  }
</script>
