import { createRouter, createWebHistory } from 'vue-router'
import Layout from '../layout/Layout.vue'
import AdminLogin from '../views/AdminLogin.vue'
import AdminInfo from "../views/AdminInfo";
import UserInfo from "../views/UserInfo";
import AdminHome from "../views/AdminHome";
import AccountInfo from "../views/PersonalInfo";
import PersonalInfo from "../views/PersonalInfo";
import DictionaryInfo from "../views/DictionaryInfo";
import AreaInfo from "../views/AreaInfo";


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
        path:'dictionary_info',
        name: 'DictionaryInfo',
        component: DictionaryInfo,
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
