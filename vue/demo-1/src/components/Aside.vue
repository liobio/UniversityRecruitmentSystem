<template>
  <div>
    <el-menu

        style="width: 200px;height: 94vh;"
        active-text-color="#fff"
        background-color="#545c64"
        default-active="2"
        text-color="#fff"

    >
      <el-menu-item index="1">
          <el-icon><avatar /></el-icon>
          <span>管理员</span>
      </el-menu-item>
      <el-sub-menu index="2">
        <template #title>
          <el-icon><school /></el-icon>
          <span>企业管理</span>
        </template>
        <el-menu-item index="2-1">企业审核</el-menu-item>
        <el-menu-item index="2-2">企业信息</el-menu-item>
      </el-sub-menu>
      <el-menu-item index="3" >
        <el-icon><user-filled/></el-icon>
        <span>人事管理人员</span>
      </el-menu-item>
      <el-menu-item index="4">
        <el-icon><user /></el-icon>
        <span>用户</span>
      </el-menu-item>
    </el-menu>
  </div>
</template>


<script>
import {
  Avatar,
  School,
  UserFilled,
  User,
} from '@element-plus/icons-vue'

export default {
  name: "Aside",
  components:{
    Avatar,School,UserFilled,User
  }
}
</script>

<style scoped>

.el-menu-item.is-active{
  /*设置菜单选择背景颜色变化*/
  background-color: #42494f !important;

}
</style>