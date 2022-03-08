<template>
  <div style="background: #545c64; width: 100vh " >
    <!--    功能区域-->
    <div style="margin: 5px 10px ">
      <el-upload :action="'/api/files/upload'" :show-file-list="false"
                 :on-success="handleFileUploadSuccess" style="display: inline-block">
        <el-button type="primary" class="ml-5">上传文件 <el-icon><Top/></el-icon></el-button>
      </el-upload>

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

      <el-button type="warning" @click="reset" style="margin: 2px 2px;">重置</el-button>
    </div>

    <!--    主体-->
    <el-table
        :data="tableData"
        border
        @selection-change="handleSelectionChange"
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
          label="文件名称"
      >
      </el-table-column>
      <el-table-column
          prop="type"
          header-align="center"
          sortable
          align="center"
          label="类型"
      >
      </el-table-column>
      <el-table-column
          prop="size"
          header-align="center"
          sortable
          align="left"
          label="文件大小"
      >
      </el-table-column>
      <el-table-column label="预览">
        <template #default="scope">
          <el-button type="primary" @click="preview(scope.row.url)">预览</el-button>
        </template>
      </el-table-column>

      <el-table-column label="下载">
        <template #default="scope">
          <el-button type="primary" @click="download(scope.row.url)">下载</el-button>
        </template>
      </el-table-column>
      <el-table-column label="启用">
        <template #default="scope">
          <el-switch v-model="scope.row.state" active-color="#13ce66" inactive-color="#ccc"
                     @change="changeEnable(scope.row)"></el-switch>
        </template>
      </el-table-column>
      <el-table-column label="操作" width="200" align="center">
        <template #default="scope">
          <el-popconfirm title="确定删除吗？" @confirm="del(scope.row.id)">
            <template #reference>
              <el-button  type="danger" >删除</el-button>
            </template>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>

    <!--    分页-->
    <div style="margin: 5px 0;display:flex;height:40px;">
      <dev style="padding-left:10px;text-align: left">
        <el-popconfirm   title="确定删除这些文件吗？" @confirm="delBatch">
          <template #reference>
            <el-button  type="danger" >
              <el-icon>
                <delete/>
              </el-icon>
            </el-button>
          </template>
        </el-popconfirm>
      </dev >
      <dev style="flex:1;text-align: center">
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
      </dev>
    </div>
  </div>


</template>


<script>
import {serverIp, serverPort} from "../../public/config";
import Search from "@element-plus/icons/lib/Search";
import request from "../utils/request";
import Top from "@element-plus/icons/lib/Top";
import Delete from "@element-plus/icons/lib/Delete";

export default {
  name: "FileInfo",
  components: {
    Search,
    Top,
    Delete
  },
  data(){

    return{
      serverIp: serverIp,
      serverPort: serverPort,
      loading: true,
      multipleSelection: [],
      currentPage: 1,
      pageSize: 10,
      total: 0,
      search:'',
      tableData:[ ],

    }
  },

  created() {
    this.load()
  },

  methods:{
    load(){
      request.get("/files/info",{
        params:{
          pageNum: this.currentPage,
          pageSize: this.pageSize,
          search: this.search

        }}).then(res => {
        console.log(res)
        this.tableData = res.data.records
        this.total = res.data.total
      })
    },
    changeEnable(row) {
      request.put("/files/info", row).then(res => {
        if (res.code === '200') {
          this.$message.success("操作成功")
        }
        else {
          this.$message.error("操作异常")
        }
      })
    },
    del(id) {
      request.delete("/files/" + id).then(res => {
        if (res.code === '200') {
          this.$message.success("删除成功")
          this.load()
        } else {
          this.$message.error("删除失败")
        }
      })
    },
    handleSelectionChange(val) {

      this.multipleSelection = val
      let ids = this.multipleSelection.map(v => v.id)

      for(let val of ids) {
        console.log(val);
      }
    },
    delBatch() {
      let ids = this.multipleSelection.map(v => v.id)  // [{}, {}, {}] => [1,2,3]
      request.post("/files/del_batch", ids).then(res => {
        if (res.code === '200') {
          this.$message.success("批量删除成功")
          this.load()
        } else {
          this.$message.error("批量删除失败")
        }
      })
    },
    reset() {
      this.search = ""
      this.load()
    },
    handleFileUploadSuccess(res) {
      console.log(res)
      this.$message.success("上传成功")
      this.load()
    },
    download(url) {
      window.open(url)
    },
    preview(url) {
      window.open('https://file.keking.cn/onlinePreview?url=' + encodeURIComponent(window.btoa((url))))
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