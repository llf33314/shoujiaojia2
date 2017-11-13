// 异步加载
const dome222 = () => import('@/components/Dome2/vue/index')
const dome22 = () => import('@/components/Dome2/vue/index2')
export const domeRouter2 = [
  {
    path: '/dome2/index',
    name: 'dome222',
    component: dome222
  },
  {
    path: '/dome2/index2',
    name: 'dome22',
    component: dome22
  }
]
