import axios from './../../../http'

let base = window.PCBASEDOMAIN;
/* 分页获取餐饮店铺 */
export const requestListEats = params => { return axios.post(`${base}/app/minipark/listEats`, params).then(res => res.data) }
/* 新增餐饮店铺 */
export const requestAddEat = params => { return axios.post(`${base}/app/minipark/addEat`, params).then(res => res.data) }
/* 修改餐饮店铺 */
export const requestModifyEat = params => { return axios.post(`${base}/app/minipark/modifyEat`, params).then(res => res.data) }
/* 删除餐饮店铺 */
export const requestDelEat = params => { return axios.post(`${base}/app/minipark/delEat`, params).then(res => res.data) }
/* 分页获取酒店店铺 */
export const requestListHotels = params => { return axios.post(`${base}/app/minipark/listHotels`, params).then(res => res.data) }
/* 新增酒店店铺 */
export const requestAddHotel = params => { return axios.post(`${base}/app/minipark/addHotel`, params).then(res => res.data) }
/* 修改酒店店铺 */
export const requestModifyHotel = params => { return axios.post(`${base}/app/minipark/modifyHotel`, params).then(res => res.data) }
/* 删除酒店店铺 */
export const requestDelHotel = params => { return axios.post(`${base}/app/minipark/delHotel`, params).then(res => res.data) }