// 异步加载
const dome = () => import('@/components/Dome/vue/index')
const dome2 = () => import('@/components/Dome/vue/index2')
export const domeRouter = [
  {
    path: '/dome/index',
    name: 'dome',
    component: dome
  },
  {
    path: '/dome/index2',
    name: 'dome2',
    component: dome2
  }
]
