const index = ()=>import('@/components/parkMap/vue/index')
const roomAndBorad = ()=>import('@/components/parkMap/vue/roomAndBorad')
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
  }
]


