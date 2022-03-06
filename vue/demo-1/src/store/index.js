import { createStore } from 'vuex'
import router from "../router";

export default createStore({
  state: {
  },
  mutations: {
    logout() {
      // 清空缓存

      localStorage.removeItem("admin")
      console.log("logout清空缓存")
      console.log(localStorage.getItem("admin"))
      router.push("/admin/login")
    }
  },
  actions: {
  },
  modules: {
  }
})
