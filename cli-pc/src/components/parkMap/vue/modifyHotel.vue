<template>
    <div style="margin:0 20px; ">
        <div class="a-in-stop-head">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item :to="{ path: '/parkMapAdmin/hotelList' }">酒店管理</el-breadcrumb-item>
                <el-breadcrumb-item>编辑店铺</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div>
            <el-form :model="modifyHotelReq" :rules="modifyHotelRules" ref="modifyHotelReq" label-width="130px" class="demo-ruleForm">
                <div class="a-in-stop-title">编辑店铺信息</div>
                <div class="a-in-stop-box">
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
                        <el-input v-model="modifyHotelReq.address" style="width: 251px!important;"></el-input>
                    </el-form-item>
                    <el-form-item label="店铺电话" prop="phone">
                        <el-input v-model="modifyHotelReq.phone" style="width: 251px!important;"></el-input>
                    </el-form-item>
                </div>
                <div class="a-in-stop-title">编辑店铺详情页</div>
                <div class="a-in-stop-box">
                    <el-form-item label="Banner图" prop="bannerUrl">
                        <gt-material prop="bannerUrl" :url="modifyHotelReq.bannerUrl" v-on:getChangeUrl="getChangeUrl" width="80" height="80"></gt-material>
                        <p class="a-in-stop-prompt">建议上传360*200尺寸图片</p>
                    </el-form-item>
                    <el-form-item label="店铺介绍" prop="remark">
                        <el-input type="textarea" v-model="modifyHotelReq.remark" style="width: 400px!important;" rows="4"></el-input>
                    </el-form-item>
                    <el-form-item>
                        <el-button type="primary" @click="submitForm('modifyHotelReq')">保存</el-button>
                        <el-button  type="primary"@click="resetForm('modifyHotelReq')">返回</el-button>
                    </el-form-item>
                </div>
            </el-form>
        </div>
    </div>
</template>
<script>
import { requestModifyHotel } from "../api/api"
export default {
    data() {
        return {
            modifyHotelReq: {
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
            modifyHotelRules: {
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
            console.log(this.modifyHotelReq);
            this.$refs[formName].validate((valid) => {
                if (valid) {
                    this.modifyHotel();
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
            this.modifyHotelReq[e.prop] = e.url;
        },
        modifyHotel() {
            console.log("save obj : " + this.modifyHotelReq);
            requestModifyHotel(this.modifyHotelReq).then(data => {
                // console.log(data);
                var _code = data.code;
                if (_code == 100) {
                    this.$message({
                        message: '编辑酒店店铺成功！',
                        type: 'success'
                    });
                    this.$router.push({ path: '/parkMapAdmin/hotelList' });
                } else {
                    this.$message.error(data.msg + "[错误码：" + _code + "]");
                }
            });
        }
    },
    mounted() {
        console.log(this.$route.query);
        this.modifyHotelReq = this.$route.query;
    }
}
</script>
<style>
.a-in-stop-head{
    display: inline-block;
    line-height: 53px;
    font-size: 16px;
    padding: 25px 0;
}
.a-in-stop-title{
    width: 749px;
    height: 40px;
    background-color: rgba(242, 242, 242, 1);
    font-size: 14px;
    line-height: 40px;
    padding-left: 40px;
    margin: 0 0 25px;
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
</style>