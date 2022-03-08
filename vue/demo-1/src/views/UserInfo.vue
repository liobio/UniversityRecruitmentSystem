<template>
  <div style="background: #545c64; width: 100vh " >
    <!--    功能区域-->
    <div style="margin: 5px 10px ">
      <el-button type="primary" @click="add">新增</el-button>
    </div>
    <!--    搜索区域-->
    <div style="margin: 5px 10px" >
      <el-input v-model="search" placeholder="Please input" clearable style="width: 40vh">
        <template #append >
          <el-button type="primary" @click="load">
            <el-icon >
              <Search />
            </el-icon>
            查询
          </el-button>
        </template>
      </el-input>
    </div>
    <!--    主体-->

    <el-table
        :data="tableData"
        border
        max-height="700"
        stripe
        style="width:99%;margin: 10px">
      <el-table-column
          type="selection"
          header-align="center"
          align="center"
      >
      </el-table-column>
      <el-table-column
          prop="id"
          header-align="center"
          align="center"
          label="ID"
          width="80"
          sortable
      >
      </el-table-column>
      <el-table-column
          prop="name"
          header-align="center"
          align="left"
          sortable
          label="姓名"
      >
      </el-table-column>
<!--      <el-table-column-->
<!--          prop="pwd"-->
<!--          header-align="center"-->
<!--          align="left"-->
<!--          sortable-->
<!--          label="密码"-->
<!--      >-->
<!--      </el-table-column>-->
      <el-table-column
          prop="tel"
          header-align="center"
          sortable
          align="center"
          label="电话号码"
      >
      </el-table-column>
      <el-table-column
          prop="email"
          header-align="center"
          sortable
          align="left"
          label="电子邮箱"
      >
      </el-table-column>
      <el-table-column
          prop="registerTime"
          header-align="center"
          align="center"
          sortable
          label="注册时间"
      >
      </el-table-column>
      <el-table-column
          prop="state"
          header-align="center"
          align="center"
          width="80"
          sortable
          label="状态"
          :formatter="stateFormat"
      >
      </el-table-column>
      <el-table-column
          label="操作"
          header-align="center"
          align="center"
          width="170"
      >
        <template #default="scope">
          <el-button  type="primary"  @click="handleEdit(scope.row)">
            编辑
          </el-button>
          <el-popconfirm title="确定删除吗？" @confirm="handleDetail(scope.row.id)">
            <template #reference>
              <el-button  type="danger" >删除</el-button>
            </template>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>
    <!--    分页-->
    <div style="margin: 10px 0;text-align: center">
      <el-pagination class="el-pagination_Color"
                     background
                     @size-change="handleSizeChange"
                     @current-change="handleCurrentChange"
                     :current-page="currentPage"
                     :page-sizes="[10, 20, 50]"
                     :page-size="pageSize"
                     layout="total, sizes, prev, pager, next, jumper"
                     :total="total"

      >
      </el-pagination>
    </div>
    <!--    对话框-->
    <el-dialog
        v-model="dialogVisible"
        title="增加管理员"
        width="30%"
    >
      <el-form :inline="true" :model="user_form" label-width="120px">
        <el-form-item label="姓名" required>
          <el-input v-model="user_form.name"></el-input>
        </el-form-item>
<!--        <el-form-item label="密码" required>-->
<!--          <el-input v-model="user_form.pwd"></el-input>-->
<!--        </el-form-item>-->
        <el-form-item label="电话号码" required>
          <el-input v-model="user_form.tel"></el-input>
        </el-form-item>
        <el-form-item label="电子邮箱" required>
          <el-input v-model="user_form.email"></el-input>
        </el-form-item>
        <el-form-item label="状态" required>
          <el-radio-group v-model="user_form.state">
            <el-radio border :label="1">启用</el-radio>
            <el-radio border :label="0">禁用</el-radio>
          </el-radio-group>
        </el-form-item>
      </el-form>
      <template #footer>
        <el-button @click="dialogVisible = false">取消</el-button>
        <el-button type="primary" @click="save">确定</el-button>
      </template>
    </el-dialog>

  </div>
</template>

import { Search } from "@element-plus/icons";
import request from "../utils/request";
<script>
import {Search} from "@element-plus/icons";
import request from "../utils/request";

export default {
  name: "UserInfo",
  components: {
    Search
  },
  data(){

    return{
      loading: true,
      currentPage: 1,
      pageSize: 10,
      total: 0,
      dialogVisible:false,
      search:'',
      tableData:[ ],
      user_form:{
        id:'',
        name:'',
        pwd:'',
        tel:'',
        email:'',
        state:'',
      },
    }
  },

  created() {
    this.load()
  },

  methods:{
    load(){
      request.get("/user/user_info",{
        params:{
          pageNum: this.currentPage,
          pageSize: this.pageSize,
          search: this.search

        }}).then(res => {
        // console.log(res)
        this.tableData = res.data.records
        this.total = res.data.total
      })
    },

    add(){
      this.dialogVisible=true
      this.user_form={}
    },
    handleDetail(id){
      // console.log(id)
      request.delete("/user/user_info/"+id).then(res=>{
        if(res.code=='200'){
          this.$message({
            type:"success",
            message:"删除成功"
          })
          this.load()
        }
        else {
          this.$message({
            type:"error",
            message:"删除失败"
          })
        }
      })
    },
    handleEdit(row){
      this.user_form= JSON.parse(JSON.stringify(row))
      // console.log(this.user_form)
      this.dialogVisible=true
    },
    stateFormat(row){
      // console.log(row.state)
      return row.state=='1'?'启用':'禁用';
    },
    save(){

      if(this.user_form.id){
        request.put("/user/user_info",this.user_form).then(res=>{
          // console.log(res)
          if(res.code=='200'){
            this.$message({
              type:"success",
              message:"更新成功"
            })
            this.load()
            this.dialogVisible=false
          }
          else {
            this.$message({
              type:"error",
              message:"更新失败"
            })
          }
        })
      }
      else {
        request.post("/user/user_info",this.user_form).then(res=>{
          // console.log(res)
          if(res.code=='200'){
            this.$message({
              type:"success",
              message:"添加成功"

            })
            this.load()
            this.dialogVisible=false
          }
          else {
            this.$message({
              type:"error",
              message:"添加失败"

            })
          }
        })
      }

    },
    handleSizeChange(pageSize) {   // 改变当前每页的个数触发
      this.pageSize = pageSize
      this.load()
    },
    handleCurrentChange(pageNum) {  // 改变当前页码触发
      this.currentPage = pageNum
      this.load()
    },
  }


}
</script>

<style scoped>

.el-pagination_Color
/deep/ .el-pagination__total {
  color: #ffffff;
}
/deep/ .el-pagination__jump {
  color: #ffffff;
}

</style>