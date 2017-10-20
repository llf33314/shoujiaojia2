<template>
  <section>
    <div v-show="showMapContent">
      <div class="map-content">
        <div class="map-item-c" id="largeOrSmall">
          <div class="map-mask" id="mapMask">
            <div class="red-station" id="redStation" @click.stop="test2">红色交通站</div>
            <div class="shantou-mansion" id="shantouMansion" @click.stop="test2">汕头大厦 </div>
          </div>
          <iframe class="map-iframe1" src="./static/imgs/map.svg">
          </iframe>
        </div>
      </div>
      <div class="tab">
        <div class="item" @click="showTourItem">景点</div>
        <div class="item" @click="largeOrNarrow(false)">周边吃住</div>
      </div>
      <ul class="tour-item" id="tourItem" v-show="tourItemsState" :style="tourIitemHeight">
        <li v-for="(item,index) in tourList" @click="goToTour(item)" v-text="item.name"></li>
      </ul>
    </div>
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
        tourList: tourList
      }
    },
    mounted() {
      this.width = window.innerWidth
      this.height = window.innerHeight
      this.tourIitemHeight.maxHeight = window.innerHeight - 45 + 'px'


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
      });

      setTimeout(() => {
        this.showMapContent = true
        this.showOpenMap()

      }, 1000)
    },
    created() {
      this.showOpenMap()
    },
    watch: {
      touchDistance() {
        this.test = this.touchDistance
      },
      scale() {
        if (this.scale > 2 || this.scale < 0.5) return
        setTimeout(() => {
          $("#largeOrSmall").css({
            'transform': 'scale(' + this.scale + ')',
          });
        }, 100)
      }
    },
    methods: {
      test2() {
        alert(2)
      },
      // 初始化显示地图景点
      showOpenMap() {
        var ww = window.innerHeight
        if (ww <= 480) window.scrollTo(1250, 800);
        if (ww >= 480 && ww <= 667) window.scrollTo(1250, 750);
        if (ww > 667) window.scrollTo(1250, 700);
        $("#largeOrSmall").css({
          'transform': 'scale(0.4)',
        });
      },
      // open景点列表
      showTourItem() {
        this.tourItemsState = !this.tourItemsState
      },
      // 跳到景点
      goToTour(item) {
        console.log(item)
        this.tourItemsState = false
        $("#largeOrSmall").css({
          'transform': 'scale(1)',
        });
        if (item.name == '全部景点') {
          this.showOpenMap();
        } else {
          window.scrollTo(item.scrollTo.x, item.scrollTo.y);
        }
      }
    }
  }

</script>
<style>
  * {
    padding: 0;
    margin: 0
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

  .red-station {
    position: absolute;
    top: 1231px;
    left: 822px;
    border: 1px solid red;
    height: 50px;
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
