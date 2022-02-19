<template>

  <div style="height: 55px;line-height: 50px;border-bottom: 1px solid #ccc;display: flex;background:#545c64">
    <div style="width: 200px ;padding-left: 25px;font-weight: bold;color: white;background:#545c64">
      校园招聘后台管理
    </div>
    <div style="flex: 1"></div>
    <div style="width: 120px">
      <el-dropdown>
      <el-button color="545c64" type="primary" >
       管理员<el-icon class="el-icon--right"><arrow-down /></el-icon>
      </el-button>
      <template #dropdown>
        <el-dropdown-menu>
          <el-dropdown-item>个人信息</el-dropdown-item>
          <el-dropdown-item>修改密码</el-dropdown-item>
          <el-dropdown-item divided @click="$router.push('/login')">退出</el-dropdown-item>
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
  }
}
</script>

<style scoped>

</style>