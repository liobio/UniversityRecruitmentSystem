<template>
  <div>
    <el-menu
        style="width: 200px;height: 94vh;position:relative"
        active-text-color="#fff"
        background-color="#545c64"
        :default-active=$route.path.substr(7)
        text-color="#fff"
        router
    >
      <el-menu-item index="admin_home">
        <el-icon><home-filled/></el-icon>
        <span>首页</span>
      </el-menu-item>
      <el-menu-item index="admin_info">
          <el-icon><avatar /></el-icon>
          <span>管理员管理</span>
      </el-menu-item>

      <el-sub-menu index="company">
        <template #title>
          <el-icon><school /></el-icon>
          <span>企业管理</span>
        </template>
        <el-menu-item index="audit">企业审核</el-menu-item>
        <el-menu-item index="info">企业信息</el-menu-item>
      </el-sub-menu>
      <el-menu-item index="hr_info" >
        <el-icon><user-filled/></el-icon>
        <span>HR管理</span>
      </el-menu-item>
      <el-menu-item index="user_info">
        <el-icon><user /></el-icon>
        <span>用户管理</span>
      </el-menu-item>
      <el-menu-item index="files_info">
        <el-icon><user /></el-icon>
        <span>文件管理</span>
      </el-menu-item>
      <el-sub-menu index="dic">
        <template #title>
          <el-icon><info-filled/></el-icon>
          <span>字典管理</span>
        </template>
        <el-menu-item index="area_info">区域信息</el-menu-item>
        <el-menu-item index="native_place">籍贯信息</el-menu-item>
      </el-sub-menu>
    </el-menu>
  </div>
</template>


<script>
import {
  Avatar,
  School,
  UserFilled,
  User,
  HomeFilled,
  InfoFilled,
} from '@element-plus/icons-vue'


export default {
  name: "Aside",
  components:{
    Avatar,School,UserFilled,User,HomeFilled,InfoFilled
  },
  created() {
    console.log(this.$route.path)
  }
}
</script>

<style scoped>

.el-menu-item.is-active{
  /*设置菜单选择背景颜色变化*/
  background-color: #42494f !important;

}
</style>