<style>
  * {
    padding: 0;
    margin: 0;
  }

  .top-title {
    background-color: #efeff4;
    overflow: hidden;
    border-bottom: 1px solid #d6d6db;
  }

  .top-title li {
    list-style-type: none;
    line-height: 45px;
    height: 45px;
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
  }

  .type-list-item {
    display: flex;
    padding: 15px 10px 15px 15px;
    margin-bottom: 10px;
    background-color: #ffffff
  }

  .left-img {
    width: 100px;
    height: 100px;
    border: 1px solid red;
  }

  .right-content {
    flex: 1;
    color: #666;
    font-size: 14px;
    height: 100px;
    padding-left: 10px;
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
    width: 15px;
    vertical-align: middle;
    padding-right: 10px;
  }

  .dps.over {
    margin-bottom: 7px;
  }

</style>

<template>
  <section>
    <ul class="top-title">
      <li :class="type==1? 'bg':''" @click="selectType(1)">餐饮</li>
      <li :class="type==0? 'bg':''" @click="selectType(0)">住宿</li>
    </ul>
    <div class="type-box-list">
      <ul class="type-list" v-show="type==1">
        <li class="type-list-item">
          <div class="left-img">111</div>
          <div class="right-content">555</div>
        </li>
      </ul>
      <ul class="type-list" v-show="type==0">
        <li class="type-list-item">
          <div class="left-img">111</div>
          <div class="right-content">
            <h2 class="title">
              <span class="over" style="flex: 5;">飘香小吃飘香小吃店飘香小吃店飘香小吃店飘香小吃店店</span>
              <span style="flex: 1;font-size: 14px;color:#666;margin-top:5px;">1.5KM</span>
            </h2>
            <p class="dps over">汕头老字号，比邻小公园。</p>
            <p class="icon-text over">
              <img class="icon" src="./../img/address-icon.png" alt="地址">广东省汕头市金平区小公园国平路39号广东省汕头市金平区小公园国平路39号</p>
            <p class="icon-text over">
              <img class="icon" src="./../img/phone-icon.png" alt="电话">0754-888888</p>
          </div>
        </li>
      </ul>
    </div>
  </section>
</template>

<script>
  export default {
    data() {
      return {
        type: 0
      }
    },
    mounted() {
      this.type = this.$route.params.type
    },
    beforeMount() {
      document.title = '周报吃住列表'
    },
    methods: {
      selectType(type) {
        this.type = type
      }
    }
  }

</script>
