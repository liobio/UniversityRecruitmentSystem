<template>
  <div style="background: #545c64; width: 100vh" >
<!--    功能区域-->
    <div style="margin: 5px 10px ">
      <el-button type="primary">新增</el-button>
      <el-button type="primary">导入</el-button>
      <el-button type="primary">导出</el-button>
    </div>
<!--    搜索区域-->
    <div style="margin: 5px 10px ">
      <el-input v-model="input" placeholder="输入关键字搜索" style="width: 20%;"/>
      <el-button type="primary" style="margin: 5px">搜索</el-button>
    </div>
<!--    主体-->
    <el-table :data="tableData" border stripe style="  width:99%;margin: 10px">
      <el-table-column prop="date" label="Date" width="150"   sortable/>
      <el-table-column prop="name" label="Name" width="120"   sortable/>
      <el-table-column prop="state" label="State" width="120" sortable/>
      <el-table-column prop="city" label="City" width="120"   sortable/>
      <el-table-column prop="address" label="Address" width="990" />
      <el-table-column label="Operations" width="200">
        <template #default>
          <el-button type="primary"  @click="handleEdit">
            Edit
          </el-button>
          <el-popconfirm title="Are you sure to delete this?">
            <template #reference>
              <el-button type="danger">Delete</el-button>
            </template>
          </el-popconfirm>

        </template>
      </el-table-column>
    </el-table>
    <div style="margin: 10px 0;">
      <el-pagination background layout="prev, pager, next" :total="1000">
      </el-pagination>
    </div>
  </div>
</template>

<script>

import { Edit, Share, Delete, Search, Upload } from '@element-plus/icons-vue'
export default {
  name: "Home",
  components: {
    Search,
    Edit,
    Share,
    Delete,
    Upload
  },
  data(){
    return{
      input:'',
      tableData:[ {
        date: '2016-05-03',
        name: 'Tom',
        state: 'California',
        city: 'Los Angeles',
        address: 'No. 189, Grove St, Los Angeles',
        zip: 'CA 90036',
        tag: 'Home',
      },
        {
          date: '2016-05-02',
          name: 'Tom',
          state: 'California',
          city: 'Los Angeles',
          address: 'No. 189, Grove St, Los Angeles',
          zip: 'CA 90036',
          tag: 'Office',
        },
        {
          date: '2016-05-04',
          name: 'Tom',
          state: 'California',
          city: 'Los Angeles',
          address: 'No. 189, Grove St, Los Angeles',
          zip: 'CA 90036',
          tag: 'Home',
        },
        {
          date: '2016-05-01',
          name: 'Tom',
          state: 'California',
          city: 'Los Angeles',
          address: 'No. 189, Grove St, Los Angeles',
          zip: 'CA 90036',
          tag: 'Office',
        }
        ]
    }
  },
  methods:{
    handleDetail(){

    },
    handleEdit(){

    }

  }
}
</script>
