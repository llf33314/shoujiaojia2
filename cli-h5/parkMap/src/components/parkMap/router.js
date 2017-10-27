const index = ()=>import('@/components/parkMap/vue/index')
const roomAndBorad = ()=>import('@/components/parkMap/vue/roomAndBorad')
const detail = ()=>import('@/components/parkMap/vue/detail')
export const parkMapAppRouter = [
  {
    path: '/parkMap/index',
    name: 'index',
    component: index,
  },
  {
    path: '/parkMap/roomAndBorad/:type',
    name: 'roomAndBorad',
    component: roomAndBorad,
  },
  {
    path: '/parkMap/detail/:id/:type',
    name: 'detail',
    component: detail,
  }
]


