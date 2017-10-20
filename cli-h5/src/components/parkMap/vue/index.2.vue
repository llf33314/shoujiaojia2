<template>
  <section>
    <div class="map-content" @click="doTouchstart" id="mapContent" style="z-index: 999;">
      <div id="largeOrSmall"  style="border:1px solid red;z-index:1;width:3205px;height:7147px;position:fixed;">
        <div class="red-station">红色交通站</div>
        <div class="shantou-mansion">汕头大厦 </div>
        <!-- <img src="./../img/map.png"  style="height:7147px;width:3205px;" alt=""> -->
        <!-- <object data="./static/imgs/map.svg" width="3205" height="7147" style="z-index:-1" type="image/svg+xml" codebase="http://www.adobe.com/svg/viewer/imstall/" /> -->
        <iframe  src="./static/imgs/map.svg" width="3205" height="7147" style="border:0;">

        </iframe>

      </div>
    </div>
    <div class="tab" id="tab">
      <div class="item" @click="largeOrNarrow(true)">放大</div>
      <div class="item" @click="largeOrNarrow(false)">缩小{{num}}</div>
    </div>
  </section>
</template>
<script>
  export default {
    name: 'index',
    data() {
      return {
        width: '3205',
        height: '7147',
        num: 1,
        e: ''
      }
    },
    mounted() {
      this.width = window.innerWidth
      this.height = window.innerHeight
      $("#largeOrSmall").css({
        'transform': 'scale(1)',
      });
      // document.getElementById('largeOrSmall').addEventListener("touchstart", function () {
      //   console.log(999)
      // });
      // $('body').on('click','#largeOrSmall',function(){
      //   console.log('999')
      // })
    },
    methods: {
      doTouchstart(e) {
        console.log('doTouchstart')
      },
      // 放大、缩小
      largeOrNarrow(type) {
        if (type) this.num += 0.1
        else this.num -= 0.1

        if (this.num <= 0.4 || this.num > 1) return
        console.log(this.num)
        $("#largeOrSmall").css({
          'transform': 'scale(' + this.num + ')',
          //'transform-origin': ''+mapW+' '+mapH+''
        });
      },
      //红色交通
      getRedStation() {
        alert(44)
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
    width: 100%;
    height: 100%;
  }

  .map-item {
    width: 3205px;
    height: 4502px;
    position: relative;
  }

  .map-iframe {
    position: absolute;
    top: -37%;
    left: 0;
    z-index: 1;
  }

  .red-station {
    position: absolute;
    top: 2200px;
    left: 810px;
    z-index: 1;
  }

  .shantou-mansion {
    position: absolute;
    top: 2110px;
    left: 1080px;
    z-index: 1;
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
    border-top: 1px solid #dddddd;
  }

  .item {
    width: 50%;
    float: left;
    height: 40px;
    line-height: 40px;
    box-sizing: border-box;
  }

  .item:last-child {
    border-left: 1px solid #dddddd;
  }

</style>
