import { createRouter, createWebHistory } from 'vue-router'
import Layout from '../layout/Layout.vue'
import AdminLogin from '../views/AdminLogin.vue'
import Admin from "../views/Admin";


const routes = [
  {
    path: '/',
    name: 'Layout',
    component: Layout,
    redirect: "/login",
    children: [
      {
        path: 'admin',
        name: 'Admin',
        component: Admin
      }
    ]
  },
  {
    path: '/login',
    name: 'AdminLogin',
    component: AdminLogin
  }

]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
