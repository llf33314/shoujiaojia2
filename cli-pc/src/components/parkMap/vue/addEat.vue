<style lang="less">
  .parkmap-addeat {
    .a-in-stop-prompt {
      display: inline-block;
      font-size: 13px;
      color: #666;
      margin-left: 10px;
    }
    .public-content{
      padding-top:30px;
    }
  }

</style>
<template>
  <div class="parkmap-addeat">
    <el-breadcrumb class="public-crumbs" separator="/">
      <el-breadcrumb-item :to="{ path: '/parkMapAdmin/index', query: { manage: 'eatList' } }">餐饮管理</el-breadcrumb-item>
      <el-breadcrumb-item>新增店铺</el-breadcrumb-item>
    </el-breadcrumb>
    <div class="public-content">
      <el-form :model="addEatReq" :rules="addEatRules" ref="addEatReq" label-width="130px" class="demo-ruleForm">
        <el-form-item label="店铺名称：" prop="name">
          <el-input v-model="addEatReq.name" style="width: 251px!important;"></el-input>
        </el-form-item>
        <el-form-item label="LOGO上传：" prop="logoUrl">
          <gt-material prop="logoUrl" :url="addEatReq.logoUrl" v-on:getChangeUrl="getChangeUrl" width="80" height="80"></gt-material>
          <p class="a-in-stop-prompt">建议上传1:1尺寸图片</p>
        </el-form-item>
        <el-form-item label="文案介绍：" prop="introduce">
          <el-input v-model="addEatReq.introduce" style="width: 251px!important;"></el-input>
        </el-form-item>
        <el-form-item label="店铺地址：" prop="address">
          <gtmap :gtmapInformation.sync="mapBean" v-on:getMapData="getMapData" style="width: 251px!important;"></gtmap>
        </el-form-item>
        <el-form-item label="店铺电话：" prop="phone">
          <el-input v-model="addEatReq.phone" style="width: 251px!important;"></el-input>
        </el-form-item>

        <!-- <div class="public-table-title">编辑店铺信息</div>
        <div class="a-in-stop-box">

        </div>
        <div class="public-table-title">编辑店铺详情页</div>
        <div class="a-in-stop-box"> -->
        <el-form-item label="Banner图：" prop="bannerUrl">
          <gt-material prop="bannerUrl" :url="addEatReq.bannerUrl" v-on:getChangeUrl="getChangeUrl" width="80" height="80"></gt-material>
          <p class="a-in-stop-prompt">建议上传360*200尺寸图片</p>
        </el-form-item>
        <el-form-item label="店铺介绍：" prop="remark">
          <el-input type="textarea" v-model="addEatReq.remark" style="width: 300px!important;"></el-input>
        </el-form-item>
        <el-form-item style="margin-top: 80px;">
          <el-button type="primary" @click="submitForm('addEatReq')">保存</el-button>
          <el-button type="primary" @click="resetForm('addEatReq')">返回</el-button>
        </el-form-item>
        <!-- </div> -->
      </el-form>
    </div>
  </div>
</template>
<script>
  import {
    requestAddEat
  } from '../api/api';
  import gtmap from '@/components/PublicVue/map/gtMap.vue';
  export default {
    data() {
      return {
        addEatReq: {
          name: '', // 名称
          logoUrl: '', // logo
          introduce: '', // 简介
          address: '', // 地址
          phone: '', // 手机
          bannerUrl: '', // banner
          remark: '', // 详细介绍
          lat: '', // 经度
          lon: '' // 纬度
        },
        mapBean: {
          label: '',
          detailedAddress: ''
        },
        addEatRules: {
          name: [{
              required: true,
              message: '请输入店铺名称',
              trigger: 'blur'
            },
            {
              min: 1,
              max: 7,
              message: '长度不超过7个字符',
              trigger: 'blur'
            }
          ],
          logoUrl: [{
            required: true,
            message: '请选择上传的logo图',
            trigger: 'blur'
          }],
          introduce: [{
              required: true,
              message: '请输入介绍文案',
              trigger: 'blur'
            },
            {
              min: 1,
              max: 7,
              message: '长度不超过7个字符',
              trigger: 'blur'
            }
          ],
          address: [{
            required: true,
            message: '请选择店铺地址',
            trigger: 'blur'
          }],
          phone: [{
            required: true,
            message: '请输入店铺电话',
            trigger: 'blur'
          }],
          // lat: [{ required: true, message: "请选择地图信息", trigger: "blur" }],
          bannerUrl: [{
            required: true,
            message: '请选择上传banner图',
            trigger: 'blur'
          }]
        }
      };
    },
    methods: {
      //自动获取地图信息
      getMapData(e) {
        console.log(e, 'mapdata')
        this.addEatReq.address = e.name
        this.addEatReq.lat = e.lat
        this.addEatReq.lon = e.lng

      },
      submitForm(formName) {
        console.log(this.addEatReq);
        this.$refs[formName].validate(valid => {
          if (valid) {
            this.addEat();
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
            manage: 'eatList'
          }
        });
      },
      getChangeUrl(e) {
        // 获取素材库的图片url
        this.addEatReq[e.prop] = e.url;
      },
      addEat() {
        requestAddEat(this.addEatReq).then(data => {
          // console.log(data);
          var _code = data.code;
          if (_code == 100) {
            this.$message({
              message: '新增餐饮店铺成功！',
              type: 'success'
            });
            this.$router.push({
              path: '/parkMapAdmin/index',
              query: {
                manage: 'eatList'
              }
            });
          } else {
            this.$message.error(data.msg + '[错误码：' + _code + ']');
          }
        });
      }
    },
    components: {
      gtmap
    },
    watch: {
      mapBean: function (val) {
        //此处不要使用箭头函数
        console.log('watch', val);
        this.addEatReq.address = val.MapData.address;
        this.addEatReq.lat = val.MapData.latLng.lat;
        this.addEatReq.lon = val.MapData.latLng.lng;
        console.log(this.addEatReq);
      }
    }
  };

</script>
