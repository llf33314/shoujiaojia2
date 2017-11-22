import {
  requestGetWxJsSDK
} from './api.js'

export const wx = {
  //获取微信js-sdk
  getWxSDK(busId,shareObj) {
    requestGetWxJsSDK(busId, {
      "shareUrl": window.location.href,
    }).then((res) => {
      //测试
      console.log(res)
      if (!res.code) {
        alert(res.msg,'shareurl') 
        //return
      }
      this.wxReady(res,shareObj)
    })
  },  
  LatitudeAndLogitude:null,
  wxReady(resData,shareObj) {
    const self = this
    //console.log(resData, 'this.$route.params.busI')
    window.wx.config({
      debug: false, //开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
      appId: resData.data.appid, // 必填，企业号的唯一标识，此处填写企业号corpid
      timestamp: resData.data.timestamp, // 必填，生成签名的时间戳
      nonceStr: resData.data.nonce_str, // 必填，生成签名的随机串
      signature: resData.data.signature, // 必填，签名，见附录1
      jsApiList: ['getLocation','onMenuShareAppMessage','onMenuShareTimeline','WeixinJSBridgeReady'] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
    });
    
  },
  //跳转腾讯地图
  gtToTXMap(to) {
    const domain = '//apis.map.qq.com/uri/v1/routeplan?type=walk&from=我&fromcoord='
    var form = window.dataPack.logLan;
    
    window.location.href = domain + form.latitude + ',' + form.longitude + '&to=' + to.name +
      '&tocoord=' + to.coordinate+ '&policy=1&referer=myapp'
  }
}
