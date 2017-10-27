import axios from './../../../http'
//http://192.168.3.98:7077/swagger-ui.html#/mini-park-mobile-controller
let base = 'http://192.168.3.98:7077'
// 分页获酒店铺列表
export const requestListHotels = params => { return axios.post(`${base}/m/minipark/listHotels`, params).then(res => res.data) }
// 分页获取餐饮店铺列表
export const requestListEates = params => { return axios.post(`${base}/m/minipark/listEats`, params).then(res => res.data) }
// 获取餐饮店铺详情
export const requestGetEat = params => { return axios.post(`${base}/m/minipark/getEat`, params).then(res => res.data) }
// 获取酒店店铺详情
export const requestGetHotel = params => { return axios.post(`${base}/m/minipark/getHotel`, params).then(res => res.data) }