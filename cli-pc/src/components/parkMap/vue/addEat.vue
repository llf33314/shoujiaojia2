<template>
    <div>
        <div>
            <el-breadcrumb separator="/">
                <el-breadcrumb-item :to="{ path: '/parkMapAdmin/eatList' }">餐饮管理</el-breadcrumb-item>
                <el-breadcrumb-item>新增店铺</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div>
            <el-form :model="addEatReq" :rules="addEatRules" ref="addEatReq" label-width="130px" class="demo-ruleForm">
                <div>编辑店铺信息</div>
                <el-form-item label="店铺名称" prop="name">
                    <el-input v-model="addEatReq.name"></el-input>
                </el-form-item>
                <el-form-item label="LOGO上传" prop="logoUrl">
                    <gt-material prop="logoUrl" :url="addEatReq.logoUrl" v-on:getChangeUrl="getChangeUrl" width="220" height="220"></gt-material>
                    <span>建议上传1:1尺寸图片</span>
                </el-form-item>
                <el-form-item label="文案介绍" prop="introduce">
                    <el-input v-model="addEatReq.introduce"></el-input>
                </el-form-item>
                <el-form-item label="店铺地址" prop="address">
                    <el-input v-model="addEatReq.address"></el-input>
                </el-form-item>

                <!--
                    selectedOptions 地址的省份selectedOptions= ["130000", "130200", "130203"]
                    detailedAddress:详细地址信息
                    region 地址的省份 region='广东省惠州市惠阳区',
                -->
                <gt-map :selectedOptions="mapBean.selectedOptions" :detailedAddress.sync="mapBean.address" :region='mapBean.region'></gt-map>
                {{mapBean.address}}
                <el-form-item label="店铺电话" prop="phone">
                    <el-input v-model="addEatReq.phone"></el-input>
                </el-form-item>
                <div>编辑店铺详情页</div>
                <el-form-item label="Banner图" prop="bannerUrl">
                    <gt-material prop="bannerUrl" :url="addEatReq.bannerUrl" v-on:getChangeUrl="getChangeUrl" width="220" height="220"></gt-material>
                    <span>建议上传360*200尺寸图片</span>
                </el-form-item>
                <el-form-item label="店铺介绍" prop="remark">
                    <el-input type="textarea" v-model="addEatReq.remark"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="submitForm('addEatReq')">保存</el-button>
                    <el-button @click="resetForm('addEatReq')">返回</el-button>
                </el-form-item>
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
