<template>
  <section>
    <div class="map-content">
        <iframe class="map-iframe" id="iframe" src="./static/imgs/map.svg"  width="3205"  height="7147" style="border:0">
        </iframe>
    </div>
    <div class="tab">
      <div class="item" @click="large">放大</div>
      <div class="item" @click="large">放大</div>
    </div>
  </section>
</template>
<script>
  //import $ from './../../../assets/jquery-vendor.js'
  export default {
    name: 'index',
    data() {
      return {
        width: '3205',
        height: '7147'
      }
    },
    mounted() {
      this.width = window.innerWidth
      this.height = window.innerHeight

    },
    methods: {
      large(){
        console.log(4)
        console.log($("#iframe").contents().find("#mapSvg"))
        $("#iframe").contents().find("#mapSvg").css({
          // 'transform': 'scale(0.2)',
          // 'transform-origin': '1px 10px'
        });
      }
    }
  }

</script>
<style>
  * {
    padding: 0;
    margin: 0
  }
  .map-content{
    position: absolute;
    top:0;
    left:0;
    width: 100%;
    height: 100%;
  }
  .map-iframe{
    position: absolute;
    top:10%;
    left:5%;
  }
  .map {
    height: 500px;
    width: 500px;
    border: 1px solid #000000;
  }
  .tab{
    position: fixed;
    bottom: 0;
    left:0;
    width:100%;
    background-color: #fff;
    text-align: center;
    border-top:1px solid #dddddd;
  }
  .item{
    width: 50%;
    float: left;
    height:40px;
    line-height: 40px;
    box-sizing: border-box;
  }
  .item:last-child{
    border-left: 1px solid #dddddd;
  }
</style>
