<template>

  <div style="background-color: #545c64;width: 100%;height: 100vh;overflow: hidden">
    <particles/>
    <div style="text-align: center;color: white;font-size: 30px;padding-top: 200px">
      管理员登录
    </div>
    <div style="width: 600px;height:400px;margin:0 auto;" >
      <br/>
      <el-form ref="form" :model="form" >
        <el-form-item>
          <el-input v-model="form.name"
                    placeholder="Please Input"
                    :prefix-icon="Avatar"
                    size="large"
                    style="width: 300px;margin: auto auto"
          ></el-input>
        </el-form-item>
        <el-form-item>
          <el-input v-model="form.pwd"
                    type="password"
                    placeholder="Please input password"
                    show-password
                    :prefix-icon="Lock"
                    size="large"
                    style="width: 300px;margin: auto auto"
          ></el-input>
        </el-form-item>
        <el-form-item>
          <el-button
              type="primary"
              style="width: 300px;height:40px;margin:auto auto"
              @click="login"
          >登 录</el-button>
        </el-form-item>

      </el-form>
    </div>

  </div>

</template>

<script>
import {Avatar,Lock} from "@element-plus/icons-vue";
import Particles from "../components/Particles";
import request from "../utils/request";

export default {
  name: "AdminLogin",
  components:{
    Particles,
    Avatar,Lock
  },
  data(){
    return{
      Avatar,
      Lock,
      form:{
        name:"",
        pwd:"",
      }
    }
  },
  methods:{
    login(){
      request.post("/admin/login",this.form).then(res => {
        if(res.code === '200'){
          this.$message({
            type:"success",
            message:"登录成功"
          })
          localStorage.setItem("admin",JSON.stringify((res.data)))
          // console.log(res)
          this.$router.push("/admin")
        }
        else {
          this.$message({
            type:"error",
            message:res.msg

          })
        }
      })
    }
  }

}
</script>

<style scoped>
#particles-js {
  width: 100%;
  height: calc(100% - 100px);
  position: absolute;
}
</style>