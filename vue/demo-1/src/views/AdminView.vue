<template>
  <div style="background: #545c64; width: 100vh " >
<!--    功能区域-->
    <div style="margin: 5px 10px ">
      <el-button type="primary" @click="add">新增</el-button>
<!--      <el-button type="primary">导入</el-button>-->
<!--      <el-button type="primary">导出</el-button>-->
    </div>
<!--    搜索区域-->
    <div style="margin: 5px 10px" >
      <el-input v-model="search" placeholder="Please input" clearable style="width: 40vh">
        <template #append >
          <el-button type="primary">
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
      <el-table-column
          prop="pwd"
          header-align="center"
          align="left"

          sortable
          label="密码"
      >
      </el-table-column>
      <el-table-column
          prop="level"
          header-align="center"
          width="120"
          sortable
          align="center"
          label="管理员等级"
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
      >
      </el-table-column>
      <el-table-column
          label="操作"
          header-align="center"
          align="center"
          width="170"
      >
        <template #default="scope">
          <el-button  type="primary"  @click="handleEdit">
            编辑
          </el-button>
          <el-popconfirm title="确定删除吗？" @click="handleDetail">
            <template #reference>
              <el-button  type="danger" >删除</el-button>
            </template>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>
<!--    分页-->
    <div style="margin: 10px 0;text-align: center">
      <el-pagination background layout="prev, pager, next" :total="1000">
      </el-pagination>
    </div>
<!--    对话框-->
    <el-dialog
        v-model="dialogVisible"
        title="增加管理员"
        width="30%"
    >
      <el-form :inline="true" :model="admin_form" label-width="120px">
        <el-form-item label="姓名" required>
          <el-input v-model="admin_form.name"></el-input>
        </el-form-item>
        <el-form-item label="管理员等级" required>
          <el-select
              v-model="admin_form.level"
              placeholder="please select level"
          >
            <el-option label="1(全部权限）" value="1"></el-option>
            <el-option label="2(审核)" value="2"></el-option>
            <el-option label="3(搜索发布通告)" value="3"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="状态" required>
          <el-radio-group v-model="admin_form.state">
            <el-radio border label="1">启用</el-radio>
            <el-radio border label="0">禁用</el-radio>
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

<script>

import { Search } from "@element-plus/icons";
import request from "../utils/request";
export default {
  name: "AdminView",
  components: {
    Search
  },
  data(){
    return{
      dialogVisible:false,
      search:'',
      tableData:[
        {
          id:'1',
          registerTime: '2016-05-03',
          name: 'Tom',
          state: '启用',
          pwd: 'LosAngeles',
          level: '1',
        }
      ],
      admin_form:{
        name:'',
        level:'',
        state:'',
      },
    }
  },
  methods:{
    add(){
      this.dialogVisible=true
      this.admin_form={}
    },
    handleDetail(){},
    handleEdit(){},
    save(){
      request.post("/admin",this.admin_form).then(res=>{
        console.log(res)
      })
    },
  }
}
</script>
