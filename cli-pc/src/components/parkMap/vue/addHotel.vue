<template>
    <div>
        <div>
            <el-breadcrumb separator="/">
                <el-breadcrumb-item :to="{ path: '/parkMapAdmin/hotelList' }">酒店管理</el-breadcrumb-item>
                <el-breadcrumb-item>新增店铺</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div>
            <el-form :model="addHotelReq" :rules="addHotelRules" ref="addHotelReq" label-width="130px" class="demo-ruleForm">
                <div>编辑店铺信息</div>
                <el-form-item label="店铺名称" prop="name">
                    <el-input v-model="addHotelReq.name"></el-input>
                </el-form-item>
                <el-form-item label="LOGO上传" prop="logoUrl">
                    <gt-material prop="logoUrl" :url="addHotelReq.logoUrl" v-on:getChangeUrl="getChangeUrl" width="220" height="220"></gt-material>
                    <span>建议上传1:1尺寸图片</span>
                </el-form-item>
                <el-form-item label="文案介绍" prop="introduce">
                    <el-input v-model="addHotelReq.introduce"></el-input>
                </el-form-item>
                <el-form-item label="店铺地址" prop="address">
                    <el-input v-model="addHotelReq.address"></el-input>
                </el-form-item>
                <el-form-item label="店铺电话" prop="phone">
                    <el-input v-model="addHotelReq.phone"></el-input>
                </el-form-item>
                <div>编辑店铺详情页</div>
                <el-form-item label="Banner图" prop="bannerUrl">
                    <gt-material prop="bannerUrl" :url="addHotelReq.bannerUrl" v-on:getChangeUrl="getChangeUrl" width="220" height="220"></gt-material>
                    <span>建议上传360*200尺寸图片</span>
                </el-form-item>
                <el-form-item label="店铺介绍" prop="remark">
                    <el-input type="textarea" v-model="addHotelReq.remark"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="submitForm('addHotelReq')">保存</el-button>
                    <el-button @click="resetForm('addHotelReq')">返回</el-button>
                </el-form-item>
            </el-form>
        </div>
    </div>
</template>
<script>
import { requestAddHotel } from "../api/api"
export default {
    data() {
        return {
            addHotelReq: {
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
            addHotelRules: {
                name: [
                    { required: true, message: '请输入店铺名称', trigger: 'blur' },
                    { min: 1, max: 7, message: '长度不超过7个字符', trigger: 'blur' }
                ],
                logoUrl: [
                    { required: true, message: '请选择上传的logo图', trigger: 'blur' }
                ],
                introduce: [
                    { required: true, message: '请输入介绍文案', trigger: 'blur' },
                    { min: 1, max: 7, message: '长度不超过7个字符', trigger: 'blur' }
                ],
                address: [
                    { required: true, message: '请选择店铺地址', trigger: 'blur' }
                ],
                phone: [
                    { required: true, message: '请输入店铺电话', trigger: 'blur' }
                ],
                bannerUrl: [
                    { required: true, message: '请选择上传banner图', trigger: 'blur' }
                ]
            }
        };
    },
    methods: {
        submitForm(formName) {
            console.log(this.addHotelReq);
            this.$refs[formName].validate((valid) => {
                if (valid) {
                    this.addHotel();
                } else {
                    return false;
                }
            });
        },
        resetForm(formName) {
            this.$refs[formName].resetFields();
            this.$router.push({ path: '/parkMapAdmin/index' });
        },
        getChangeUrl(e) {
            // 获取素材库的图片url
            this.addHotelReq[e.prop] = e.url;
        },
        addHotel() {
            requestAddHotel(this.addHotelReq).then(data => {
                // console.log(data);
                var _code = data.code;
                if (_code == 100) {
                    this.$message({
                        message: '新增餐饮店铺成功！',
                        type: 'success'
                    });
                    this.$router.push({ path: '/parkMapAdmin/index' });
                } else {
                    this.$message.error(data.msg + "[错误码：" + _code + "]");
                }
            });
        }
    }
}
</script>
