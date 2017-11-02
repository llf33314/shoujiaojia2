<template>
    <div>
        <div class="a-in-add">
            <el-button type="primary" @click="addVideoClick">新增</el-button>
            <el-button type="primary" @click="openMainVideoClick">主视频</el-button>
        </div>
        <div class="a-in-add-list">
            已创建直播视频列表
        </div>
        <el-table :data="videoListData" border highlight-current-row style="width: 100%">
            <el-table-column prop="videoName" label="直播视频"></el-table-column>
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
        <!-- 弹窗 -->
        <div>
          <el-dialog title="主视频管理" :visible.sync="dialogStaffVisible">
            <el-form :model="videoMainData" :rules="videoMainRule" ref="videoMainData">
              <el-form-item label="置顶封面图" prop="mainImgUrl" :label-width="formLabelWidth">
                <gt-material prop="mainImgUrl" :url="videoMainData.mainImgUrl" v-on:getChangeUrl="getChangeUrl"  width="80" height="80"></gt-material>
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
  requestDelVideo
} from '../api/api';
export default {
  data() {
    return {
      videoListData: [],
      videoMainData: {
        id: '',
        mainImgUrl: '',
        mainVideoUrl: ''
      },
      dialogStaffVisible: false,
      formLabelWidth: '120px',
      videoMainRule:{
        mainImgUrl: [{ required: true, message: "请上传封面图", trigger: "blur" }],
        mainVideoUrl: [{ required: true, message: "请设置直播链接", trigger: "blur" }]
      }
    };
  },
  methods: {
    listVideos() {
      requestListVideos().then(data => {
        console.log(data);
        var _code = data.code;
        if (_code == 100) {
          this.videoListData = data.data;
        } else {
          this.$message.error(data.msg + '[错误码：' + _code + ']');
        }
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
            message: "主视频设置成功！",
            type: "success"
          });
        } else {
          this.$message.error(data.msg + '[错误码：' + _code + ']');
        }
      });
    },
    editVideo(videoInfo) {
      console.log(videoInfo);
      this.$router.push({ path: "/parkMapAdmin/modifyVideo/", query: videoInfo });
    },
    delVideo(id) {
      this.$confirm('此操作将永久删除，是否继续？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        requestDelVideo({ id: id }).then(data => {
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
      this.$router.push({ path: '/parkMapAdmin/addVideo' });
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
    }
  },
  created() {
    this.listVideos();
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
</style>
