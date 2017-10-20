<template>
  <div class="a-in-top" >
    <el-tabs v-model="manage" type="card" @tab-click="handleClick">
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
      manage: 'eatList'
    };
  },
  methods: {
    handleClick(tab, event) {
      this.$router.push({ path: '/parkMapAdmin/' + tab.name });
    }
  }
};
</script>
<style>
.el-tabs__header {
    margin-bottom: 40px;
}
.a-in-top{
    background: #fafbfc;
    margin-bottom: 30px;
    padding-top: 60px;
    padding-left: 25px;
}
</style>
