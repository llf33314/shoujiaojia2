import axios from './../../../http'

let base = 'http://192.168.3.10:7073'
/* 新增编辑分类 */
export const requestAddSort = params => { return axios.post(`${base}/app/wdownload/addType`, params).then(res => res.data) }
/*分页获取分类列表*/
export const requestGetSortList = params => { return axios.post(`${base}/app/wdownload/listType`, params).then(res => res.data) }
/*删除分类*/
export const requestDeleteSort = params => { return axios.post(`${base}/app/wdownload/delType`, params).then(res => res.data) }
/*编辑分类*/
export const requestEditSort = params => { return axios.post(`${base}/app/wdownload/modifyType`, params).then(res => res.data) }
/*分页获取下载记录列表*/
export const requestListRecord = params => { return axios.post(`${base}/app/wdownload/listRecord`, params).then(res => res.data) }
/*分页获取活动*/
export const requestListMain = params => { return axios.post(`${base}/app/wdownload/listMain`, params).then(res => res.data) }
/*修改密码*/
export const requestModifyPassWord = params => { return axios.post(`${base}/app/wdownload/modifyPwd`, params).then(res => res.data) }
/*获取所有分类列表*/
export const requestListAllType = () => { return axios.post(`${base}/app/wdownload/listAllType`).then(res => res.data) }
/*获取移动访问链接*/
export const requestGetMobileUrl = params => { return axios.post(`${base}/app/wdownload/getMobileUrl`, params).then(res => res.data) }
/*生成二维码*/
export const requestBuildQrcode = params => { return axios.get(`${base}/app/link/buildQrcode`, params).then(res => res.data) }
/*新增活动*/
export const requestAddMain = params => { return axios.get(`${base}/app/link/addMain`, params).then(res => res.data) }