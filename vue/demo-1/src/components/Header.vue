<template>

  <div style="height: 55px;line-height: 50px;border-bottom: 1px solid #ccc;display: flex;background:#545c64">
    <div style="width: 200px ;padding-left: 25px;font-weight: bold;color: white;background:#545c64">
      校园招聘后台管理
    </div>
    <div style="flex: 1"></div>
    <div style="display: inline-block;width: 35px">
      <img :src=admin.avatarUrl alt=""
           style="width: 40px;border-radius: 10%; position: relative; top: 7px; right: 10px">
    </div>
    <div style="width: 120px">

      <el-dropdown >
        <el-button color="545c64" type="primary"
        size="large">
          <span style="font-size: 20px">{{admin.name}}</span>
          <el-icon class="el-icon--right"><arrow-down /></el-icon>
        </el-button>
        <template #dropdown>
          <el-dropdown-menu>
            <el-dropdown-item>个人信息</el-dropdown-item>
            <el-dropdown-item>修改密码</el-dropdown-item>
            <el-dropdown-item divided @click="logout">退出</el-dropdown-item>
          </el-dropdown-menu>
        </template>
      </el-dropdown>
    </div>
  </div>
</template>

<script>
import {
  ArrowDown,
 } from '@element-plus/icons-vue'
export default {
  name: "Header",
  components:{
    ArrowDown,
  },
  data(){
    return {
      admin : localStorage.getItem("admin") ? JSON.parse(localStorage.getItem("admin")) : {

      }
    }
  },
  methods:{
    logout() {
      this.$store.commit("logout")
      this.$message.success("退出成功")
      console.log(localStorage.getItem("admin"))
    }
  }
}
</script>

<style scoped>

</style>