<template>
  <div id="app">
    <transition :name="transitionName">
      <router-view class="child-view"></router-view>
    </transition>
  </div>
</template>
<script>
  import {
    requestGetWxJsSDK
  } from './components/api/api'
  export default {
    name: 'app',
    data() {
      return {
        transitionName: 'slide-left',
        getWxSDKFlag: true
      }
    },
    watch: {
      '$route' (to, from) {
        const toDepth = to.path.split('/').length
        const fromDepth = from.path.split('/').length
        this.transitionName = toDepth < fromDepth ? 'slide-right' : 'slide-left'
        //限制请求一次
        if (this.getWxSDKFlag) this.getWxSDK()
      }
    },
    methods: {
      //获取微信js-sdk
      getWxSDK() {
        if (!this.$route.params.busId) return alert('busId为空')
        requestGetWxJsSDK(this.$route.params.busId, {
          "shareUrl": window.location.href,
        }).then((res) => {
          console.log('请求一次sdk')
          if (res.code != 100) return alert(res.msg)
          this.getWxSDKFlag = false
          window.wx.config({
            debug: false, //开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
            appId: res.data.appid, // 必填，企业号的唯一标识，此处填写企业号corpid
            timestamp: res.data.timestamp, // 必填，生成签名的时间戳
            nonceStr: res.data.nonce_str, // 必填，生成签名的随机串
            signature: res.data.signature, // 必填，签名，见附录1
            jsApiList: ['getLocation', 'onMenuShareAppMessage', 'onMenuShareTimeline'] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
          });
          window.dataPack.getWXLocation()
        })
      },
    }
  }

</script>

<style scoped>
  .child-view {
    position: absolute;
    left: 0;
    top: 0;
    width: 100%;
    height: 100%;
    transition: all .5s cubic-bezier(.55, 0, .1, 1);
  }

  .slide-left-enter,
  .slide-right-leave-active {
    opacity: 0;
    -webkit-transform: translate(30px, 0);
    transform: translate(30px, 0);
  }

  .slide-left-leave-active,
  .slide-right-enter {
    opacity: 0;
    -webkit-transform: translate(-30px, 0);
    transform: translate(-30px, 0);
  }

</style>
