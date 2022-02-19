import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementPlus from 'element-plus'
import 'element-plus/theme-chalk/index.css'
import '@/assets/css/global.css'
import zhCn from 'element-plus/es/locale/lang/zh-cn'
import VueParticles from 'vue-particles'

createApp(App).use(VueParticles).use(store).use(ElementPlus,{locale:zhCn}).use(router).mount('#app')
