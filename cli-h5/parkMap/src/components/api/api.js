import axios from './../../http'
//http://192.168.3.98:7077/swagger-ui.html#/mini-park-mobile-controller
//http://qydev.weixin.qq.com/wiki/index.php?title=%E5%BE%AE%E4%BF%A1JS-SDK%E6%8E%A5%E5%8F%A3#.E6.AD.A5.E9.AA.A4.E4.B8.80.EF.BC.9A.E5.BC.95.E5.85.A5JS.E6.96.87.E4.BB.B6
//https://vux.li/#/
let base = window.MOBILEBASEDOMAIN
// 分页获酒店铺列表
export const requestListHotels = params => { return axios.post(`${base}/m/minipark/listHotels`, params).then(res => res.data) }
// 分页获取餐饮店铺列表
export const requestListEates = params => { return axios.post(`${base}/m/minipark/listEats`, params).then(res => res.data) }
// 获取餐饮店铺详情
export const requestGetEat = params => { return axios.post(`${base}/m/minipark/getEat`, params).then(res => res.data) }
// 获取酒店店铺详情
export const requestGetHotel = params => { return axios.post(`${base}/m/minipark/getHotel`, params).then(res => res.data) }
//getWxJsSDK
export const requestGetWxJsSDK = params => { return axios.post(`${base}/app/wxPublic/getWxJsSDK`, params).then(res => res.data) }