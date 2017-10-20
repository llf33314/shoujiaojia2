<template>
    <div style="overflow: hidden;">
        <div class="a-in-stop-head">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item :to="{ path: '/parkMapAdmin/eatList' }">餐饮管理</el-breadcrumb-item>
                <el-breadcrumb-item>新增店铺</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div style="margin:0 30px; ">
            <el-form :model="addEatReq" :rules="addEatRules" ref="addEatReq" label-width="130px" class="demo-ruleForm">
                <div  class="a-in-stop-title">编辑店铺信息</div>
                <div class="a-in-stop-box">
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
                        <el-input v-model="addEatReq.address" style="width: 251px!important;"></el-input>
                    </el-form-item>

                    <!--
                        selectedOptions 地址的省份selectedOptions= ["130000", "130200", "130203"]
                        detailedAddress:详细地址信息
                        region 地址的省份 region='广东省惠州市惠阳区',
                    -->
                    <gt-map :selectedOptions="mapBean.selectedOptions" :detailedAddress.sync="mapBean.address" :region='mapBean.region' style="width: 381px!important;"></gt-map>
                    {{mapBean.address}}
                    <el-form-item label="店铺电话：" prop="phone">
                        <el-input v-model="addEatReq.phone" style="width: 251px!important;"></el-input>
                    </el-form-item>
                </div>
                <div class="a-in-stop-title">编辑店铺详情页</div>
                <div class="a-in-stop-box">
                    <el-form-item label="Banner图：" prop="bannerUrl">
                        <gt-material prop="bannerUrl" :url="addEatReq.bannerUrl" v-on:getChangeUrl="getChangeUrl" width="80" height="80"></gt-material>
                        <p class="a-in-stop-prompt">建议上传360*200尺寸图片</p>
                    </el-form-item>
                    <el-form-item label="店铺介绍：" prop="remark">
                        <el-input type="textarea" v-model="addEatReq.remark" style="width: 400px!important;" rows="4"></el-input>
                    </el-form-item>
                    <el-form-item style="margin-top: 80px;">
                        <el-button type="primary" @click="submitForm('addEatReq')">保存</el-button>
                        <el-button type="primary" @click="resetForm('addEatReq')">返回</el-button>
                    </el-form-item>
                </div>
            </el-form>
        </div>
    </div>
</template>
<script>
import { requestAddEat } from "../api/api";
import GtMap from "@/components/PublicVue/map/map.vue";
export default {
  data() {
    return {
      addEatReq: {
        name: "", // 名称
        logoUrl: "", // logo
        introduce: "", // 简介
        address: "", // 地址
        phone: "", // 手机
        bannerUrl: "", // banner
        remark: "", // 详细介绍
        lat: "", // 经度
        lon: "" // 纬度
      },
      mapBean: {
        selectedOptions: [],
        address: "",
        region: "广东省惠州市惠阳区"
      },
      addEatRules: {
        name: [
          { required: true, message: "请输入店铺名称", trigger: "blur" },
          { min: 1, max: 7, message: "长度不超过7个字符", trigger: "blur" }
        ],
        logoUrl: [{ required: true, message: "请选择上传的logo图", trigger: "blur" }],
        introduce: [
          { required: true, message: "请输入介绍文案", trigger: "blur" },
          { min: 1, max: 7, message: "长度不超过7个字符", trigger: "blur" }
        ],
        address: [{ required: true, message: "请选择店铺地址", trigger: "blur" }],
        phone: [{ required: true, message: "请输入店铺电话", trigger: "blur" }],
        lat: [{ required: true, message: "请选择地图信息", trigger: "blur" }],
        bannerUrl: [
          { required: true, message: "请选择上传banner图", trigger: "blur" }
        ]
      }
    };
  },
  methods: {
    submitForm(formName) {
      console.log(this.mapBean);
      try {
        this.addEatReq.lat = this.mapBean.address.latLng.lat;
        this.addEatReq.lon = this.mapBean.address.latLng.lng;    
      } catch (error) {  
      }
      
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
      this.$router.push({ path: "/parkMapAdmin/index" });
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
            message: "新增餐饮店铺成功！",
            type: "success"
          });
          this.$router.push({ path: "/parkMapAdmin/index" });
        } else {
          this.$message.error(data.msg + "[错误码：" + _code + "]");
        }
      });
    }
  },
  components: {
    GtMap
  }
};
</script>
<style>
.a-in-stop-head{
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
.a-in-stop-box{
    width:600px;
    padding-left:80px;
}
.a-in-stop-prompt{
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
</style>