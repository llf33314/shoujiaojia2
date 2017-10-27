<template>
  <section>
    <div class="map-p-style" :style="wStyle">
      <div class="map-c-style" :style="wStyle" id="mapPs">
        <div class="map-cc-style" ref="mapScale">
          <div id="mapCstyle" class="map-c" style="z-index:8">
            <div v-for="(item,index) in tourList" @click="showDetail(item)" :style="item.position" class="detail-item"></div>
          </div>
          <embed src="./static/imgs/map.svg" class="map-c" style="z-index:1" type="image/svg+xml" pluginspage="http://www.adobe.com/svg/viewer/install/"
          />
        </div>
      </div>
    </div>
    <div class="tab">
      <div class="item border05 border-right border-top" @click="showTourItem">景点</div>
      <div class="item border05 border-top" @click="showRoomBoard">周边吃住</div>
    </div>
    <ul class="tour-item left" id="tourItem" v-show="tourItemsState" :style="tourIitemHeight">
      <li class="border05 border-bottom border-right" v-for="(item,index) in tourList" @click="goToTour(item)" v-text="item.name"></li>
    </ul>
    <ul class="tour-item right" v-show="roomAndBoradListState" :style="tourIitemHeight">
      <li class="border05 border-bottom  border-left" v-for="(item,index) in roomAndBoradList" @click="goToRoomAndBorad(item)"
        v-text="item.name"></li>
    </ul>

    <div class="tour-detail-mask" v-if="showTourDetailMask" @click="showTourDetailMask=false">
      <div class="tour-detail-top" v-if="audioViewState">
        <span v-text="tourName" style="padding-left:15px;"></span>
        <audio style="width:50px" id="myAudio1">
          <source :src="audioSrcGroup.chUrl" type="audio/mp4" />
        </audio>
        <audio style="width:50px" id="myAudio2">
          <source :src="audioSrcGroup.enUrl" type="audio/mp4" />
        </audio>
        <ul>
          <li>
            <img @click.stop="switchAudioType" v-show="audioType == true" src="./../../assets/img/ch.png" />
            <img @click.stop="switchAudioType" v-show="audioType == false" src="./../../assets/img/en.png" />
          </li>
          <li>
            <img @click.stop="openOrcloseVideo" v-show="audioSrcIcon == true" src="./../../assets/img/commentary.png" />
            <img @click.stop="openOrcloseVideo" v-show="audioSrcIcon == false" src="./../../assets/img/closeVideo.png" />
          </li>
        </ul>
      </div>
      <div class="tour-detail">
        <div class="tour-items">
          <ul>
            <li v-show="tourTabView==1">
              <swiper :options="swiperOption" style="min-height:200px;max-height:300px;">
                <swiper-slide v-for="(item,index) in swiperSlides" :key="index">
                  <img :src="item" alt="item" style="max-width:100%;">
                </swiper-slide>
                <div v-show="swiperSlides.length >1" class="swiper-pagination" slot="pagination"></div>
              </swiper>

            </li>
            <li v-show="tourTabView==2" class="tour-introduce" v-html="tourIntroduce"></li>
          </ul>
          <div class="tour-title swiper-pagination">小公园</div>
          <ul class="tour-tab">
            <li @click.stop="tourTab(1)">
              <img src="./../../assets/img/commentary.png" />
              <p>语音解说</p>
            </li>
            <li @click.stop="tourTab(2)">
              <img src="./../../assets/img/introduce.png" />
              <p>景点介绍</p>
            </li>
            <li @click.stop="tourTab(3)">
              <img src="./../../assets/img/navigation.png" />
              <p>定位导航</p>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </section>
</template>
<script>
  import {
    swiper,
    swiperSlide
  } from 'vue-awesome-swiper'
  import touch from 'touchjs'
  import {
    tourList,
    roomAndBoradList,

  } from './../api/tourList.js'
  import {
    requestGetWxJsSDK
  } from './../api/api.js'

  export default {
    name: 'index',
    components: {
      swiper,
      swiperSlide
    },
    data() {
      return {
        scale: 1,
        pinNum: 0,
        pinType: true,
        tourList: tourList,
        wStyle: {
          width: '500px',
          height: '500px'
        },
        flag: true,
        xy: '',
        tourItemsState: false,
        tourIitemHeight: {},
        tourTabView: 1,
        showTourDetailMask: false,
        swiperOption: {
          autoplay: 5500,
          pagination: '.swiper-pagination',
          height: 500,
          loop: true,
          lazyLoading: true,
        },
        swiperSlides: [],
        tourIntroduce: '',
        tourName: '',
        audioType: true,
        audioSrcIcon: true,
        audioSrcGroup: {},
        audioSrc: '',
        playAudioType: 'chUrl',
        playFlag: true,
        audioViewState: false,
        coordinate: '',
        roomAndBoradList: roomAndBoradList,
        roomAndBoradListState: false
      }
    },
    mounted() {
      touch.on(document.getElementById('mapCstyle'), 'pinchstart', (e) => {
        this.flag = true
      });
      touch.on(document.getElementById('mapCstyle'), 'pinchin', (e) => {
        this.pinNum = e.scale
        this.pinType = false
      });
      touch.on(document.getElementById('mapCstyle'), 'pinchout', (e) => {
        this.pinNum = e.scale
        this.pinType = true
      })
      touch.on(document.getElementById('mapCstyle'), 'pinchend', (e) => {
        this.flag = false
      });
      this.wSetStyle()
      this.showOpenMap()

      this.getWxConfig()
    },
    beforeMount() {
      document.title = '景区地图'
    },
    created() {
      wx.getLocation({
        type: 'wgs84', // 默认为wgs84的gps坐标，如果要返回直接给openLocation用的火星坐标，可传入'gcj02'
        success: function (res) {
          alert(window.JSON.stringify(res))
          var latitude = res.latitude; // 纬度，浮点数，范围为90 ~ -90
          var longitude = res.longitude; // 经度，浮点数，范围为180 ~ -180。
          var speed = res.speed; // 速度，以米/每秒计
          var accuracy = res.accuracy; // 位置精度
        }
      });
    },
    watch: {
      pinNum() {
        console.log(this.pinNum)
        if (this.pinType == true) { //放大
          this.scale = parseFloat(this.scale) + parseFloat(this.pinNum)
        } else { //缩小
          this.scale = parseFloat(this.scale) - parseFloat(this.pinNum)
        }
        if (this.flag) this.setMapScale()
        this.flag = false
      }
    },
    methods: {
      //获取微信js-sdk
      getWxConfig() {
        requestGetWxJsSDK({
          "shareUrl": window.location.href
        }).then((res) => {
          console.log(res.data)
          wx.config({
            debug: true, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
            appId: res.data.appid, // 必填，企业号的唯一标识，此处填写企业号corpid
            timestamp: res.data.timestamp, // 必填，生成签名的时间戳
            nonceStr: res.data.nonce_str, // 必填，生成签名的随机串
            signature: res.data.signature, // 必填，签名，见附录1
            jsApiList: ['getLocation'] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
          });
        })
      },
      //初始化div
      wSetStyle() {
        this.wStyle = {
          width: window.innerWidth + 'px',
          height: window.innerHeight + 'px'
        }
        this.tourIitemHeight.maxHeight = window.innerHeight - 45 + 'px'

      },
      // 初始化中心显示区域
      showOpenMap() {
        this.$refs.mapScale.style.transform = 'scale(0.5)'
        document.querySelectorAll('#mapPs')[0].scrollLeft = 1170
        document.querySelectorAll('#mapPs')[0].scrollTop = 1020 - window.innerHeight * 0.5
      },
      // open景点列表
      showTourItem() {
        this.roomAndBoradListState = false
        this.tourItemsState = !this.tourItemsState
      },
      // 地图缩放
      setMapScale(type) {

        const scrollLeft = document.querySelectorAll('#mapPs')[0].scrollLeft + window.innerWidth * 0.5 + 'px'
        const scrollTop = document.querySelectorAll('#mapPs')[0].scrollTop + window.innerHeight * 0.5 + 'px'

        this.$refs.mapScale.style.transition = 'transform 0.8s'
        this.$refs.mapScale.style.transformOrigin = '' + scrollLeft + ' ' + scrollTop + ''

        if (this.scale > 1.5) {
          this.scale = 1.5
        }
        if (this.scale < 0.5) {
          this.scale = 0.5
        }

        this.$refs.mapScale.style.transform = 'scale(' + this.scale + ')'

        this.flag = true
      },
      // 跳到景点
      goToTour(item) {
        this.tourItemsState = false
        this.$refs.mapScale.style.transform = 'scale(1)'
        if (item.name == '全部景点') {
          document.querySelectorAll('#mapPs')[0].scrollLeft = 0
          document.querySelectorAll('#mapPs')[0].scrollTop = 0
          setTimeout(() => {
            this.showOpenMap();
          }, 50)
        } else {
          console.log(item.scrollTo)
          document.querySelectorAll('#mapPs')[0].scrollLeft = item.scrollTo.x - window.innerWidth * 0.5
          document.querySelectorAll('#mapPs')[0].scrollTop = item.scrollTo.y - window.innerHeight * 0.5
        }

      },
      //查看详情
      showDetail(item) {
        this.tourData = item
        this.showTourDetailMask = true
        this.swiperSlides = item.picture
        this.tourIntroduce = item.introduce
        this.tourName = item.name
        this.audioSrcGroup = item.audio
        this.coordinate = item.coordinate
        this.audioViewState = false
        console.log(item)
      },
      // 切换详情信息
      tourTab(type) {
        if (type == 1) {

          this.audioViewState = true
          setTimeout(() => {
            this.defaultAudio()
          }, 10)
        } else {
          this.audioViewState = false
        }

        if (type == 3) {
          this.goToNavigation()
          return
        }

        this.tourTabView = type
      },
      // 初始化语音解说
      defaultAudio() {
        this.loadAudio('myAudio1')
        this.loadAudio('myAudio2')
        this.playAudio('myAudio1')
        this.audioSrcIcon = true
        this.audioType = true
        this.playAudioType == 'chUrl'
      },
      // 切换语音
      switchAudioType(type) {
        this.audioType = !this.audioType
        this.audioSrcIcon = true

        if (this.audioType == true) {
          this.playAudioType = 'chUrl'
          this.pauseAudio('myAudio2')
          this.loadAudio('myAudio1')
          this.playAudio('myAudio1')
        } else {
          this.playAudioType = 'enUrl'
          this.pauseAudio('myAudio1')
          this.loadAudio('myAudio2')
          this.playAudio('myAudio2')
        }
      },
      // 播放
      playAudio(id) {
        var myAudio = document.getElementById(id);
        myAudio.play();
      },
      // 暂停
      pauseAudio(id) {
        var myAudio = document.getElementById(id);
        myAudio.pause();
      },
      // 重新加载
      loadAudio(id) {
        var myAudio = document.getElementById(id);
        myAudio.load();
      },
      // 播放/暂停
      openOrcloseVideo() {
        this.audioSrcIcon = !this.audioSrcIcon
        this.pauseAudio('myAudio1')
        this.pauseAudio('myAudio2')
        if (this.playAudioType == 'chUrl' && this.audioSrcIcon) {
          this.playAudio('myAudio1')
        }
        if (this.playAudioType == 'enUrl' && this.audioSrcIcon) {
          this.playAudio('myAudio2')
        }

      },
      // 跳转到导航
      goToNavigation() {
        console.log(this.tourData)
        const self = this
        navigator.geolocation.getCurrentPosition( // 该函数有如下三个参数
          function (pos) { // 如果成果则执行该回调函数
            // alert(
            //   '  经度：' + pos.coords.latitude +
            //   '  纬度：' + pos.coords.longitude +
            //   '  高度：' + pos.coords.altitude +
            //   '  精确度(经纬)：' + pos.coords.accuracy +
            //   '  精确度(高度)：' + pos.coords.altitudeAccuracy +
            //   '  速度：' + pos.coords.speed
            // );
            self.goToMap(pos.coords.latitude, pos.coords.longitude)
          },
          function (err) { // 如果失败则执行该回调函数
            alert('获取失败，请重新刷新' || err.message);
          }, { // 附带参数
            enableHighAccuracy: false, // 提高精度(耗费资源)
            timeout: 3000, // 超过timeout则调用失败的回调函数
            maximumAge: 1000 // 获取到的地理信息的有效期，超过有效期则重新获取一次位置信息
          }
        );
      },
      //跳转腾讯地图
      goToMap(latitude, longitude) {
        const domain = 'http://apis.map.qq.com/uri/v1/routeplan?type=walk&from=我&fromcoord='
        window.location.href = domain + latitude + ',' + longitude + '&to=' + this.tourData.name + '&tocoord=' + this.tourData
          .coordinate + '&policy=1&referer=myapp'
      },
      // 显示周边吃住list
      showRoomBoard() {
        this.tourItemsState = false
        this.roomAndBoradListState = !this.roomAndBoradListState
      },
      // 跳转周边吃住
      goToRoomAndBorad(item) {
        console.log(item)
        this.$router.push({
          path: '/parkMap/roomAndBorad/' + item.type
        })
      }
    }
  }

</script>
<style lang="scss" type="text/css" scoped>
  .tour-detail-mask {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    z-index: 999;
    background-color: rgba(0, 0, 0, 0.1);
    text-align: center;
    display: flex;
    justify-content: center;
    align-items: Center;
  }

  .tour-detail-top {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 40px;
    line-height: 40px;
    background-color: #efeff4;
    color: #353535;
    font-size: 15px;
    text-align: left;
  }

  .tour-detail-top ul {
    float: right;
  }

  .tour-detail-top ul li {
    float: left;
    padding: 0 15px;
    list-style-type: none;
  }

  .tour-detail-top ul li img {
    max-height: 25px;
    vertical-align: middle;
  }

  .tour-detail-top ul li:nth-of-type(1) {
    border-right: 1px solid #cccccc;
  }

  .swiper-pagination-bullet {
    background: #ffffff;
    opacity: 1;
  }

  .swiper-pagination-bullet-active {
    opacity: 1;
    background: #007aff;
  }

  .tour-detail {
    display: inline-block;
    width: 90%;
    position: relative;
    background-color: #fafafa;
  }

  .tour-detail li {
    list-style-type: none;
  }

  .tour-detail .tour-tab {
    overflow: hidden;
  }

  .tour-detail .tour-tab li {
    width: 33.33%;
    text-align: center;
    float: left;
    box-sizing: border-box;
    color: #353535;
    padding-bottom: 5px;
    border-bottom: 0;
    font-size: 14px;
  }

  .tour-tab li img {
    height: 20px;
    margin: 5px 0;
  }

  .tour-introduce {
    text-align: left;
    color: #666666;
    font-size: 14px;
    padding: 15px 15px 50px;
  }

  .tour-detail .tour-tab li:nth-of-type(2) {
    border-left: 1px solid #dcdcdc;
    border-right: 1px solid #dcdcdc;
  }

  .tour-title {
    line-height: 40px;
    height: 40px;
    color: #fff;
    font-size: 14px;
    text-align: left;
    text-indent: 10px;
    background-color: rgba(0, 0, 0, 0.5);
    position: absolute;
    width: 100%;
    bottom: 52px;
    z-index: 1;
  }

  body {
    overflow: hidden
  }

  * {
    padding: 0;
    margin: 0
  }

  .map-p-style {
    box-sizing: border-box;
    position: relative;
    overflow: hidden;
    z-index: 9;
  }

  .map-c-style {
    overflow: scroll;
    -webkit-overflow-scrolling: touch
  }

  .map-cc-style {
    width: 3205px;
    height: 1970px;
    position: relative;
    z-index: 8
  }

  .map-c {
    width: 3205px;
    height: 1970px;
    position: absolute;
    left: 0;
    top: 0
  }

  .map-iframe-style {
    width: 3205px;
    height: 1970px;
    border: 0px;
    position: absolute;
    top: 0;
    left: 0;
  }

  .detail-item {
    position: absolute;
  }
  /* end */

  .map-content-p {
    width: 375px;
    height: 667px;
    overflow: auto;
    position: relative;
  }

  .map-content {
    position: absolute;
    top: 0;
    left: 0;
    width: 3205px;
    overflow: hidden;
    height: 1970px;
    box-sizing: border-box;
  }

  .map-item-c {
    width: 3205px;
    height: 1970px;
    box-sizing: border-box;
    position: relative;
    z-index: 9;
  }

  .map-iframe1 {
    position: absolute;
    top: -2590px;
    left: 0;

    width: 3205px;
    height: 7147px;
    border: 0;
  }

  .map-mask {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    z-index: 2;
  }

  .map-iframe {
    position: absolute;
    top: 10%;
    left: 5%;
  }

  .address {
    position: absolute;
  }

  .red-station {
    top: 1214px;
    left: 808px;
    height: 100px;
    width: 100px;
  }

  .shantou-mansion {
    position: absolute;
    top: 1161px;
    left: 1122px
  }

  .map {
    height: 500px;
    width: 500px;
    border: 1px solid #000000;
  }

  .tab {
    position: fixed;
    bottom: 0;
    left: 0;
    width: 100%;
    background-color: #fff;
    text-align: center;
    z-index: 9;
  }

  .item {
    width: 50%;
    float: left;
    height: 45px;
    line-height: 45px;
    box-sizing: border-box;
    font-size: 15px;
  }
  /* .item:last-child {
    border-left: 1px solid #cccccc;
  } */

  .tour-item {
    position: fixed;
    bottom: 45px;
    width: 50%;
    text-align: center;
    background-color: #fff;
    z-index: 9;
    overflow-y: auto;
  }

  .tour-item.left {
    left: 0;
  }

  .tour-item.right {
    right: 0;
  }

  .tour-item li {
    height: 45px;
    line-height: 45px;
    color: #353535;
    /* border-bottom: 1px solid #cccccc; */
    font-size: 15px;
  }

</style>
