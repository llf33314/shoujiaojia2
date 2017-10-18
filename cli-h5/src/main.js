import Vue from 'vue'
import App from './App'
import axios from './http/index'
import router from './router'
/*
 * 加载全局方法
 * */
import  util  from './assets/js/util'
/*
* 加载全局组件
* */
/*
* 加载全局样式
* */
/*
* 加载全局阿里iconfont
* */
/*
* 挂载全局axsio方法
* */
Vue.prototype.axios = axios
/*
* 在启动时生成生产提示
* */
Vue.config.productionTip = false
/*
* 挂载全局方法
* */
Vue.prototype.$util = util  

Vue.prototype.$baseURL = 'http://192.168.3.98:7073'
/*
* 注册全局组件
* */

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  axios,
  template: '<App/>',
  components: { App }
})
