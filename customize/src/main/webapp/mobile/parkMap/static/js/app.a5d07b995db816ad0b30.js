webpackJsonp([5],{14:function(t,n,e){"use strict";e.d(n,"a",function(){return o});var i=e(19),o={getWxSDK:function(t,n){var a=this;console.log(o),console.log(window.wx),e.i(i.g)(t,{shareUrl:window.location.href}).then(function(t){console.log(t),t.code||alert(t.msg),a.wxReady(t,n)})},wxReady:function(t,n){console.log(t,"this.$route.params.busI"),window.wx.config({debug:!0,appId:t.data.appid,timestamp:t.data.timestamp,nonceStr:t.data.nonce_str,signature:t.data.signature,jsApiList:["getLocation","onMenuShareTimeline"]}),window.wx.ready(function(){window.wx.getLocation({type:"wgs84",success:function(t){alert(window.JSON.stringify(t),"微信获取地理位置"),sessionStoreage.setItem("parkMapLatitudeAndLogitude",window.JSON.stringify({latitude:t.latitude,longitude:t.longitude}))}}),window.wx.onMenuShareTimeline({title:n.title||"",link:n.link||"",imgUrl:n.imgUrl||"",success:function(){},cancel:function(){}})}),window.wx.error(function(t){alert("config信息验证失败")})},gtToTXMap:function(t){console.log(t,"to");if(window.localStorage.parkMapLatitudeAndLogitude)var n=window.JSON.parse(window.localStorage.parkMapLatitudeAndLogitude);else var n={latitude:"",longitude:""};window.location.href="//apis.map.qq.com/uri/v1/routeplan?type=walk&from=我&fromcoord="+n.latitude+","+n.longitude+"&to="+t.name+"&tocoord="+t.coordinate+"&policy=1&referer=myapp"}}},15:function(t,n){},16:function(t,n){},17:function(t,n,e){"use strict";function i(t){e(42)}var o=e(39),a=e(52),r=e(18),u=i,c=r(o.a,a.a,!1,u,"data-v-2bfdd1bb",null);n.a=c.exports},19:function(t,n,e){"use strict";e.d(n,"e",function(){return a}),e.d(n,"f",function(){return r}),e.d(n,"d",function(){return u}),e.d(n,"c",function(){return c}),e.d(n,"g",function(){return d}),e.d(n,"a",function(){return s}),e.d(n,"b",function(){return p});var i=e(4),o=window.MOBILEBASEDOMAIN,a=function(t){return i.a.post(o+"/m/minipark/listHotels",t).then(function(t){return t.data})},r=function(t){return i.a.post(o+"/m/minipark/listEats",t).then(function(t){return t.data})},u=function(t){return i.a.post(o+"/m/minipark/getEat",t).then(function(t){return t.data})},c=function(t){return i.a.post(o+"/m/minipark/getHotel",t).then(function(t){return t.data})},d=function(t,n){return i.a.post(o+"/m/wxPublic/getWxJsSDK/"+t,n).then(function(t){return t.data})},s=function(t){return i.a.post(o+"/m/minipark/getVideoMain/",t).then(function(t){return t.data})},p=function(t){return i.a.post(o+"/m/minipark/listVideos/",t).then(function(t){return t.data})}},39:function(t,n,e){"use strict";n.a={name:"app",data:function(){return{transitionName:"slide-left"}},watch:{$route:function(t,n){var e=t.path.split("/").length,i=n.path.split("/").length;this.transitionName=e<i?"slide-right":"slide-left"}}}},4:function(t,n,e){"use strict";var i=e(21),o=e.n(i),a=e(43),r=(e.n(a),e(5),o.a.create({timeout:1e4}));n.a=r},40:function(t,n,e){"use strict";e.d(n,"a",function(){return u});var i=function(){return e.e(0).then(e.bind(null,58))},o=function(){return e.e(2).then(e.bind(null,59))},a=function(){return e.e(1).then(e.bind(null,57))},r=function(){return e.e(3).then(e.bind(null,60))},u=[{path:"/parkMap/index/:busId",name:"index",component:i},{path:"/parkMap/roomAndBorad/:busId/:type",name:"roomAndBorad",component:o},{path:"/parkMap/detail/:busId/:id/:type",name:"detail",component:a},{path:"/parkMap/video/:busId",name:"video",component:r}]},41:function(t,n,e){"use strict";Object.defineProperty(n,"__esModule",{value:!0});var i=e(6),o=e(17),a=e(4),r=e(5),u=e(14);e(16),e(15),i.a.prototype.axios=a.a,i.a.prototype._wx=u.a,i.a.config.productionTip=!1,new i.a({el:"#app",router:r.a,axios:a.a,template:"<App/>",components:{App:o.a}})},42:function(t,n){},5:function(t,n,e){"use strict";var i=e(6),o=e(53),a=e(40);i.a.use(o.a);var r=a.a,u=new o.a({routes:r});n.a=u},52:function(t,n,e){"use strict";var i=function(){var t=this,n=t.$createElement,e=t._self._c||n;return e("div",{attrs:{id:"app"}},[e("transition",{attrs:{name:t.transitionName}},[e("router-view",{staticClass:"child-view"})],1)],1)},o=[],a={render:i,staticRenderFns:o};n.a=a}},[41]);
//# sourceMappingURL=app.a5d07b995db816ad0b30.js.map