const index = ()=>import('@/components/vue/index')
const roomAndBorad = ()=>import('@/components/vue/roomAndBorad')
const detail = ()=>import('@/components/vue/detail')
const video = ()=>import('@/components/vue/video')
export const parkMapAppRouter = [
  {
    path: '/index/:busId',
    name: 'index',
    component: index,
  },
  {
    path: '/roomAndBorad/:busId/:type',
    name: 'roomAndBorad',
    component: roomAndBorad,
  },
  {
    path: '/detail/:busId/:id/:type',
    name: 'detail',
    component: detail,
  },
  {
    path: '/video/:busId',
    name: 'video',
    component: video,
  }
]


