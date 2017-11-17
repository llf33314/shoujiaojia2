<style lang="less">
  .parkmap-modifyhotel {
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
  <div class="parkmap-modifyhotel">
    <el-breadcrumb class="public-crumbs" separator="/">
      <el-breadcrumb-item :to="{ path: '/parkMapAdmin/index', query: { manage: 'hotelList' } }">住宿管理</el-breadcrumb-item>
      <el-breadcrumb-item>编辑店铺</el-breadcrumb-item>
    </el-breadcrumb>
    <div class="public-content">
      <el-form :model="modifyHotelReq" :rules="modifyHotelRules" ref="modifyHotelReq" label-width="130px" class="demo-ruleForm">

        <el-form-item label="店铺名称" prop="name">
          <el-input v-model="modifyHotelReq.name" style="width: 251px!important;"></el-input>
        </el-form-item>
        <el-form-item label="LOGO上传" prop="logoUrl">
          <gt-material prop="logoUrl" :url="modifyHotelReq.logoUrl" v-on:getChangeUrl="getChangeUrl" width="80" height="80"></gt-material>
          <p class="a-in-stop-prompt">建议上传1:1尺寸图片</p>
        </el-form-item>
        <el-form-item label="文案介绍" prop="introduce">
          <el-input v-model="modifyHotelReq.introduce" style="width: 251px!important;"></el-input>
        </el-form-item>
        <el-form-item label="店铺地址" prop="address">
          <gtmap :gtmapInformation.sync="mapBean" style="width: 251px!important;"></gtmap>
        </el-form-item>
        <el-form-item label="店铺电话" prop="phone">
          <el-input v-model="modifyHotelReq.phone" style="width: 251px!important;"></el-input>
        </el-form-item>
        <el-form-item label="Banner图" prop="bannerUrl">
          <gt-material prop="bannerUrl" :url="modifyHotelReq.bannerUrl" v-on:getChangeUrl="getChangeUrl" width="80" height="80"></gt-material>
          <p class="a-in-stop-prompt">建议上传360*200尺寸图片</p>
        </el-form-item>
        <el-form-item label="店铺介绍" prop="remark">
          <el-input type="textarea" v-model="modifyHotelReq.remark" style="width: 300px!important;"></el-input>
        </el-form-item>
        <el-form-item style="margin-top: 80px;">
          <el-button type="primary" @click="submitForm('modifyHotelReq')">保存</el-button>
          <el-button type="primary" @click="resetForm('modifyHotelReq')">返回</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>
<script>
  import {
    requestModifyHotel
  } from '../api/api';
  import gtmap from '@/components/PublicVue/map/gtMap.vue';
  export default {
    data() {
      const isPhone = (rule,value,callback)=>{
        if(value ===''){
          callback(new Error('请输入店铺电话'));
        }else{
          if(!this.phone(value)){
            callback(new Error('请输入正确店铺电话'));
          }
          callback();
        }
      }
      return {
        modifyHotelReq: {
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
        modifyHotelRules: {
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
            validator:isPhone,
            trigger: 'blur'
          }],
          bannerUrl: [{
            required: true,
            message: '请选择上传banner图',
            trigger: 'blur'
          }]
        }
      };
    },
    methods: {
      submitForm(formName) {
        console.log(this.mapBean);
        try {
          this.modifyHotelReq.address = this.mapBean.MapData.address;
          this.modifyHotelReq.lat = this.mapBean.MapData.latLng.lat;
          this.modifyHotelReq.lon = this.mapBean.MapData.latLng.lng;
        } catch (error) {}
        console.log(this.modifyHotelReq);
        this.$refs[formName].validate(valid => {
          if (valid) {
            this.modifyHotel();
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
            manage: 'hotelList'
          }
        });
      },
      getChangeUrl(e) {
        // 获取素材库的图片url
        this.modifyHotelReq[e.prop] = e.url;
      },
      modifyHotel() {
        console.log('save obj : ' + this.modifyHotelReq);
        requestModifyHotel(this.modifyHotelReq).then(data => {
          // console.log(data);
          var _code = data.code;
          if (_code == 100) {
            this.$message({
              message: '编辑酒店店铺成功！',
              type: 'success'
            });
            this.$router.push({
              path: '/parkMapAdmin/index',
              query: {
                manage: 'hotelList'
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
      this.modifyHotelReq = this.$route.query;
      this.mapBean.detailedAddress = this.modifyHotelReq.address;
    },
    components: {
      gtmap
    }
  };

</script>
