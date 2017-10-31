<style scoped>
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

  @media screen and (min-width: 414px) {
    .video-top {
      height: 250px;
    }
    .video-top.video-item {
      height: 190px;
    }
  }

</style>
<template>
  <section>
    <div class="video-top">
      <a href="#" class="block" :style="{backgroundImage: 'url(' + img + ')'}"></a>
      <img class="video-icon" src="./../../assets/img/video.png" alt="">
      <div class="video-mask"></div>
    </div>
    <ul class="video-list">
      <li class="video-top video-item">
        <a href="#" class="block" :style="{backgroundImage: 'url(' + img + ')'}"></a>
        <img class="video-icon" src="./../../assets/img/video.png" alt="">
        <div class="video-mask"></div>
      </li>
      <li class="video-top video-item">
        <a href="#" class="block" :style="{backgroundImage: 'url(' + img + ')'}"></a>
        <img class="video-icon" src="./../../assets/img/video.png" alt="">
        <div class="video-mask"></div>
      </li>
      <li class="video-top video-item">
        <a href="#" class="block" :style="{backgroundImage: 'url(' + img + ')'}"></a>
        <img class="video-icon" src="./../../assets/img/video.png" alt="">
        <div class="video-mask"></div>
      </li>
      <li class="video-top video-item">
        <a href="#" class="block" :style="{backgroundImage: 'url(' + img + ')'}"></a>
        <img class="video-icon" src="./../../assets/img/video.png" alt="">
        <div class="video-mask"></div>
      </li>
    </ul>
  </section>
</template>
<script>
  export default {
    data() {
      return {
        img: '//img1.imgtn.bdimg.com/it/u=2438635438,1401027135&fm=27&gp=0.jpg'
      }
    },
    beforeMount() {
      document.title = '景点直播'
    },
  }

</script>
