<template>
  <section>
    <!-- <swiper :options="swiperOption" style="min-height:200px;max-height:300px;">
      <swiper-slide v-for="(item,index) in data.swiperSlides" :key="index">
        <img :src="item" alt="item" style="max-width:100%;">
      </swiper-slide>
      <div v-show="data.swiperSlides.length >1" class="swiper-pagination" slot="pagination"></div>
    </swiper> -->
    <div>
      <img :src="data.bannerUrl" style="min-width:100%;height:250px;" alt="">
    </div>
    <ul class="detail-list">
      <li v-text="data.name"></li>
      <li class="has-img" @click="goToNav(data.lat,data.lon)">
        <img class="left-img" src="./../../assets/img/address-icon.png" />
        <span class="address" v-text="data.address"></span>
        <img class="right-icon" src="./../../assets/img/right-icon.png" />
      </li>
      <li class="has-img">
        <a href="tel:2016480">
          <img class="left-img" src="./../../assets/img/phone-icon.png" />
          <span v-text="data.phone"></span>
          <img class="right-icon" src="./../../assets/img/right-icon.png" />
        </a>
      </li>
      <li class="dps title has-img" v-if="type == 1">
        <img class="left-img" src="./../../assets/img/eat.png" />餐厅介绍</li>
      <li class="dps title has-img" v-if="type == 0">
        <img class="left-img" src="./../../assets/img/hotels-icon.png" />酒店介绍</li>
      <li class="dps" style="line-height:20px;height: auto;">
        <pre style="white-space: pre-wrap;
        word-wrap: break-word;" v-text="data.remark||'暂无'"></pre>
      </li>
    </ul>
  </section>
</template>
<script>
  // import {
  //   swiper,
  //   swiperSlide
  // } from 'vue-awesome-swiper'
  import {
    requestGetEat,
    requestGetHotel
  } from './../api/api.js'
  export default {
    data() {
      return {
        swiperOption: {
          autoplay: 5500,
          pagination: '.swiper-pagination',
          height: 500,
          loop: true,
          lazyLoading: true,
        },
        type: 0,
        data: {
         
        }
      }
    },
    // components: {
    //   swiper,
    //   swiperSlide
    // },
    mounted() {
      this.type = this.$route.params.type
      this.getDetail(this.$route.params.id, this.$route.params.type)
    },
    methods: {
      // 获取金纬度
      getNavigator() {

      },
      getDetail(id, type) {
        if (type == 0) { //酒店
          requestGetHotel({
            "id": id
          }).then((res) => {
            if (res.code == 100) {
              console.log(res.data)
              this.data = res.data
              document.title = res.data.name
            } else {
              alert(res.msg)
            }
          })
        }
        if (type == 1) { //餐饮
          requestGetEat({
            "id": id
          }).then((res) => {
            if (res.code == 100) {
              console.log(res.data)
              this.data = res.data
              document.title = res.data.name
            } else {
              alert(res.msg)
            }
          })
        }
      },
      //跳转地图
      goToNav(latitude, longitude) {
        const domain = 'http://apis.map.qq.com/uri/v1/routeplan?type=walk&from=我&fromcoord='
        if (localStorage.latitude == undefined) {
          const self = this
          navigator.geolocation.getCurrentPosition( // 该函数有如下三个参数
            function (pos) { // 如果成果则执行该回调函数
              window.location.href = domain + pos.coords.latitude + ',' + pos.coords.longitude + '&to=' + self.data.name +
                '&tocoord=' + '' + self.data.lat + ',' + self.data.lon + '' + '&policy=1&referer=myapp'
            },
            function (err) { // 如果失败则执行该回调函数
              //alert('获取失败，请重新刷新' || err.message);
              alert('获取定位失败，请重新刷新' || err.message);
            }, { // 附带参数
              enableHighAccuracy: false, // 提高精度(耗费资源)
              timeout: 1000, // 超过timeout则调用失败的回调函数
              maximumAge: 10000 // 获取到的地理信息的有效期，超过有效期则重新获取一次位置信息
            }
          );
        } else {
          window.location.href = domain + localStorage.latitude + ',' + localStorage.longitude + '&to=' + self.data.name +
            '&tocoord=' + '' + self.data.lat + ',' + self.data.lon + '' + '&policy=1&referer=myapp'
        }
      }
    }
  }

</script>
<style scoped>
  * {
    padding: 0;
    margin: 0
  }

  .detail-list {
    list-style-type: none;
    overflow: hidden;
    color: #666666;
    font-size: 14px;
    padding-bottom: 30px;
  }

  .detail-list li {
    padding: 0 20px;
    position: relative;
  }

  .detail-list li:not(dps) {
    line-height: 45px;
    height: 45px;
  }

  .detail-list li:nth-of-type(1) {
    border-top: 8px solid #f4f4f4;
    border-bottom: 1px solid #eeeeee;
    font-weight: 700;
  }

  .detail-list li:nth-of-type(2) {
    border-bottom: 1px solid #eeeeee;
  }

  .detail-list li.has-img {
    padding-left: 50px;
  }

  .address {
    display: -webkit-box;
    -webkit-box-orient: vertical;
    -webkit-line-clamp: 1;
    overflow: hidden;
    max-width: 85%;
  }

  .detail-list li img {
    width: 20px;
  }

  .left-img {
    position: absolute;
    top: 10px;
    left: 20px;
  }

  .detail-list li img.right-icon {
    width: 8px;
    position: absolute;
    top: 16px;
    right: 20px;
  }

  .detail-list li a {
    color: #666666;
    text-decoration: none;
  }

  .dps.title {
    border-top: 8px solid #f4f4f4;
  }

</style>
