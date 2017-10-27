<style >
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
    border-top:8px solid #f4f4f4;
  }

</style>
<template>
  <section>
    <swiper :options="swiperOption" style="min-height:200px;max-height:300px;">
      <!-- <swiper-slide v-for="(item,index) in data.swiperSlides" :key="index">
        <img :src="item" alt="item" style="max-width:100%;">
      </swiper-slide>
      <div v-show="data.swiperSlides.length >1" class="swiper-pagination" slot="pagination"></div> -->
    </swiper>
    <ul class="detail-list">
      <li v-text="data.name">城市便捷酒店</li>
      <li class="has-img">
        <img class="left-img" src="./../img/address-icon.png" />
        <span class="address" v-text="data.address">广东省汕头市金广东省汕头市金平区潮汕路1号平区潮汕路1号</span>
        <img class="right-icon" src="./../img/right-icon.png" />
      </li>
      <li class="has-img">
        <a href="tel:2016480">
          <img class="left-img" src="./../img/phone-icon.png" />
          <span v-text="data.phone"></span>
          <img class="right-icon" src="./../img/right-icon.png" />
        </a>
      </li>
      <li class="dps title has-img" v-if="type == 1">
        <img class="left-img" src="./../img/eat.png" />餐厅介绍</li>
      <li class="dps title has-img" v-if="type == 0">
        <img class="left-img" src="./../img/hotels-icon.png" />酒店介绍</li>
      <li class="dps" style="line-height:20px;height: auto;">
        <pre style="white-space: pre-wrap;
        word-wrap: break-word;" v-text="data.remark"></pre>
      </li>
    </ul>
  </section>
</template>
<script>
  import {
    swiper,
    swiperSlide
  } from 'vue-awesome-swiper'
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
          address: '',
          swiperSlides:['http://maint.deeptel.com.cn/upload//image/3/gt123/3/20170615/49219C6D93E1FA86CD5BACB9EFB66657.jpg']
        }
      }
    },
    components: {
      swiper,
      swiperSlide
    },
    mounted() {
      console.log(this.$route.params)
      this.type = this.$route.params.type
      this.getDetail(this.$route.params.id, this.$route.params.type)
    },
    methods: {
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
      }
    }
  }

</script>
