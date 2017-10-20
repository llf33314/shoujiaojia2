<template>
<<<<<<< HEAD
    <div style="overflow: hidden;">
        <div class="a-in-stop-head">
=======
    <div>
        <div>
>>>>>>> ec9f8075d5b7094bb53e40c94e0290ed2868b585
            <el-breadcrumb separator="/">
                <el-breadcrumb-item :to="{ path: '/parkMapAdmin/eatList' }">餐饮管理</el-breadcrumb-item>
                <el-breadcrumb-item>编辑店铺</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div style="margin:0 30px; ">
            <el-form :model="modifyEatReq" :rules="modifyEatRules" ref="modifyEatReq" label-width="130px" class="demo-ruleForm">
<<<<<<< HEAD
                <div class="a-in-stop-title">编辑店铺信息</div>
                <div class="a-in-stop-box">
                    <el-form-item label="店铺名称" prop="name">
                        <el-input v-model="modifyEatReq.name" style="width: 251px!important;"></el-input>
                    </el-form-item>
                    <el-form-item label="LOGO上传" prop="logoUrl">
                        <gt-material prop="logoUrl" :url="modifyEatReq.logoUrl" v-on:getChangeUrl="getChangeUrl"  width="80" height="80"></gt-material>
                        <p class="a-in-stop-prompt">建议上传1:1尺寸图片</p>
                    </el-form-item>
                    <el-form-item label="文案介绍" prop="introduce">
                        <el-input v-model="modifyEatReq.introduce" style="width: 251px!important;"></el-input>
                    </el-form-item>
                    <el-form-item label="店铺地址" prop="address">
                        <el-input v-model="modifyEatReq.address" style="width: 251px!important;"></el-input>
                    </el-form-item>
                    <el-form-item label="店铺电话" prop="phone">
                        <el-input v-model="modifyEatReq.phone" style="width: 251px!important;"></el-input>
                    </el-form-item>
                </div>
                <div class="a-in-stop-title">编辑店铺详情页</div>
                <div class="a-in-stop-box">
                    <el-form-item label="Banner图" prop="bannerUrl">
                        <gt-material prop="bannerUrl" :url="modifyEatReq.bannerUrl" v-on:getChangeUrl="getChangeUrl" width="80" height="80"></gt-material>
                        <p class="a-in-stop-prompt">建议上传360*200尺寸图片</p>
                    </el-form-item>
                    <el-form-item label="店铺介绍" prop="remark">
                        <el-input type="textarea" v-model="modifyEatReq.remark" style="width: 400px!important;" rows="4"></el-input>
                    </el-form-item>
                    <el-form-item style="margin-top: 80px;">
                        <el-button type="primary" @click="submitForm('modifyEatReq')">保存</el-button>
                        <el-button type="primary" @click="resetForm('modifyEatReq')">返回</el-button>
                    </el-form-item>
                </div>
=======
                <div>编辑店铺信息</div>
                <el-form-item label="店铺名称" prop="name">
                    <el-input v-model="modifyEatReq.name"></el-input>
                </el-form-item>
                <el-form-item label="LOGO上传" prop="logoUrl">
                    <gt-material prop="logoUrl" :url="modifyEatReq.logoUrl" v-on:getChangeUrl="getChangeUrl" width="220" height="220"></gt-material>
                    <span>建议上传1:1尺寸图片</span>
                </el-form-item>
                <el-form-item label="文案介绍" prop="introduce">
                    <el-input v-model="modifyEatReq.introduce"></el-input>
                </el-form-item>
                <el-form-item label="店铺地址" prop="address">
                    <el-input v-model="modifyEatReq.address"></el-input>
                </el-form-item>
                <el-form-item label="店铺电话" prop="phone">
                    <el-input v-model="modifyEatReq.phone"></el-input>
                </el-form-item>
                <div>编辑店铺详情页</div>
                <el-form-item label="Banner图" prop="bannerUrl">
                    <gt-material prop="bannerUrl" :url="modifyEatReq.bannerUrl" v-on:getChangeUrl="getChangeUrl" width="220" height="220"></gt-material>
                    <span>建议上传360*200尺寸图片</span>
                </el-form-item>
                <el-form-item label="店铺介绍" prop="remark">
                    <el-input type="textarea" v-model="modifyEatReq.remark"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="submitForm('modifyEatReq')">保存</el-button>
                    <el-button @click="resetForm('modifyEatReq')">返回</el-button>
                </el-form-item>
>>>>>>> ec9f8075d5b7094bb53e40c94e0290ed2868b585
            </el-form>
        </div>
    </div>
</template>
<script>
import { requestModifyEat } from "../api/api"
export default {
    data() {
        return {
            modifyEatReq: {
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
            modifyEatRules: {
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
            console.log(this.modifyEatReq);
            this.$refs[formName].validate((valid) => {
                if (valid) {
                    this.modifyEat();
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
            this.modifyEatReq[e.prop] = e.url;
        },
        modifyEat() {
            console.log("save obj : " + this.modifyEatReq);
            requestModifyEat(this.modifyEatReq).then(data => {
                // console.log(data);
                var _code = data.code;
                if (_code == 100) {
                    this.$message({
                        message: '编辑餐饮店铺成功！',
                        type: 'success'
                    });
                    this.$router.push({ path: '/parkMapAdmin/eatList' });
                } else {
                    this.$message.error(data.msg + "[错误码：" + _code + "]");
                }
            });
        }
    },
    mounted() {
        console.log(this.$route.query);
        this.modifyEatReq = this.$route.query;
    }
}
</script>
<<<<<<< HEAD
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
=======
>>>>>>> ec9f8075d5b7094bb53e40c94e0290ed2868b585
