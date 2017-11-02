<template>
    <div style="overflow: hidden;">
        <div class="a-in-stop-head">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item :to="{ path: '/parkMapAdmin/index', query: { manage: 'videoList' } }">直播视频管理</el-breadcrumb-item>
                <el-breadcrumb-item>新建视频</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div style="margin:0 30px; ">
            <el-form :model="addVideoReq" :rules="addVideoRules" ref="addVideoReq" label-width="130px" class="demo-ruleForm">
                <div  class="a-in-stop-title">编辑直播视频</div>
                <div class="a-in-stop-box">
                    <el-form-item label="视频名称：" prop="videoName">
                        <el-input v-model="addVideoReq.videoName" style="width: 251px!important;"></el-input>
                    </el-form-item>
                    <el-form-item label="封面图：" prop="imgUrl">
                        <gt-material prop="imgUrl" :url="addVideoReq.imgUrl" v-on:getChangeUrl="getChangeUrl" width="80" height="80"></gt-material>
                        <p class="a-in-stop-prompt">建议上传1:1尺寸图片</p>
                    </el-form-item>
                    <el-form-item label="直播链接：" prop="videoUrl">
                        <el-input v-model="addVideoReq.videoUrl" style="width: 251px!important;"></el-input>
                    </el-form-item>
                </div>
                <div class="a-in-stop-box">
                    <el-form-item style="margin-top: 80px;">
                        <el-button type="primary" @click="submitForm('addVideoReq')">保存</el-button>
                        <el-button type="primary" @click="resetForm('addVideoReq')">返回</el-button>
                    </el-form-item>
                </div>
            </el-form>
        </div>
    </div>
</template>
<script>
import { requestAddVideo } from '../api/api';
export default {
  data() {
    return {
      addVideoReq: {
        videoName: '',
        imgUrl: '',
        videoUrl: ''
      },
      addVideoRules: {
        videoName: [{ required: true, message: '请填写视频名称', trigger: 'blur' }],
        imgUrl: [{ required: true, message: '请上传封面图', trigger: 'blur' }],
        videoUrl: [{ required: true, message: '请设置直播链接', trigger: 'blur' }]
      }
    };
  },
  methods: {
    submitForm(formName) {
      console.log(this.addVideoReq);
      this.$refs[formName].validate(valid => {
        if (valid) {
          this.addVide();
        } else {
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
      this.$router.push({
        path: '/parkMapAdmin/index',
        query: { manage: 'videoList' }
      });
    },
    getChangeUrl(e) {
      // 获取素材库的图片url
      this.addVideoReq[e.prop] = e.url;
    },
    addVide() {
      requestAddVideo(this.addVideoReq).then(data => {
        // console.log(data);
        var _code = data.code;
        if (_code == 100) {
          this.$message({
            message: '新增视频成功！',
            type: 'success'
          });
          this.$router.push({
            path: '/parkMapAdmin/index',
            query: { manage: 'videoList' }
          });
        } else {
          this.$message.error(data.msg + '[错误码：' + _code + ']');
        }
      });
    }
  }
};
</script>
<style>
.a-in-stop-head {
  display: inline-block;
  padding: 30px 0 0 29px;
  font-size: 16px;
  width: 100%;
  height: 51px;
  background-color: rgba(248, 248, 248, 1);
}
.a-in-stop-title {
  width: 749px;
  height: 60px;
  font-size: 14px;
  line-height: 60px;
  margin: 2px 0 35px;
  color: #666;
  border-bottom: 1px solid #ddd;
}
.a-in-stop-box {
  width: 600px;
  padding-left: 80px;
}
.a-in-stop-prompt {
  display: inline-block;
  position: absolute;
  top: 25px;
  left: 100px;
  color: #999;
  font-size: 12px;
}
.el-form-item {
  margin-bottom: 26px;
}
.el-textarea__inner {
  height: 150px;
}
</style>
