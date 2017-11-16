<style lang="less">
  .parkmap-addvideo {
    .a-in-stop-prompt {
      display: inline-block;
      font-size: 13px;
      color: #666;
      margin-left: 10px;
    }
    .public-content {
      padding-top: 30px;
    }
  }

</style>

<template>
  <div class="parkmap-addvideo" style="overflow: hidden;">
    <el-breadcrumb class="public-crumbs" separator="/">
      <el-breadcrumb-item :to="{ path: '/parkMapAdmin/index', query: { manage: 'videoList' } }">直播视频管理</el-breadcrumb-item>
      <el-breadcrumb-item>新建视频</el-breadcrumb-item>
    </el-breadcrumb>
    <div class="public-content">
      <el-form :model="addVideoReq" :rules="addVideoRules" ref="addVideoReq" label-width="130px" class="demo-ruleForm">
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
        <el-form-item style="margin-top: 80px;">
          <el-button type="primary" @click="submitForm('addVideoReq')">保存</el-button>
          <el-button type="primary" @click="resetForm('addVideoReq')">返回</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>
<script>
  import {
    requestAddVideo
  } from '../api/api';
  export default {
    data() {
      return {
        addVideoReq: {
          videoName: '',
          imgUrl: '',
          videoUrl: ''
        },
        addVideoRules: {
          videoName: [{
            required: true,
            message: '请填写视频名称',
            trigger: 'blur'
          }],
          imgUrl: [{
            required: true,
            message: '请上传封面图',
            trigger: 'blur'
          }],
          videoUrl: [{
            required: true,
            message: '请设置直播链接',
            trigger: 'blur'
          }]
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
          query: {
            manage: 'videoList'
          }
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
              query: {
                manage: 'videoList'
              }
            });
          } else {
            this.$message.error(data.msg + '[错误码：' + _code + ']');
          }
        });
      }
    }
  };

</script>
