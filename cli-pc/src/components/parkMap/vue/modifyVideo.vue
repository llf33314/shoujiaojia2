<style lang="less">
  .parkmap-modifyvideo {
    .public-content {
      padding-top: 30px;
    }
    .a-in-stop-prompt {
      display: inline-block;
      font-size: 13px;
      color: #666;
      margin-left: 10px;
    }
  }

</style>

<template>
  <div class="parkmap-modifyvideo" style="overflow: hidden;">
    <el-breadcrumb class="public-crumbs" separator="/">
      <el-breadcrumb-item :to="{ path: '/parkMapAdmin/index', query: { manage: 'videoList' } }">直播视频管理</el-breadcrumb-item>
      <el-breadcrumb-item>编辑视频</el-breadcrumb-item>
    </el-breadcrumb>
    <div class="public-content">
      <el-form :model="modifyVideoReq" :rules="modifyVideoRules" ref="modifyVideoReq" label-width="130px" class="demo-ruleForm">

        <el-form-item label="视频名称" prop="videoName">
          <el-input v-model="modifyVideoReq.videoName" style="width: 251px!important;"></el-input>
        </el-form-item>
        <el-form-item label="封面图上传" prop="imgUrl">
          <gt-material prop="logoUrl" :url="modifyVideoReq.imgUrl" v-on:getChangeUrl="getChangeUrl" width="80" height="80"></gt-material>
          <p class="a-in-stop-prompt">建议上传1:1尺寸图片</p>
        </el-form-item>
        <el-form-item label="直播链接：" prop="videoUrl">
          <el-input v-model="modifyVideoReq.videoUrl" style="width: 251px!important;"></el-input>
        </el-form-item>
        <el-form-item style="margin-top: 80px;">
          <el-button type="primary" @click="submitForm('modifyVideoReq')">保存</el-button>
          <el-button type="primary" @click="resetForm('modifyVideoReq')">返回</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>
<script>
  import {
    requestModifyVideo
  } from '../api/api';
  export default {
    data() {
      return {
        modifyVideoReq: {
          videoName: '',
          imgUrl: '',
          videoUrl: ''
        },
        modifyVideoRules: {
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
        console.log(this.modifyVideoReq);
        this.$refs[formName].validate(valid => {
          if (valid) {
            this.modifyVideo();
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
        this.modifyVideoReq[e.prop] = e.url;
      },
      modifyVideo() {
        console.log('save obj : ', this.modifyVideoReq);
        requestModifyVideo(this.modifyVideoReq).then(data => {
          // console.log(data);
          var _code = data.code;
          if (_code == 100) {
            this.$message({
              message: '编辑视频成功！',
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
    },
    created() {
      console.log(this.$route.query);
      this.modifyVideoReq = this.$route.query;
    }
  };

</script>
