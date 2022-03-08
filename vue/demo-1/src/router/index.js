import { createRouter, createWebHistory } from 'vue-router'
import Layout from '../layout/Layout.vue'
import AdminLogin from '../views/AdminLogin.vue'
import AdminInfo from "../views/AdminInfo";
import UserInfo from "../views/UserInfo";
import AdminHome from "../views/AdminHome";
import AreaInfo from "../views/AreaInfo";
import FilesInfo from "../views/FilesInfo";


const routes = [
  {
    path: '/admin/login',
    name: 'AdminLogin',
    component: AdminLogin
  },
  {
    path: '/admin',
    name: 'Layout',
    component: Layout,
    redirect: "/admin/admin_home",
    children: [
      {
        path: 'admin_home',
        name: 'AdminHome',
        component: AdminHome
      },
      {
        path: 'admin_info',
        name: 'AdminInfo',
        component: AdminInfo
      },
      {
        path: 'user_info',
        name: 'UserInfo',
        component: UserInfo
      },
      {
        path: 'files_info',
        name: 'FilesInfo',
        component: FilesInfo
      },
      {
        path:'area_info',
        name:'AreaInfo',
        component:AreaInfo
      },
    ]
  },


]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
