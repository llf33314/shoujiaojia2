import axios from './../../../http'

let base = 'http://192.168.3.10:7073'
/* 新增编辑分类 */
export const requestAddSort = params => { return axios.post(`${base}/app/wdownload/addType`, params).then(res => res.data) }