webpackJsonp([6],{129:function(t,e,n){function i(t){n(250)}var o=n(36)(n(252),n(253),i,null,null);t.exports=o.exports},151:function(t,e,n){"use strict";n.d(e,"i",function(){return r}),n.d(e,"a",function(){return a}),n.d(e,"l",function(){return d}),n.d(e,"e",function(){return p}),n.d(e,"j",function(){return s}),n.d(e,"b",function(){return u}),n.d(e,"m",function(){return l}),n.d(e,"f",function(){return c}),n.d(e,"k",function(){return f}),n.d(e,"g",function(){return m}),n.d(e,"d",function(){return A}),n.d(e,"o",function(){return h}),n.d(e,"h",function(){return g}),n.d(e,"c",function(){return x}),n.d(e,"n",function(){return v});var i=n(37),o=window.PCBASEDOMAIN,r=function(t){return i.a.post(o+"/app/minipark/listEats",t).then(function(t){return t.data})},a=function(t){return i.a.post(o+"/app/minipark/addEat",t).then(function(t){return t.data})},d=function(t){return i.a.post(o+"/app/minipark/modifyEat",t).then(function(t){return t.data})},p=function(t){return i.a.post(o+"/app/minipark/delEat",t).then(function(t){return t.data})},s=function(t){return i.a.post(o+"/app/minipark/listHotels",t).then(function(t){return t.data})},u=function(t){return i.a.post(o+"/app/minipark/addHotel",t).then(function(t){return t.data})},l=function(t){return i.a.post(o+"/app/minipark/modifyHotel",t).then(function(t){return t.data})},c=function(t){return i.a.post(o+"/app/minipark/delHotel",t).then(function(t){return t.data})},f=function(t){return i.a.post(o+"/app/minipark/listVideos",t).then(function(t){return t.data})},m=function(t){return i.a.post(o+"/app/minipark/delVideo",t).then(function(t){return t.data})},A=function(t){return i.a.post(o+"/app/minipark/addVideo",t).then(function(t){return t.data})},h=function(t){return i.a.post(o+"/app/minipark/modifyVideo",t).then(function(t){return t.data})},g=function(t){return i.a.post(o+"/app/minipark/getMainVideo",t).then(function(t){return t.data})},x=function(t){return i.a.post(o+"/app/minipark/addOrModifyMainVideo",t).then(function(t){return t.data})},v=function(t){return i.a.post(o+"/app/minipark/modifySort",t).then(function(t){return t.data})}},250:function(t,e,n){var i=n(251);"string"==typeof i&&(i=[[t.i,i,""]]),i.locals&&(t.exports=i.locals);n(119)("4c69920d",i,!0)},251:function(t,e,n){e=t.exports=n(118)(!0),e.push([t.i,".a-in-stop-head{display:inline-block;padding:30px 0 0 29px;font-size:16px;width:100%;height:51px;background-color:#f8f8f8}.a-in-stop-title{width:749px;height:60px;font-size:14px;line-height:60px;margin:2px 0 35px;color:#666;border-bottom:1px solid #ddd}.a-in-stop-box{width:600px;padding-left:80px}.a-in-stop-prompt{display:inline-block;position:absolute;top:25px;left:100px;color:#999;font-size:12px}.el-form-item{margin-bottom:26px}.el-textarea__inner{height:150px}","",{version:3,sources:["g:/GtProject/gt_customize_general/cli-pc/src/components/parkMap/vue/modifyVideo.vue"],names:[],mappings:"AACA,gBACE,qBAAsB,AACtB,sBAAuB,AACvB,eAAgB,AAChB,WAAY,AACZ,YAAa,AACb,wBAAyC,CAC1C,AACD,iBACE,YAAa,AACb,YAAa,AACb,eAAgB,AAChB,iBAAkB,AAClB,kBAAmB,AACnB,WAAY,AACZ,4BAA8B,CAC/B,AACD,eACE,YAAa,AACb,iBAAmB,CACpB,AACD,kBACE,qBAAsB,AACtB,kBAAmB,AACnB,SAAU,AACV,WAAY,AACZ,WAAY,AACZ,cAAgB,CACjB,AACD,cACE,kBAAoB,CACrB,AACD,oBACE,YAAc,CACf",file:"modifyVideo.vue",sourcesContent:["\n.a-in-stop-head {\r\n  display: inline-block;\r\n  padding: 30px 0 0 29px;\r\n  font-size: 16px;\r\n  width: 100%;\r\n  height: 51px;\r\n  background-color: rgba(248, 248, 248, 1);\n}\n.a-in-stop-title {\r\n  width: 749px;\r\n  height: 60px;\r\n  font-size: 14px;\r\n  line-height: 60px;\r\n  margin: 2px 0 35px;\r\n  color: #666;\r\n  border-bottom: 1px solid #ddd;\n}\n.a-in-stop-box {\r\n  width: 600px;\r\n  padding-left: 80px;\n}\n.a-in-stop-prompt {\r\n  display: inline-block;\r\n  position: absolute;\r\n  top: 25px;\r\n  left: 100px;\r\n  color: #999;\r\n  font-size: 12px;\n}\n.el-form-item {\r\n  margin-bottom: 26px;\n}\n.el-textarea__inner {\r\n  height: 150px;\n}\r\n"],sourceRoot:""}])},252:function(t,e,n){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var i=n(151);e.default={data:function(){return{modifyVideoReq:{videoName:"",imgUrl:"",videoUrl:""},modifyVideoRules:{videoName:[{required:!0,message:"请填写视频名称",trigger:"blur"}],imgUrl:[{required:!0,message:"请上传封面图",trigger:"blur"}],videoUrl:[{required:!0,message:"请设置直播链接",trigger:"blur"}]}}},methods:{submitForm:function(t){var e=this;console.log(this.modifyVideoReq),this.$refs[t].validate(function(t){if(!t)return!1;e.modifyVideo()})},resetForm:function(t){this.$refs[t].resetFields(),this.$router.push({path:"/parkMapAdmin/index",query:{manage:"videoList"}})},getChangeUrl:function(t){this.modifyVideoReq[t.prop]=t.url},modifyVideo:function(){var t=this;console.log("save obj : ",this.modifyVideoReq),Object(i.o)(this.modifyVideoReq).then(function(e){var n=e.code;100==n?(t.$message({message:"编辑视频成功！",type:"success"}),t.$router.push({path:"/parkMapAdmin/index",query:{manage:"videoList"}})):t.$message.error(e.msg+"[错误码："+n+"]")})}},created:function(){console.log(this.$route.query),this.modifyVideoReq=this.$route.query}}},253:function(t,e){t.exports={render:function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticStyle:{overflow:"hidden"}},[n("div",{staticClass:"a-in-stop-head"},[n("el-breadcrumb",{attrs:{separator:"/"}},[n("el-breadcrumb-item",{attrs:{to:{path:"/parkMapAdmin/index",query:{manage:"videoList"}}}},[t._v("直播视频管理")]),t._v(" "),n("el-breadcrumb-item",[t._v("编辑视频")])],1)],1),t._v(" "),n("div",{staticStyle:{margin:"0 30px"}},[n("el-form",{ref:"modifyVideoReq",staticClass:"demo-ruleForm",attrs:{model:t.modifyVideoReq,rules:t.modifyVideoRules,"label-width":"130px"}},[n("div",{staticClass:"a-in-stop-title"},[t._v("编辑直播视频")]),t._v(" "),n("div",{staticClass:"a-in-stop-box"},[n("el-form-item",{attrs:{label:"视频名称",prop:"videoName"}},[n("el-input",{staticStyle:{width:"251px!important"},model:{value:t.modifyVideoReq.videoName,callback:function(e){t.$set(t.modifyVideoReq,"videoName",e)},expression:"modifyVideoReq.videoName"}})],1),t._v(" "),n("el-form-item",{attrs:{label:"封面图上传",prop:"imgUrl"}},[n("gt-material",{attrs:{prop:"logoUrl",url:t.modifyVideoReq.imgUrl,width:"80",height:"80"},on:{getChangeUrl:t.getChangeUrl}}),t._v(" "),n("p",{staticClass:"a-in-stop-prompt"},[t._v("建议上传1:1尺寸图片")])],1),t._v(" "),n("el-form-item",{attrs:{label:"直播链接：",prop:"videoUrl"}},[n("el-input",{staticStyle:{width:"251px!important"},model:{value:t.modifyVideoReq.videoUrl,callback:function(e){t.$set(t.modifyVideoReq,"videoUrl",e)},expression:"modifyVideoReq.videoUrl"}})],1)],1),t._v(" "),n("div",{staticClass:"a-in-stop-box"},[n("el-form-item",{staticStyle:{"margin-top":"80px"}},[n("el-button",{attrs:{type:"primary"},on:{click:function(e){t.submitForm("modifyVideoReq")}}},[t._v("保存")]),t._v(" "),n("el-button",{attrs:{type:"primary"},on:{click:function(e){t.resetForm("modifyVideoReq")}}},[t._v("返回")])],1)],1)])],1)])},staticRenderFns:[]}}});
//# sourceMappingURL=6.8934f0516c80cb72b8ea.js.map