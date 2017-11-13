import {
  requestGetWxJsSDK
} from './api.js'

export const wx = {
  //获取微信js-sdk
  getWxSDK(busId,shareObj) {
    console.log(wx)
    console.log(window.wx)
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
  wxReady(resData,shareObj) {
    console.log(resData, 'this.$route.params.busI')
    window.wx.config({
      debug: true, //开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
      appId: resData.data.appid, // 必填，企业号的唯一标识，此处填写企业号corpid
      timestamp: resData.data.timestamp, // 必填，生成签名的时间戳
      nonceStr: resData.data.nonce_str, // 必填，生成签名的随机串
      signature: resData.data.signature, // 必填，签名，见附录1
      jsApiList: ['getLocation','onMenuShareTimeline'] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
    });
    window.wx.ready(function () {
      window.wx.getLocation({
        type: 'wgs84', // 默认为wgs84的gps坐标，如果要返回直接给openLocation用的火星坐标，可传入'gcj02'
        success: function (res) {
          console.log(window.JSON.stringify(res), '微信获取地理位置')
          window.sessionStoreage.setItem('parkMapLatitudeAndLogitude', window.JSON.stringify({
            latitude: res.latitude, // 纬度，浮点数，范围为90 ~ -90
            longitude: res.longitude, // 经度，浮点数，范围为180 ~ -180。
          }))
        }
      });

      window.wx.onMenuShareTimeline({
        title: shareObj.title ||'', // 分享标题
        link: shareObj.link ||'', // 分享链接，该链接域名必须与当前企业的可信域名一致
        imgUrl: shareObj.imgUrl ||'', // 分享图标
        success: function () {
          // 用户确认分享后执行的回调函数
        },
        cancel: function () {
          // 用户取消分享后执行的回调函数
        }
      });

    });
    window.wx.error(function (res) {
      alert('config信息验证失败')
    });
  },
  //跳转腾讯地图
  gtToTXMap(to) {
    console.log(to, 'to')
    const domain = '//apis.map.qq.com/uri/v1/routeplan?type=walk&from=我&fromcoord='
    if (window.sessionStoreage.parkMapLatitudeAndLogitude) {
      var form = window.JSON.parse(window.sessionStoreage.parkMapLatitudeAndLogitude)
    } else {
      var form = {
        latitude: '23.08828',
        longitude: '114.43721'
      }
    }
    alert(window.location.href = domain + form.latitude + ',' + form.longitude + '&to=' + to.name +
    '&tocoord=' + to.coordinate + '&policy=1&referer=myapp')
    window.location.href = domain + form.latitude + ',' + form.longitude + '&to=' + to.name +
      '&tocoord=' + to.coordinate + '&policy=1&referer=myapp'
  }
}
