<style>
  .parkmap-hotellist {}

</style>
<template>
  <div class="parkmap-hotellist">
    <div class="public-gray-region">
      <el-button type="primary" @click="addHotelClick">新增</el-button>
    </div>
    <el-table :data="hotelListData" border highlight-current-row v-loading="loading" style="width: 100%">
      <el-table-column prop="name" label="店铺名称"></el-table-column>
      <el-table-column prop="address" label="地址"></el-table-column>
      <el-table-column prop="phone" label="电话"></el-table-column>
      <el-table-column label="创建时间">
        <template slot-scope="scope">
          <el-icon name="time"></el-icon>
          <span style="margin-left: 10px">{{ $util.DateFormat(scope.row.createTime, "yyyy-MM-dd hh:mm") }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button size="small" @click="editHotel(scope.row)">编辑</el-button>
          <el-button size="small" type="danger" @click="delHotel(scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination class="public-fr public-top20" @current-change="handleCurrentChange" current-page.sync="1" :page-size="10" layout="prev, pager, next, jumper" :total="page.totalNums"> 
      </el-pagination>
  </div>
</template>
<script>
  import {
    requestListHotels,
    requestDelHotel
  } from '../api/api';
  export default {
    data() {
      return {
        hotelListData: [],
        hotelListReq: {
          current: 0,
          size: 10
        },
        page: {
          totalNums: 1,
          totalPages: 1
        },
        loading: false
      };
    },
    methods: {
      listHotels() {
        this.loading = true;
        requestListHotels(this.hotelListReq).then(data => {
          // console.log(data);
          var _code = data.code;
          if (_code == 100) {
            this.hotelListData = data.data;
            this.page.totalNums = data.page.totalNums;
            this.page.totalPages = data.page.totalPages;
          } else {
            this.$message.error(data.msg + '[错误码：' + _code + ']');
          }
          this.loading = false;
        });
      },
      editHotel(hotelInfo) {
        console.log(hotelInfo);
        this.$router.push({
          path: '/parkMapAdmin/modifyHotel',
          query: hotelInfo
        });
      },
      delHotel(id) {
        this.$confirm('此操作将永久删除该店铺以及相关数据，是否继续？', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          requestDelHotel({
            id: id
          }).then(data => {
            var _code = data.code;
            if (_code == 100) {
              this.$message({
                type: 'success',
                message: '您已删除该店铺信息！'
              });
              this.listHotels();
            } else {
              this.$message.error(data.msg + '[错误码：' + _code + ']');
            }
          });
        });
      },
      addHotelClick() {
        this.$router.push({
          path: '/parkMapAdmin/addHotel'
        });
      },
      handleCurrentChange(val) {
        this.listHotels();
      },
      handleSizeChange(val) {
        this.hotelListReq.size = val;
        this.listHotels();
      }
    },
    created() {
      this.listHotels();
    }
  };

</script>
