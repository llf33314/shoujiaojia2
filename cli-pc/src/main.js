import Vue from 'vue'
import App from './App'
import axios from './http/index'
import router from './router'
/*
 * 加载全局方法
 * */
import util  from './assets/js/util'
/*
* 加载全局组件
* */
import ElementUI from 'gt-pc-ui'
import 'gt-pc-ui/lib/theme-default/index.css'
const GtNullData = ()=>import('./components/PublicVue/null-data/nullData')
const GtCopyUrl = ()=>import('./components/PublicVue/copy-url/copy-url')
const GtMaterial = ()=>import('./components/PublicVue/material/material')
const GtRegionChoose = ()=>import('./components/PublicVue/region-choose/RegionChoose')
const GtAudio = ()=>import('./components/PublicVue/GtAudio/GtAudio')
const GtEnquire = ()=>import('./components/PublicVue/enquire/Enquire')
const GtVideoBtn = ()=>import('./components/PublicVue/video-button/video-button')
/*
* 加载全局样式
* */
require('./assets/css/public.css')
/*
* 加载全局阿里iconfont
* */
require('./assets/iconfont/iconfont.css')
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

Vue.prototype.$baseURL = 'http://192.168.3.98:7077'
/*
* 注册全局组件
* */
Vue.use(ElementUI)
Vue.component('gt-null-data',GtNullData)
Vue.component('gt-copy-url',GtCopyUrl)
Vue.component('gt-material',GtMaterial)
Vue.component('gt-region-choose',GtRegionChoose)
Vue.component('gt-audio',GtAudio)
Vue.component('gt-enquire',GtEnquire)
Vue.component('gt-video-btn',GtVideoBtn)

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  axios,
  template: '<App/>',
  components: { App }
})
