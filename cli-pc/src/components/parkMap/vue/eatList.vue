<template>
    <div>
        <div class="a-in-add">
            <el-button type="primary" @click="addEatClick">新增</el-button>
        </div>
        <div class="a-in-add-list">
            已创建店铺列表
        </div>
        <el-table :data="eatListData" border highlight-current-row v-loading="loading" style="width: 100%">
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
                    <el-button size="small" @click="editEat(scope.row)">编辑</el-button>
                    <el-button size="small" type="danger" @click="delEat(scope.row.id)">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
        <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page.sync="eatListReq.current" 
          :page-sizes="[10, 20, 50, 100]" :page-size="eatListReq.size" layout="total, sizes, prev, pager, next" :total="page.totalNums">
        </el-pagination>
    </div>
</template>
<script>
import { requestListEats, requestDelEat } from '../api/api';
export default {
  data() {
    return {
      eatListData: [],
      eatListReq: {
        current: 0,
        size: 10
      },
      page:{
        totalNums: 1,
        totalPages: 1
      },
      loading: false
    };
  },
  methods: {
    listEats() {
      this.loading = true;
      requestListEats(this.eatListReq).then(data => {
        // console.log(data);
        var _code = data.code;
        if (_code == 100) {
          this.eatListData = data.data;
          this.page.totalNums = data.page.totalNums;
          this.page.totalPages = data.page.totalPages;
        } else {
          this.$message.error(data.msg + '[错误码：' + _code + ']');
        }
        this.loading = false;
      });
    },
    editEat(eatInfo) {
      console.log(eatInfo);
      this.$router.push({ path: '/parkMapAdmin/modifyEat/', query: eatInfo });
    },
    delEat(id) {
      this.$confirm('此操作将永久删除该店铺以及相关数据，是否继续？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        requestDelEat({ id: id }).then(data => {
          var _code = data.code;
          if (_code == 100) {
            this.$message({
              type: 'success',
              message: '您已删除该店铺信息！'
            });
            this.listEats();
          } else {
            this.$message.error(data.msg + '[错误码：' + _code + ']');
          }
        });
      });
    },
    addEatClick() {
      this.$router.push({ path: '/parkMapAdmin/addEat' });
    },
    handleCurrentChange(val) {
      this.listEats();
    },
    handleSizeChange(val) {
      this.eatListReq.size = val;
      this.listEats();
    }
  },
  created() {
    this.listEats();
  }
};
</script>
<style>
.a-in-add {
  width: 100%;
  height: 91px;
  background: inherit;
  background-color: rgba(248, 248, 248, 1);
  box-sizing: border-box;
  border-width: 1px;
  border-style: solid;
  border-color: rgba(236, 236, 236, 1);
  -moz-box-shadow: none;
  line-height: 91px;
  padding-left: 26px;
  margin-bottom: 15px;
}
.a-in-add-list {
  font-size: 14px;
  color: #333;
  margin: 25px 30px;
}
.el-table td,
.el-table th {
  height: 45px;
  min-width: 0;
  text-overflow: ellipsis;
  vertical-align: middle;
}
.el-breadcrumb__item__inner,
.el-breadcrumb__item__inner a {
  transition: color 0.15s linear;
  color: #2d8dfd;
}
.el-pagination {
    float: right;
    margin-top: 10px;
    margin-right: 20px;
}
</style>
