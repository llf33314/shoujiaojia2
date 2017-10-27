import Vue from 'vue'
import VueRouter from 'vue-router'
// 加载小公园app
import {parkMapAppRouter} from '@/components/router.js'

Vue.use(VueRouter)

var routes = parkMapAppRouter

// 合并多个路由的数组
const router = new VueRouter({
  // mode: 'history',
  routes
});
export default router;
