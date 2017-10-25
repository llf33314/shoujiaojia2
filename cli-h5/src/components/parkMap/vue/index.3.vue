<template>
  <section>
    <div class="map-p-style" :style="wStyle" id="mapMask">
      <div class="map-c-style" :style="wStyle" id="mapCstyle" ref="mapCstyle">
        <object width="3205" height="1970" data="./static/imgs/map.svg"></object>
      </div>
    </div>
    <div class="tab">
      <div class="item" @click="showTourItem">景点</div>
      <div class="item" @click="largeOrNarrow(false)">周边吃住</div>
    </div>
    <ul class="tour-item" id="tourItem" v-show="tourItemsState" :style="tourIitemHeight">
      <li v-for="(item,index) in tourList" @click="goToTour(item)" v-text="item.name"></li>
    </ul>
    <!-- <div v-show="showMapContent">
      <div class="map-content-p" ref="mapContentp" id="mapContentp">
        <div class="map-content">
          <div class="map-item-c" ref="largeOrSmall" id="largeOrSmall">
            <div class="map-mask" id="mapMask">
              <div v-for="(item,index) in tourList" class="address" :style="item.position" v-text="item.name">
              </div>
            </div>
            <iframe class="map-iframe1" src="./static/imgs/map.svg">
            </iframe>
          </div>
        </div>
      </div>
      <div class="tab">
        <div class="item" @click="showTourItem">景点</div>
        <div class="item" @click="largeOrNarrow(false)">周边吃住</div>
      </div>
      <ul class="tour-item" id="tourItem" v-show="tourItemsState" :style="tourIitemHeight">
        <li v-for="(item,index) in tourList" @click="goToTour(item)" v-text="item.name"></li>
      </ul>
    </div> -->
  </section>
</template>
<script>
  import touch from 'touchjs'
  import {
    tourList
  } from './../api/tourList.js'
  export default {
    name: 'index',
    data() {
      return {
        width: '3205',
        height: '7147',
        num: 1,
        touchDistance: 0,
        type: 0,
        test: '',
        scale: null,
        tourItemsState: false,
        tourIitemHeight: {},
        showMapContent: false,
        tourList: tourList,
        //
        wStyle: {
          width: '500px',
          height: '500px'
        }

      }
    },
    mounted() {
      this.wSetStyle()

      // 
      this.width = window.innerWidth
      this.height = window.innerHeight
      this.tourIitemHeight.maxHeight = window.innerHeight - 45 + 'px'
      this.$refs.mapContentp.style.width = this.width + 'px'
      this.$refs.mapContentp.style.height = this.height + 'px'
      console.log(this.$refs.mapContentp.style)


      touch.on(document.getElementById('mapMask'), 'pinchin', (e) => {
        this.type = -1
        this.scale = e.scale
      });
      touch.on(document.getElementById('mapMask'), 'pinchout', (e) => {
        this.type = 1
        this.scale = e.scale
      })
      touch.on(document.getElementById('mapMask'), 'pinchend', (e) => {
        this.touchDistance = (e.scale * this.type).toFixed(2)
        alert(4)
      });

      setTimeout(() => {
        this.showMapContent = true
        this.showOpenMap()
      }, 1000)
    },
    created() {
      this.showOpenMap()
      window.location.reload()

    },
    watch: {

      touchDistance() {
        this.test = this.touchDistance
      },
      scale() {
        if (this.scale > 2 || this.scale < 0.5) return
        setTimeout(() => {
          this.$refs.mapCstyle.style.transform = 'scale(' + this.scale + ')'
        }, 100)
      }
    },
    methods: {
      //初始化div
      wSetStyle() {
        this.wStyle = {
          width: window.innerWidth + 'px',
          height: window.innerHeight + 'px'
        }
      },
      test2() {
        alert(2)
      },
      // 初始化显示地图景点
      showOpenMap() {
        var ww = window.innerHeight
        if (ww <= 480) window.scrollTo(1250, 800);
        if (ww >= 480 && ww <= 667) window.scrollTo(1250, 750);
        if (ww > 667) window.scrollTo(1250, 700);
        this.$refs.largeOrSmall.style.transform = 'scale(0.4)'
        this.$refs.largeOrSmall.style.transform = 'scale(1)'
      },
      // open景点列表
      showTourItem() {
        this.tourItemsState = !this.tourItemsState
      },
      // 跳到景点
      goToTour(item) {
        console.log(item)
        this.tourItemsState = false
        document.getElementById('mapCstyle').scrollTop = item.scrollTo.x - this.width * 0.5
        document.getElementById('mapCstyle').scrollLeft = item.scrollTo.y - this.height * 0.5
        return
        this.$refs.largeOrSmall.style.transform = 'scale(1)'
        if (item.name == '全部景点') {
          this.showOpenMap();
        } else {
          window.scrollTo(item.scrollTo.x - this.width * 0.5, item.scrollTo.y - this.height * 0.5);
        }

      }
    }
  }

</script>
<style>
  body {
    overflow: hidden
  }

  * {
    padding: 0;
    margin: 0
  }

  .map-p-style {
    border: 1px solid red;
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
    border: 1px solid #000;
    width: 3205px;
    height: 1970px;
  }

  .map-iframe-style {
    width: 3205px;
    height: 1970px;
    border: 0px;
    position: absolute;
    top: 0;
    left: 0;
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
    border: 1px solid red;
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
    border-top: 1px solid #cccccc;
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

  .item:last-child {
    border-left: 1px solid #cccccc;
  }

  .tour-item {
    position: fixed;
    left: 0;
    bottom: 45px;
    width: 50%;
    text-align: center;
    background-color: #fff;
    z-index: 9;
    border-top: 1px solid #cccccc;
    border-right: 1px solid #cccccc;
    overflow-y: auto;
  }

  .tour-item li {
    height: 45px;
    line-height: 45px;
    color: #353535;
    border-bottom: 1px solid #cccccc;
    font-size: 15px;
  }

</style>
