<style lang="stylus">
  * {
    padding: 0;
    margin: 0;
  }

  .park-map-room {
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
      padding: 10px;
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
    .loading {
      width: 80px;
      height: 40px;
      margin: 0 auto;
      margin-top: 100px;
      position: fixed;
      top: 30%;
      left: 50%;
      margin-left: -40px;
      z-index: 1;
    }
    .loading span {
      display: inline-block;
      width: 8px;
      height: 100%;
      border-radius: 4px;
      background: #90ee90;
      -webkit-animation: load 1.04s ease infinite;
    }
    .loading span:nth-child(2) {
      -webkit-animation-delay: 0.13s;
    }
    .loading span:nth-child(3) {
      -webkit-animation-delay: 0.26s;
    }
    .loading span:nth-child(4) {
      -webkit-animation-delay: 0.39s;
    }
    .loading span:nth-child(5) {
      -webkit-animation-delay: 0.52s;
    }
    @keyframes load {
      0%,
      100% {
        height: 40px;
        background: #90ee90;
      }
      50% {
        height: 60px;
        margin-top: -20px;
        background: #add8e6;
      }
    }
  }

</style>
<template>
  <section class="park-map-room">
    <div class="loading" v-show="!showListBox">
      <span></span>
      <span></span>
      <span></span>
      <span></span>
      <span></span>
    </div>
    <div v-show="showListBox">
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
                <span v-if="LatAndLogFlag" style="flex: 1;font-size: 14px;color:#666;margin-top:5px;" v-text="((item.distance)/1000).toFixed(1) + 'KM'"></span>
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
          <div class="no-more" v-if="eatsCurrent > eatsTotalPages && eatslsPageFlag">加载完毕</div>
        </ul>
        <ul class="type-list" v-show="type==0" ref="hotelsBox">
          <li class="type-list-item" v-for="(item,index) in listHotels" @click="goToDetail(item.id,0)">
            <div class="left-img" :style="{backgroundImage: 'url(' + item.logoUrl + ')'}"></div>
            <div class="right-content">
              <h2 class="title">
                <span class="over" style="flex: 5;" v-text="item.name"></span>
                <span v-if="LatAndLogFlag" style="flex: 1;font-size: 14px;color:#666;margin-top:5px;" v-text="((item.distance)/1000).toFixed(1) + 'KM'"></span>
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
          <div class="no-more" v-if="hotelsCurrent > hotelsTotalPages && hotelsPageFlag">加载完毕</div>
        </ul>
      </div>
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
        eatsFlag: true,
        hotelsPageFlag: false,
        eatslsPageFlag: false,
        LatAndLogFlag: false,
        shareImgs: {
          eat: './static/imgs/share/eat.jpg',
          holte: './static/imgs/share/holte.jpg'
        },
        shareImg: './static/imgs/share/eat.jpg',
        getWxSDK: true,
        setScrollFlag: true,
      }
    },
    watch: {
      type() {
        if (this.type == 1) this.shareImg = this.shareImgs.eat
        else this.shareImg = this.shareImgs.holte
      }
    },
    mounted() {

      if (window.dataPack.logLan) {
        this.lat = window.dataPack.logLan.latitude
        this.lon = window.dataPack.logLan.longitude
        this.getListHotels()
        this.getListEats()
        this.type = this.$route.params.type
      } else {
        const setInt = setInterval(() => {
          if (window.dataPack.logLan) {
            this.lat = window.dataPack.logLan.latitude
            this.lon = window.dataPack.logLan.longitude
            this.getListHotels()
            this.getListEats()
            this.type = this.$route.params.type
            clearInterval(setInt)
            this.showListBox = true
          }
        }, 300)
        setTimeout(() => {
          if (!window.dataPack.logLan) {
            this.lat = '23.08828'
            this.lon = '114.43721'
            this.getListHotels()
            this.getListEats()
            this.type = this.$route.params.type
            window.dataPack.logLan = {
              latitude: '23.08828',
              longitude: '114.43721'
            }
          }
          clearInterval(setInt)
          this.showListBox = true
        }, 3000)
      }
      this.LatAndLogFlag = true
    },
    beforeMount() {
      document.title = '周边吃住列表'
    },
    methods: {
      onScroll() {
        setTimeout(() => {
          window.addEventListener('scroll', this.onScrollEates); //挂载滚动事件
          window.addEventListener('scroll', this.onScrollHotels); //挂载滚动事件
        }, 1000)
      },
      // 选择餐饮、住宿
      selectType(type) {
        this.type = type
      },
      //加载酒店数据
      getListHotels() {
        if (this.hotelsTotalPages != '' && this.hotelsCurrent > this.hotelsTotalPages) return
        requestListHotels({
          "current": this.hotelsCurrent,
          "lat": this.lat,
          "lon": this.lon,
          "size": 6,
          "busId": this.$route.params.busId
        }).then((res) => {
          console.log(res)
          if (res.code != 100) {
            alert(res.msg + res.code)
            return
          }
          setTimeout(() => {
            this.listHotels = this.listHotels.concat(res.data)
            this.hotelsTotalPages = res.page.totalPages
            this.hotelsPageFlag = true
            if (res.page.totalPages >= 1) {
              this.hotelsCurrent += 1
            }
            this.hotelsFlag = true
            this.showListBox = true
            if (this.setScrollFlag) {
              this.setScrollFlag = false
              this.onScroll()
            }
            window.dataPack.setWXShare()

          }, 60)
        })
      },
      //加载餐饮数据
      getListEats() {
        if (this.eatsTotalPages != '' && this.eatsCurrent > this.eatsTotalPages) return
        requestListEates({
          "current": this.eatsCurrent,
          "lat": this.lat,
          "lon": this.lon,
          "size": 6,
          "busId": this.$route.params.busId
        }).then((res) => {
          console.log(res)
          if (res.code != 100) {
            alert(res.msg + res.code)
            return
          }
          setTimeout(() => {
            this.listEats = this.listEats.concat(res.data)
            this.eatsTotalPages = res.page.totalPages
            this.eatslsPageFlag = true
            if (res.page.totalPages >= 1) {
              this.eatsCurrent += 1
            }
            this.eatsFlag = true
            this.showListBox = true
            if (this.setScrollFlag) {
              this.setScrollFlag = false
              this.onScroll()
            }
            window.dataPack.setWXShare()

          }, 60)
        })
      },
      //滚动加载餐饮
      onScrollEates(event) {
        if (this.type != 1) return
        var nScrollTop = document.scrollTop || document.body.scrollTop; //滚动条高度
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
        var nScrollTop = document.scrollTop || document.body.scrollTop; //滚动条高度
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
          path: '/detail/' + this.$route.params.busId + '/' + id + '/' + type
        })
      }

    }
  }

</script>
