<template>
  <div class="a-in-top" >
    <el-tabs v-model="manage" type="card" @tab-click="handleClick">
      <el-tab-pane label="直播管理" name="videoList"></el-tab-pane>
      <el-tab-pane label="餐饮管理" name="eatList"></el-tab-pane>
      <el-tab-pane label="住宿管理" name="hotelList"></el-tab-pane>
    </el-tabs>
    <router-view></router-view>
  </div>
</template>
<script>
export default {
  data() {
    return {
      manage: 'videoList'
    };
  },
  methods: {
    handleClick(tab, event) {
      this.$router.push({ path: '/parkMapAdmin/' + tab.name });
    }
  },
  created() {
    if (this.$route.query.manage != null && this.$route.query.manage != '') {
      this.manage = this.$route.query.manage;
    }
    this.$router.push({ path: '/parkMapAdmin/' + this.manage });
  }
};
</script>
<style>
.el-tabs__header {
  margin-bottom: 40px;
}
.a-in-top {
  margin-bottom: 30px;
  padding: 30px 25px 70px;
}
</style>
