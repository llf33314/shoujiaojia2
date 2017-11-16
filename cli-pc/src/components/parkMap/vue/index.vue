<style lang="less">


</style>
<template>
  <div>
    <el-breadcrumb class="public-crumbs" separator="/">
      <el-breadcrumb-item>定制开发</el-breadcrumb-item>
      <el-breadcrumb-item>小公园</el-breadcrumb-item>
    </el-breadcrumb>
    <div class="public-content">
      <el-tabs v-model="manage" type="card" @tab-click="handleClick" style="margin-top:30px;">
        <el-tab-pane label="直播管理" name="videoList"></el-tab-pane>
        <el-tab-pane label="餐饮管理" name="eatList"></el-tab-pane>
        <el-tab-pane label="住宿管理" name="hotelList"></el-tab-pane>
      </el-tabs>
      <router-view></router-view>
    </div>
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
        this.$router.push({
          path: '/parkMapAdmin/' + tab.name
        });
      }
    },
    created() {
      if (this.$route.query.manage != null && this.$route.query.manage != '') {
        this.manage = this.$route.query.manage;
      }
      this.$router.push({
        path: '/parkMapAdmin/' + this.manage
      });
    }
  };

</script>
