webpackJsonp([8],{129:function(t,e,n){"use strict";function i(t){n(245)}Object.defineProperty(e,"__esModule",{value:!0});var r=n(247),a=n(248),o=n(36),d=i,u=o(r.a,a.a,!1,d,null,null);e.default=u.exports},152:function(t,e,n){"use strict";n.d(e,"i",function(){return a}),n.d(e,"a",function(){return o}),n.d(e,"l",function(){return d}),n.d(e,"e",function(){return u}),n.d(e,"j",function(){return p}),n.d(e,"b",function(){return s}),n.d(e,"m",function(){return c}),n.d(e,"f",function(){return l}),n.d(e,"k",function(){return m}),n.d(e,"g",function(){return f}),n.d(e,"d",function(){return g}),n.d(e,"o",function(){return v}),n.d(e,"h",function(){return h}),n.d(e,"c",function(){return k}),n.d(e,"n",function(){return b});var i=n(37),r=window.PCBASEDOMAIN,a=function(t){return i.a.post(r+"/app/minipark/listEats",t).then(function(t){return t.data})},o=function(t){return i.a.post(r+"/app/minipark/addEat",t).then(function(t){return t.data})},d=function(t){return i.a.post(r+"/app/minipark/modifyEat",t).then(function(t){return t.data})},u=function(t){return i.a.post(r+"/app/minipark/delEat",t).then(function(t){return t.data})},p=function(t){return i.a.post(r+"/app/minipark/listHotels",t).then(function(t){return t.data})},s=function(t){return i.a.post(r+"/app/minipark/addHotel",t).then(function(t){return t.data})},c=function(t){return i.a.post(r+"/app/minipark/modifyHotel",t).then(function(t){return t.data})},l=function(t){return i.a.post(r+"/app/minipark/delHotel",t).then(function(t){return t.data})},m=function(t){return i.a.post(r+"/app/minipark/listVideos",t).then(function(t){return t.data})},f=function(t){return i.a.post(r+"/app/minipark/delVideo",t).then(function(t){return t.data})},g=function(t){return i.a.post(r+"/app/minipark/addVideo",t).then(function(t){return t.data})},v=function(t){return i.a.post(r+"/app/minipark/modifyVideo",t).then(function(t){return t.data})},h=function(t){return i.a.post(r+"/app/minipark/getMainVideo",t).then(function(t){return t.data})},k=function(t){return i.a.post(r+"/app/minipark/addOrModifyMainVideo",t).then(function(t){return t.data})},b=function(t){return i.a.post(r+"/app/minipark/modifySort",t).then(function(t){return t.data})}},245:function(t,e,n){var i=n(246);"string"==typeof i&&(i=[[t.i,i,""]]),i.locals&&(t.exports=i.locals);n(120)("2a76e84a",i,!0)},246:function(t,e,n){e=t.exports=n(119)(!0),e.push([t.i,".parkmap-addvideo .a-in-stop-prompt{display:inline-block;font-size:13px;color:#666;margin-left:10px}.parkmap-addvideo .public-content{padding-top:30px}","",{version:3,sources:["g:/GtProject/gt_customize_general/cli-pc/src/components/parkMap/vue/addVideo.vue"],names:[],mappings:"AACA,oCACE,qBAAsB,AACtB,eAAgB,AAChB,WAAY,AACZ,gBAAkB,CACnB,AACD,kCACE,gBAAkB,CACnB",file:"addVideo.vue",sourcesContent:["\n.parkmap-addvideo .a-in-stop-prompt {\n  display: inline-block;\n  font-size: 13px;\n  color: #666;\n  margin-left: 10px;\n}\n.parkmap-addvideo .public-content {\n  padding-top: 30px;\n}\n"],sourceRoot:""}])},247:function(t,e,n){"use strict";var i=n(152);e.a={data:function(){return{loading:{state:!1,text:"保存"},addVideoReq:{videoName:"",imgUrl:"",videoUrl:""},addVideoRules:{videoName:[{required:!0,message:"请填写视频名称",trigger:"blur"}],imgUrl:[{required:!0,message:"请上传封面图",trigger:"blur"}],videoUrl:[{required:!0,message:"请设置直播链接",trigger:"blur"}]}}},methods:{submitForm:function(t){var e=this;console.log(this.addVideoReq),this.$refs[t].validate(function(t){if(!t)return!1;e.addVide()})},resetForm:function(t){this.$refs[t].resetFields(),this.$router.push({path:"/parkMapAdmin/index",query:{manage:"videoList"}})},getChangeUrl:function(t){this.addVideoReq[t.prop]=t.url},addVide:function(){var t=this;this.loading={state:!0,text:"保存中"},Object(i.d)(this.addVideoReq).then(function(e){var n=e.code;100==n?(t.$message({message:"新增视频成功！",type:"success"}),t.$router.push({path:"/parkMapAdmin/index",query:{manage:"videoList"}})):t.$message.error(e.msg+"[错误码："+n+"]"),t.loading={state:!1,text:"保存"}})}}}},248:function(t,e,n){"use strict";var i=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"parkmap-addvideo",staticStyle:{overflow:"hidden"}},[n("el-breadcrumb",{staticClass:"public-crumbs",attrs:{separator:"/"}},[n("el-breadcrumb-item",{attrs:{to:{path:"/parkMapAdmin/index",query:{manage:"videoList"}}}},[t._v("直播视频管理")]),t._v(" "),n("el-breadcrumb-item",[t._v("新建视频")])],1),t._v(" "),n("div",{staticClass:"public-content"},[n("el-form",{ref:"addVideoReq",staticClass:"demo-ruleForm",attrs:{model:t.addVideoReq,rules:t.addVideoRules,"label-width":"130px"}},[n("el-form-item",{attrs:{label:"视频名称：",prop:"videoName"}},[n("el-input",{staticStyle:{width:"251px!important"},model:{value:t.addVideoReq.videoName,callback:function(e){t.$set(t.addVideoReq,"videoName",e)},expression:"addVideoReq.videoName"}})],1),t._v(" "),n("el-form-item",{attrs:{label:"封面图：",prop:"imgUrl"}},[n("gt-material",{attrs:{prop:"imgUrl",url:t.addVideoReq.imgUrl,width:"80",height:"80"},on:{getChangeUrl:t.getChangeUrl}}),t._v(" "),n("p",{staticClass:"a-in-stop-prompt"},[t._v("建议上传1:1尺寸图片")])],1),t._v(" "),n("el-form-item",{attrs:{label:"直播链接：",prop:"videoUrl"}},[n("el-input",{staticStyle:{width:"251px!important"},model:{value:t.addVideoReq.videoUrl,callback:function(e){t.$set(t.addVideoReq,"videoUrl",e)},expression:"addVideoReq.videoUrl"}})],1),t._v(" "),n("el-form-item",{staticStyle:{"margin-top":"80px"}},[n("el-button",{attrs:{type:"primary",loading:t.loading.state},domProps:{textContent:t._s(t.loading.text)},on:{click:function(e){t.submitForm("addVideoReq")}}}),t._v(" "),n("el-button",{attrs:{type:"primary"},on:{click:function(e){t.resetForm("addVideoReq")}}},[t._v("返回")])],1)],1)],1)],1)},r=[],a={render:i,staticRenderFns:r};e.a=a}});
//# sourceMappingURL=8.4b4640e672865ebaeb4d.js.map