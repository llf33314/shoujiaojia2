import Vue from 'vue'
import App from './App'
import axios from './http/index'
import router from './router'
require('./assets/css/swiper-3.4.2.min.css')
require('./assets/css/public.css')
/*
* 挂载全局axsio方法
* */
Vue.prototype.axios = axios
/*
* 在启动时生成生产提示
* */
Vue.config.productionTip = false
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
