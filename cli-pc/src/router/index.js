import Vue from 'vue'
import VueRouter from 'vue-router'
// 加载小公园app
import {parkMapAdminRouter} from '@/components/parkMap/router.js'

Vue.use(VueRouter)
var routes = []

// 合并多个路由的数组
routes = routes.concat(parkMapAdminRouter)

const router = new VueRouter({
  // mode: 'history',
  routes
});

/*router.beforeEach((to, from, next) => {
  let user = window.JSON.parse(localStorage.getItem('user'))
  if (!user && to.path !== '/login') {
    next({path: '/login'})
  } else {
    next()
  }

  if (window.localStorage.getItem('tocken')) {
    if (window.localStorage.getItem('tocken')) {
      next();
    }
    else {
      next({
        path: '/login',
        query: {redirect: to.fullPath}
      })
    }
  }
  else {
    next();
  }
})*/
export default router;
