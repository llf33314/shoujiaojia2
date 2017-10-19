const index = () => import('@/components/parkMap/vue/index')
const eatList = () => import('@/components/parkMap/vue/eatList')
const hotelList = () => import('@/components/parkMap/vue/hotelList')
const addEat = () => import('@/components/parkMap/vue/addEat')
const modifyEat = () => import('@/components/parkMap/vue/modifyEat')
const addHotel = () => import('@/components/parkMap/vue/addHotel')
const modifyHotel = () => import('@/components/parkMap/vue/modifyHotel')
export const parkMapAdminRouter = [
  {
    path: '/parkMapAdmin/index',
    name: 'index',
    component: index,
    redirect: '/parkMapAdmin/eatList',
    children: [
      {
        path: '/parkMapAdmin/eatList',
        name: 'eatList',
        component: eatList,
      },
      {
        path: '/parkMapAdmin/hotelList',
        name: 'hotelList',
        component: hotelList,
      }
    ]
  },
  {
    path: '/parkMapAdmin/addEat',
    name: 'addEat',
    component: addEat,
  },
  {
    path: '/parkMapAdmin/modifyEat',
    name: 'modifyEat',
    component: modifyEat,
  },
  {
    path: '/parkMapAdmin/addHotel',
    name: 'addHotel',
    component: addHotel,
  },
  {
    path: '/parkMapAdmin/modifyHotel/:id',
    name: 'modifyHotel',
    component: modifyHotel,
  },
]


