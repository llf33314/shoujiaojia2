<style lang="stylus">
  .park-map-video {
    .video-top {
      height: 200px;
      position: relative;
    }

    .video-icon {
      max-width: 70px;
      position: absolute;
      top: 50%;
      left: 50%;
      margin-top: -35px;
      margin-left: -35px;
      z-index: 2
    }

    .video-mask {
      position: absolute;
      top: 0;
      left: 0;
      width: 100%;
      height: 100%;
      background-color: rgba(0, 0, 0, 0.1);
      z-index: 1
    }

    .block {
      display: block;
      background-position: center;
      background-size: cover;
      width: 100%;
      height: 100%;
    }

    .video-list {
      margin-top: 5px;
      margin-bottom: 30px;
      overflow: hidden;
    }

    .video-top.video-item {
      width: 50%;
      height: 150px;
      float: left;
      box-sizing: border-box;
      border-left: 4px solid #fff;
      border-right: 4px solid #fff;
      border-top: 5px solid #fff;
    }
  }

  @media screen and (min-width: 414px) {
    .park-map-video .video-top {
      height: 250px;
    }
    .park-map-video .video-top.video-item {
      height: 190px;
    }
  }

</style>
<template>
  <section class="park-map-video">
    <div class="video-top" @click="goToLink(VideoMain.videoUrl)">
      <a href="javascript:;" class="block" :style="{backgroundImage: 'url(' + VideoMain.imgUrl + ')'}"></a>
      <img class="video-icon" src="./../../assets/img/video.png" alt="">
      <div class="video-mask"></div>
    </div>
    <ul class="video-list">
      <li class="video-top video-item" v-for="item in ListVideo" @click="goToLink(item.videoUrl )">
        <a href="javascript:;" class="block" :style="{backgroundImage: 'url(' + item.imgUrl + ')'}"></a>
        <img class="video-icon" src="./../../assets/img/video.png" alt="">
        <div class="video-mask"></div>
      </li>
    </ul>
    <div v-show="showMoreText" class="no-more">加载完毕</div>
  </section>
</template>
<script>
  import {
    requestVideoMain,
    requestListVideo
  } from './../api/api.js'
  export default {
    data() {
      return {
        img: '//img1.imgtn.bdimg.com/it/u=2438635438,1401027135&fm=27&gp=0.jpg',
        VideoMain: {
          imgUrl: '',
          videoUrl: ''
        },
        ListVideo: [],
        showMoreText: false
      }
    },
    beforeMount() {
      document.title = '景点直播'
    },
    mounted() {
      const busId = this.$route.params.busId
      if (!busId) alert('busIn为空')
      else
        this.getVideoMain(busId)
      this.getListVideo(busId)
    },
    created() {
      // 获取微信sdk
      this._wx.getWxSDK(this.$route.params.busId, {
        title: '周边吃住列表',
        link: window.location.href,
        imgUrl: '//maint.deeptel.com.cn/upload//image/3/goodtom/3/20171030/6D19FD6D60C4B424348F07EFE9B3408C.jpg'
      })
    },
    methods: {
      //获取主视频
      getVideoMain(busId) {
        requestVideoMain({
          busId: busId
        }).then(res => {
          console.log(res)
          if (res.code != 100) {
            alert(red.code)
            return
          }
          this.VideoMain = {
            imgUrl: res.data.imgUrl,
            videoUrl: res.data.videoUrl
          }
        })
      },
      // 获取视频列表
      getListVideo(busId) {
        requestListVideo({
          busId: busId
        }).then(res => {
          if (res.code != 100) {
            alert(red.code)
            return
          }
          this.ListVideo = res.data
          this.showMoreText = true
        })
      },
      //跳转视频url
      goToLink(url) {
        window.location.href = url
      },
    }
  }

</script>
