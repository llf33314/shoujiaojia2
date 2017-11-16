<template>
  <div>
    <div class="public-gray-region">
      <el-button type="primary" @click="addVideoClick">新增</el-button>
      <el-button type="primary" @click="openMainVideoClick">主视频</el-button>
    </div>
    <el-table :data="videoListData" border highlight-current-row v-loading="loading" @header-click="headerClick" style="width: 100%">
      <el-table-column prop="videoName" label="直播视频"></el-table-column>
      <el-table-column :label="sortBean.label" prop="videoSort">
        <template slot-scope="scope">
          <span v-show="sortModifyBoolean == false">{{scope.row.videoSort}}</span>
          <el-input v-show="sortModifyBoolean == true" v-model="scope.row.videoSort" type="number" auto-complete="off" placeholder="由小到大排序"></el-input>
        </template>
      </el-table-column>
      <el-table-column label="创建时间">
        <template slot-scope="scope">
          <el-icon name="time"></el-icon>
          <span style="margin-left: 10px">{{ $util.DateFormat(scope.row.createTime, "yyyy-MM-dd hh:mm") }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button size="small" @click="editVideo(scope.row)">编辑</el-button>
          <el-button size="small" type="danger" @click="delVideo(scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination class="public-fr public-top20" @current-change="handleCurrentChange" current-page.sync="1" :page-size="10" layout="prev, pager, next, jumper" :total="page.totalNums"> 
      </el-pagination>
    <div>
      <el-dialog title="主视频管理" :visible.sync="dialogStaffVisible">
        <el-form :model="videoMainData" :rules="videoMainRule" ref="videoMainData">
          <el-form-item label="置顶封面图" prop="mainImgUrl" :label-width="formLabelWidth">
            <gt-material prop="mainImgUrl" :url="videoMainData.mainImgUrl" v-on:getChangeUrl="getChangeUrl" width="144" height="80"></gt-material>
            <p class="a-in-stop-prompt">建议上传360*200尺寸图片</p>
          </el-form-item>
          <el-form-item label="直播链接" prop="mainVideoUrl" :label-width="formLabelWidth">
            <el-input v-model="videoMainData.mainVideoUrl" auto-complete="off" placeholder="请输入嵌入的直播视频链接"></el-input>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="dialogCancel">取 消</el-button>
          <el-button type="primary" @click="dialogConfirm('videoMainData')">确 定</el-button>
        </div>
      </el-dialog>
    </div>
  </div>
</template>
<script>
  import {
    requestListVideos,
    requestGetMainVideo,
    requestAddOrModifyMainVideo,
    requestDelVideo,
    requestModifySort
  } from '../api/api';
  export default {
    data() {
      return {
        videoListData: [],
        videoListReq: {
          current: 0,
          size: 10
        },
        page: {
          totalNums: 1,
          totalPages: 1
        },
        sortBean: {
          label: '排序（点击编辑）'
        },
        videoMainData: {
          id: '',
          mainImgUrl: '',
          mainVideoUrl: ''
        },
        dialogStaffVisible: false,
        formLabelWidth: '120px',
        videoMainRule: {
          mainImgUrl: [{
            required: true,
            message: '请上传封面图',
            trigger: 'blur'
          }],
          mainVideoUrl: [{
            required: true,
            message: '请设置直播链接',
            trigger: 'blur'
          }]
        },
        sortModifyBoolean: false,
        loading: false
      };
    },
    methods: {
      listVideos() {
        this.loading = true;
        requestListVideos(this.videoListReq).then(data => {
          console.log(data);
          var _code = data.code;
          if (_code == 100) {
            this.videoListData = data.data;
            this.page.totalNums = data.page.totalNums;
            this.page.totalPages = data.page.totalPages;
          } else {
            this.$message.error(data.msg + '[错误码：' + _code + ']');
          }
          this.loading = false;
        });
      },
      getMainVideo() {
        requestGetMainVideo().then(data => {
          console.log(data);
          var _code = data.code;
          if (_code == 100) {
            this.videoMainData = data.data;
          } else {
            this.$message.error(data.msg + '[错误码：' + _code + ']');
          }
        });
      },
      addOrModifyMainVideo() {
        requestAddOrModifyMainVideo(this.videoMainData).then(data => {
          console.log(data);
          var _code = data.code;
          if (_code == 100) {
            this.$message({
              message: '主视频设置成功！',
              type: 'success'
            });
          } else {
            this.$message.error(data.msg + '[错误码：' + _code + ']');
          }
        });
      },
      modifySort() {
        this.loading = true;
        requestModifySort(this.videoListData).then(data => {
          console.log(data);
          var _code = data.code;
          if (_code == 100) {
            this.$message({
              message: '保存成功！',
              type: 'success'
            });
          } else {
            this.$message.error(data.msg + '[错误码：' + _code + ']');
          }
        });
      },
      editVideo(videoInfo) {
        console.log(videoInfo);
        this.$router.push({
          path: '/parkMapAdmin/modifyVideo/',
          query: videoInfo
        });
      },
      delVideo(id) {
        this.$confirm('此操作将永久删除，是否继续？', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          requestDelVideo({
            id: id
          }).then(data => {
            var _code = data.code;
            if (_code == 100) {
              this.$message({
                type: 'success',
                message: '视频删除成功！'
              });
              this.listVideos();
            } else {
              this.$message.error(data.msg + '[错误码：' + _code + ']');
            }
          });
        });
      },
      getChangeUrl(e) {
        // 获取素材库的图片url
        this.videoMainData[e.prop] = e.url;
      },
      addVideoClick() {
        this.$router.push({
          path: '/parkMapAdmin/addVideo'
        });
      },
      openMainVideoClick() {
        this.getMainVideo();
        this.dialogStaffVisible = true;
      },
      dialogCancel() {
        this.dialogStaffVisible = false;
      },
      dialogConfirm(formName) {
        this.$refs[formName].validate(valid => {
          if (valid) {
            this.addOrModifyMainVideo();
            this.dialogStaffVisible = false;
          } else {
            return false;
          }
        });
      },
      handleCurrentChange(val) {
        this.listVideos();
      },
      handleSizeChange(val) {
        this.videoListReq.size = val;
        this.listVideos();
      },
      headerClick(column, event) {
        // 表格排序
        if (column.property == 'videoSort') {
          if (this.sortModifyBoolean === true) {
            // 保存
            this.sortBean.label = '排序（点击编辑）';
            this.modifySort();
            this.sortModifyBoolean = false;
            this.listVideos();
          } else {
            // 编辑
            this.sortBean.label = '编辑排序中（点击保存）';
            this.sortModifyBoolean = true;
          }
          console.log(this.sortModifyBoolean);
        }
      }
    },
    created() {
      this.listVideos();
    }
  };

</script>
