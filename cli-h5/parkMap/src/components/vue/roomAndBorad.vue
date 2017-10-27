<template>
  <section v-show="showListBox">
    <ul class="top-title">
      <li :class="type==1? 'bg':''" @click="selectType(1)">餐饮</li>
      <li :class="type==0? 'bg':''" @click="selectType(0)">住宿</li>
    </ul>
    <div class="type-box-list">
      <ul class="type-list" v-show="type==1" ref="eatsBox">
        <li class="type-list-item" v-for="(item,index) in listEats" @click="goToDetail(item.id,1)">
          <div class="left-img" :style="{backgroundImage: 'url(' + item.logoUrl + ')'}"></div>
          <div class="right-content">
            <h2 class="title">
              <span class="over" style="flex: 5;" v-text="item.name"></span>
              <span style="flex: 1;font-size: 14px;color:#666;margin-top:5px;" v-text="((item.distance)/1000).toFixed(1) + 'KM'"></span>
            </h2>
            <p class="dps over" v-text="item.introduce"></p>
            <p class="icon-text over">
              <img class="icon" src="./../../assets/img/address-icon.png" alt="地址">
              <span v-text="item.address"></span>
            </p>
            <p class="icon-text over">
              <img class="icon" src="./../../assets/img/phone-icon.png" alt="电话">
              <span v-text="item.phone"></span>
            </p>
          </div>
        </li>
        <div class="no-more" v-if="eatsCurrent > eatsTotalPages">加载完了...</div>
      </ul>
      <ul class="type-list" v-show="type==0" ref="hotelsBox">
        <li class="type-list-item" v-for="(item,index) in listHotels" @click="goToDetail(item.id,0)">
          <div class="left-img" :style="{backgroundImage: 'url(' + item.logoUrl + ')'}"></div>
          <div class="right-content">
            <h2 class="title">
              <span class="over" style="flex: 5;" v-text="item.name"></span>
              <span style="flex: 1;font-size: 14px;color:#666;margin-top:5px;" v-text="((item.distance)/1000).toFixed(1) + 'KM'"></span>
            </h2>
            <p class="dps over" v-text="item.introduce"></p>
            <p class="icon-text over">
              <img class="icon" src="./../../assets/img/address-icon.png" alt="地址">
              <span v-text="item.address"></span>
            </p>
            <p class="icon-text over">
              <img class="icon" src="./../../assets/img/phone-icon.png" alt="电话">
              <span v-text="item.phone"></span>
            </p>
          </div>
        </li>
        <div class="no-more" v-if="hotelsCurrent > hotelsTotalPages">加载完了...</div>
      </ul>
    </div>
  </section>
</template>

<script>
  import {
    requestListHotels,
    requestListEates
  } from './../api/api.js'
  export default {
    data() {
      return {
        showListBox: false,
        type: 0,
        listHotels: [],
        listEats: [],
        hotelsCurrent: 1,
        hotelsTotalPages: '',
        hotelsFlag: true,
        eatsCurrent: 1,
        eatsTotalPages: '',
        eatsFlag: true
      }
    },
    mounted() {
      this.type = this.$route.params.type
      this.getNavigator()
      this.weixinGetLocation()
      window.addEventListener('scroll', this.onScrollEates); //挂载滚动事件
      window.addEventListener('scroll', this.onScrollHotels); //挂载滚动事件

    },
    destroyed() {
      window.addEventListener('scroll', ''); //挂载滚动事件
    },
    beforeMount() {
      document.title = '周边吃住列表'
    },
    methods: {
      // weixin
      weixinGetLocation() {
        wx.getLocation({
          type: 'wgs84', // 默认为wgs84的gps坐标，如果要返回直接给openLocation用的火星坐标，可传入'gcj02'
          success: function (res) {
            var latitude = res.latitude; // 纬度，浮点数，范围为90 ~ -90
            var longitude = res.longitude; // 经度，浮点数，范围为180 ~ -180。
            var speed = res.speed; // 速度，以米/每秒计
            var accuracy = res.accuracy; // 位置精度
            alert(latitude,'latitude')
          }
        });
      },
      // 选择餐饮、住宿
      selectType(type) {
        this.type = type
      },
      //加载酒店数据
      getListHotels() {
        if (this.hotelsTotalPages != '' && this.hotelsCurrent > this.hotelsTotalPages) {
          return
        }
        requestListHotels({
          "current": this.hotelsCurrent,
          "lat": this.lat,
          "lon": this.lon,
          "size": 6
        }).then((res) => {
          console.log(res)
          if (res.code != 100) {
            alert(res.msg + res.code)
            return
          }
          setTimeout(() => {
            this.listHotels = this.listHotels.concat(res.data)
            this.hotelsTotalPages = res.page.totalPages
            if (res.page.totalPages >= 1) {
              this.hotelsCurrent += 1
            }
            this.hotelsFlag = true
            this.showListBox = true
          }, 60)
        })
      },
      //加载餐饮数据
      getListEats() {
        console.log(this.eatsCurrent, 'this.eatsCurrent')
        if (this.eatsTotalPages != '' && this.eatsCurrent > this.eatsTotalPages) {
          return
        }
        requestListEates({
          "current": this.eatsCurrent,
          "lat": this.lat,
          "lon": this.lon,
          "size": 6
        }).then((res) => {
          console.log(res)
          if (res.code != 100) {
            alert(res.msg + res.code)
            return
          }
          setTimeout(() => {
            this.listEats = this.listEats.concat(res.data)
            this.eatsTotalPages = res.page.totalPages
            if (res.page.totalPages >= 1) {
              this.eatsCurrent += 1
            }
            this.eatsFlag = true
            this.showListBox = true
          }, 60)
        })
      },
      // 获取金纬度
      getNavigator() {
        const self = this
        navigator.geolocation.getCurrentPosition( // 该函数有如下三个参数
          function (pos) { // 如果成果则执行该回调函数
            self.lat = pos.coords.latitude
            self.lon = pos.coords.longitude

            localStorage.latitude = pos.coords.latitude
            localStorage.longitude = pos.coords.longitude
            // alert(
            //   '  经度：' + pos.coords.latitude +
            //   '  纬度：' + pos.coords.longitude +
            //   '  高度：' + pos.coords.altitude +
            //   '  精确度(经纬)：' + pos.coords.accuracy +
            //   '  精确度(高度)：' + pos.coords.altitudeAccuracy +
            //   '  速度：' + pos.coords.speed
            // );
            self.getListHotels()
            self.getListEats()
          },
          function (err) { // 如果失败则执行该回调函数
            //alert('获取失败，请重新刷新' || err.message);
            self.lat = '' || 23.091076
            self.lon = '' || 114.431815
            if (self.lat == '' || self.lon == '') {
              alert('获取定位失败，请重新刷新' || err.message);
            } else {
              self.getListHotels()
              self.getListEats()
            }
          }, { // 附带参数
            enableHighAccuracy: false, // 提高精度(耗费资源)
            timeout: 1000, // 超过timeout则调用失败的回调函数
            maximumAge: 10000 // 获取到的地理信息的有效期，超过有效期则重新获取一次位置信息
          }
        );
      },
      //滚动加载餐饮
      onScrollEates(event) {
        if (this.type != 1) return
        var nScrollTop = document.documentElement.scrollTop || document.body.scrollTop; //滚动条高度
        var winH = window.innerHeight; //页面可视区域高度
        var nScrollHight = this.$refs.eatsBox.offsetHeight; //div高度
        var ratio = (nScrollHight - winH - nScrollTop) / winH;
        if (ratio <= 0.1 && this.eatsFlag) {
          this.eatsFlag = false
          this.getListEats()
        }
      },
      //滚动加载酒店
      onScrollHotels(event) {
        if (this.type != 0) return
        var nScrollTop = document.documentElement.scrollTop || document.body.scrollTop; //滚动条高度
        var winH = window.innerHeight; //页面可视区域高度
        var nScrollHight = this.$refs.hotelsBox.offsetHeight; //div高度
        var ratio = (nScrollHight - winH - nScrollTop) / winH;
        if (ratio <= 0.1 && this.hotelsFlag) {
          this.hotelsFlag = false
          this.getListHotels()
        }
      },
      // 跳转详情
      goToDetail(id, type) {
        this.$router.push({
          path: '/parkMap/detail/' + id + '/' + type
        })
      }

    }
  }

</script>
<style lang="scss" type="text/css" scoped>
  * {
    padding: 0;
    margin: 0;
  }

  .top-title {
    background-color: #efeff4;
    overflow: hidden;
    line-height: 45px;
    height: 45px;
    border-bottom: 1px solid #cccccc;
  }

  .top-title li {
    list-style-type: none;

    padding: 0 25px;
    font-size: 14px;
    color: #353535;
    float: left;
  }

  .top-title li.bg {
    background-color: #75d377;
    color: #ffffff;
  }

  .type-list {
    background-color: #f4f4f4;
    overflow: hidden;
    -webkit-overflow-scrolling: touch
  }

  .type-list-item {
    display: flex;
    padding: 15px 10px 15px 15px;
    margin-bottom: 10px;
    background-color: #ffffff;
    overflow: hidden;
    height: 100px;
    position: relative;
  }

  .type-list-item .left-img {
    width: 100px;
    height: 100px;
    background-position: center;
    background-size: cover;
    background-repeat: no-repeat;
    position: absolute;
  }

  .right-content {
    color: #666;
    font-size: 14px;
    height: 100px;
    padding-left: 110px;
    width: 100%;
  }

  .right-content .title {
    font-size: 18px;
    font-weight: normal;
    color: #333;
    display: flex;
  }

  .over {
    display: -webkit-box;
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 1;
    overflow: hidden;
    margin-bottom: 4px;
  }

  .icon-text {
    color: #666;
    text-decoration: none;
  }

  .icon-text .icon {
    width: 14px;
    vertical-align: middle;
    margin-right: 10px;
  }

  .dps.over {
    margin-bottom: 7px;
  }

  .no-more {
    text-align: center;
    font-size: 14px;
    line-height: 60px;
    background-color: #fff;
  }

</style>
