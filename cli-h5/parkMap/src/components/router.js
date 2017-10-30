const index = ()=>import('@/components/vue/index')
const roomAndBorad = ()=>import('@/components/vue/roomAndBorad')
const detail = ()=>import('@/components/vue/detail')
export const parkMapAppRouter = [
  {
    path: '/parkMap/index/:busId',
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


