import Vue from 'vue'
import Router from 'vue-router'
// 加载演示项目路由
import { domeRouter } from '@/components/dome/router.js'
import { domeRouter2 } from '@/components/dome2/router.js'
Vue.use(Router)
var routes = [
]
routes = routes.concat(domeRouter)
routes = routes.concat(domeRouter2)
const router = new Router({
  routes
});

export default router;
