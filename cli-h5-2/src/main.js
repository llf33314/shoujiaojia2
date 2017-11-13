import Vue from 'vue'
import App from './App'
import axios from './http/index'
import router from './router'
require('normalize.css')
/*
 * 加载全局方法
 * */
Vue.prototype.axios = axios
/*
* 在启动时生成生产提示
* */
Vue.config.productionTip = false
Vue.config.devtools = true
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  axios,
  template: '<App/>',
  components: { App }
})
