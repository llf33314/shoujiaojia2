webpackJsonp([5],{15:function(t,n,e){"use strict";e.d(n,"a",function(){return i});var a=e(7),i={getWxSDK:function(t,n){var i=this;e.i(a.a)(t,{shareUrl:window.location.href}).then(function(t){console.log(t),t.code||alert(t.msg,"shareurl"),i.wxReady(t,n)})},LatitudeAndLogitude:null,wxReady:function(t,n){window.wx.config({debug:!1,appId:t.data.appid,timestamp:t.data.timestamp,nonceStr:t.data.nonce_str,signature:t.data.signature,jsApiList:["getLocation","onMenuShareAppMessage","onMenuShareTimeline","WeixinJSBridgeReady"]})},gtToTXMap:function(t){var n="//apis.map.qq.com/uri/v1/routeplan?type=walk&from=我&fromcoord=",e=window.dataPack.logLan;alert(window.location.href=n+e.latitude+","+e.longitude+"&to="+t.name+"&tocoord="+t.coordinate+"&policy=1&referer=myapp"),window.location.href=n+e.latitude+","+e.longitude+"&to="+t.name+"&tocoord="+t.coordinate+"&policy=1&referer=myapp"}}},16:function(t,n){},17:function(t,n){},18:function(t,n,e){"use strict";function a(t){e(42)}var i=e(39),o=e(52),r=e(19),u=a,c=r(i.a,o.a,!1,u,"data-v-8fe319d2",null);n.a=c.exports},39:function(t,n,e){"use strict";var a=e(7);n.a={name:"app",data:function(){return{transitionName:"slide-left",getWxSDKFlag:!0}},watch:{$route:function(t,n){var e=t.path.split("/").length,a=n.path.split("/").length;this.transitionName=e<a?"slide-right":"slide-left",this.getWxSDKFlag&&this.getWxSDK()}},methods:{getWxSDK:function(){var t=this;if(!this.$route.params.busId)return alert("busId为空");e.i(a.a)(this.$route.params.busId,{shareUrl:window.location.href}).then(function(n){if(console.log("请求一次sdk"),100!=n.code)return alert(n.msg);t.getWxSDKFlag=!1,window.wx.config({debug:!1,appId:n.data.appid,timestamp:n.data.timestamp,nonceStr:n.data.nonce_str,signature:n.data.signature,jsApiList:["getLocation","onMenuShareAppMessage","onMenuShareTimeline"]}),window.dataPack.getWXLocation()})}}}},4:function(t,n,e){"use strict";var a=e(21),i=e.n(a),o=e(43),r=(e.n(o),e(5),i.a.create({timeout:1e4}));n.a=r},40:function(t,n,e){"use strict";e.d(n,"a",function(){return u});var a=function(){return e.e(0).then(e.bind(null,58))},i=function(){return e.e(2).then(e.bind(null,59))},o=function(){return e.e(1).then(e.bind(null,57))},r=function(){return e.e(3).then(e.bind(null,60))},u=[{path:"/index/:busId",name:"index",component:a},{path:"/roomAndBorad/:busId/:type",name:"roomAndBorad",component:i},{path:"/detail/:busId/:id/:type",name:"detail",component:o},{path:"/video/:busId",name:"video",component:r}]},41:function(t,n,e){"use strict";Object.defineProperty(n,"__esModule",{value:!0});var a=e(6),i=e(18),o=e(4),r=e(5),u=e(15);e(17),e(16),a.a.prototype.axios=o.a,a.a.prototype._wx=u.a,a.a.config.productionTip=!1,new a.a({el:"#app",router:r.a,axios:o.a,template:"<App/>",components:{App:i.a}})},42:function(t,n){},5:function(t,n,e){"use strict";var a=e(6),i=e(53),o=e(40);a.a.use(i.a);var r=o.a,u=new i.a({routes:r});n.a=u},52:function(t,n,e){"use strict";var a=function(){var t=this,n=t.$createElement,e=t._self._c||n;return e("div",{attrs:{id:"app"}},[e("transition",{attrs:{name:t.transitionName}},[e("router-view",{staticClass:"child-view"})],1)],1)},i=[],o={render:a,staticRenderFns:i};n.a=o},7:function(t,n,e){"use strict";e.d(n,"f",function(){return o}),e.d(n,"g",function(){return r}),e.d(n,"e",function(){return u}),e.d(n,"d",function(){return c}),e.d(n,"a",function(){return s}),e.d(n,"b",function(){return d}),e.d(n,"c",function(){return p});var a=e(4),i=window.MOBILEBASEDOMAIN,o=function(t){return a.a.post(i+"/m/minipark/listHotels",t).then(function(t){return t.data})},r=function(t){return a.a.post(i+"/m/minipark/listEats",t).then(function(t){return t.data})},u=function(t){return a.a.post(i+"/m/minipark/getEat",t).then(function(t){return t.data})},c=function(t){return a.a.post(i+"/m/minipark/getHotel",t).then(function(t){return t.data})},s=function(t,n){return a.a.post(i+"/m/wxPublic/getWxJsSDK/"+t,n).then(function(t){return t.data})},d=function(t){return a.a.post(i+"/m/minipark/getVideoMain/",t).then(function(t){return t.data})},p=function(t){return a.a.post(i+"/m/minipark/listVideos/",t).then(function(t){return t.data})}}},[41]);