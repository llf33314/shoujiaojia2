webpackJsonp([14],{134:function(e,A,t){"use strict";function i(e){t(275)}Object.defineProperty(A,"__esModule",{value:!0});var a=t(277),n=t(278),o=t(36),r=i,s=o(a.a,n.a,!1,r,null,null);A.default=s.exports},275:function(e,A,t){var i=t(276);"string"==typeof i&&(i=[[e.i,i,""]]),i.locals&&(e.exports=i.locals);t(119)("6ffb9eda",i,!0)},276:function(e,A,t){A=e.exports=t(118)(!0),A.push([e.i,".gt_audio{display:inline-block}.audioDisabled{position:absolute;width:300px;height:36px;background:#fff;opacity:0;filter:alpha(opacity=0);z-index:5}.audioPlayer{width:300px;height:36px;border:1px solid #dfe6ec;border-radius:5px;-webkit-box-sizing:border-box;box-sizing:border-box;display:-webkit-box;display:-ms-flexbox;display:flex;-webkit-box-align:center;-ms-flex-align:center;align-items:center;-webkit-box-pack:center;-ms-flex-pack:center;justify-content:center;margin:10px 0;user-select:none;-webkit-user-select:none;-moz-user-select:none;-ms-user-select:none}.audioPlayer .audioButton{-webkit-box-flex:1;-ms-flex:1;flex:1;display:inline-block;text-align:center}.audioPlayer .audioButton>img{width:24px;vertical-align:middle}.audioPlayer .audioProgressBar{-webkit-box-flex:5;-ms-flex:5;flex:5;display:inline-block;height:100%}.audioProgress{width:95%;height:3px;background-color:#999;border-radius:1px;text-align:right;float:right;margin-top:15px}.audioPlayer .audioProgressBar .audioSpeed{width:0;height:3px;background-color:#2ba5ff}.audioPlayer .audioProgressBar .audioIconDiv{position:absolute}.audioPlayer .audioProgressBar .audioIcon{width:26px;position:relative;left:0;top:5px}.audioPlayer .audioTime{-webkit-box-flex:1.3;-ms-flex:1.3;flex:1.3;display:inline-block;text-align:center;vertical-align:middle;color:#999;font-size:15px}","",{version:3,sources:["g:/GtProject/gt_customize_general/cli-pc/src/components/PublicVue/GtAudio/GtAudio.vue"],names:[],mappings:"AACA,UACI,oBAAsB,CACzB,AACD,eACI,kBAAmB,AACnB,YAAa,AACb,YAAa,AACb,gBAAiB,AACjB,UAAW,AACX,wBAAyB,AACzB,SAAW,CACd,AACD,aACI,YAAa,AACb,YAAa,AACb,yBAA0B,AAC1B,kBAAmB,AACnB,8BAA+B,AACvB,sBAAuB,AAC/B,oBAAqB,AACrB,oBAAqB,AACrB,aAAc,AACd,yBAA0B,AACtB,sBAAuB,AACnB,mBAAoB,AAC5B,wBAAyB,AACrB,qBAAsB,AAClB,uBAAwB,AAChC,cAAe,AACf,iBAAkB,AAClB,yBAA0B,AAC1B,sBAAuB,AACvB,oBAAsB,CACzB,AACD,0BACI,mBAAoB,AAChB,WAAY,AACR,OAAQ,AAChB,qBAAsB,AACtB,iBAAmB,CACtB,AACD,8BACI,WAAY,AACZ,qBAAuB,CAC1B,AACD,+BACI,mBAAoB,AAChB,WAAY,AACR,OAAQ,AAChB,qBAAsB,AACtB,WAAa,CAChB,AACD,eACI,UAAW,AACX,WAAY,AACZ,sBAAuB,AACvB,kBAAmB,AACnB,iBAAkB,AAClB,YAAa,AACb,eAAiB,CACpB,AACD,2CACI,QAAU,AACV,WAAY,AACZ,wBAA0B,CAC7B,AACD,6CACE,iBAAmB,CACpB,AACD,0CACI,WAAY,AACZ,kBAAmB,AACnB,OAAU,AACV,OAAS,CACZ,AACD,wBACI,qBAAsB,AAClB,aAAc,AACV,SAAU,AAClB,qBAAsB,AACtB,kBAAmB,AACnB,sBAAuB,AACvB,WAAY,AACZ,cAAgB,CACnB",file:"GtAudio.vue",sourcesContent:["\n.gt_audio{\r\n    display: inline-block;\n}\n.audioDisabled {\r\n    position: absolute;\r\n    width: 300px;\r\n    height: 36px;\r\n    background: #fff;\r\n    opacity: 0;\r\n    filter: alpha(opacity=0);\r\n    z-index: 5;\n}\n.audioPlayer {\r\n    width: 300px;\r\n    height: 36px;\r\n    border: 1px solid #dfe6ec;\r\n    border-radius: 5px;\r\n    -webkit-box-sizing: border-box;\r\n            box-sizing: border-box;\r\n    display: -webkit-box;\r\n    display: -ms-flexbox;\r\n    display: flex;\r\n    -webkit-box-align: center;\r\n        -ms-flex-align: center;\r\n            align-items: center;\r\n    -webkit-box-pack: center;\r\n        -ms-flex-pack: center;\r\n            justify-content: center;\r\n    margin: 10px 0;\r\n    user-select: none;\r\n    -webkit-user-select: none;\r\n    -moz-user-select: none;\r\n    -ms-user-select: none;\n}\n.audioPlayer .audioButton {\r\n    -webkit-box-flex: 1;\r\n        -ms-flex: 1;\r\n            flex: 1;\r\n    display: inline-block;\r\n    text-align: center;\n}\n.audioPlayer .audioButton>img {\r\n    width: 24px;\r\n    vertical-align: middle;\n}\n.audioPlayer .audioProgressBar {\r\n    -webkit-box-flex: 5;\r\n        -ms-flex: 5;\r\n            flex: 5;\r\n    display: inline-block;\r\n    height: 100%;\n}\n.audioProgress {\r\n    width: 95%;\r\n    height: 3px;\r\n    background-color: #999;\r\n    border-radius: 1px;\r\n    text-align: right;\r\n    float: right;\r\n    margin-top: 15px;\n}\n.audioPlayer .audioProgressBar .audioSpeed {\r\n    width: 0%;\r\n    height: 3px;\r\n    background-color: #2ba5ff;\n}\n.audioPlayer .audioProgressBar .audioIconDiv {\r\n  position: absolute;\n}\n.audioPlayer .audioProgressBar .audioIcon {\r\n    width: 26px;\r\n    position: relative;\r\n    left: 0px;\r\n    top: 5px;\n}\n.audioPlayer .audioTime {\r\n    -webkit-box-flex: 1.3;\r\n        -ms-flex: 1.3;\r\n            flex: 1.3;\r\n    display: inline-block;\r\n    text-align: center;\r\n    vertical-align: middle;\r\n    color: #999;\r\n    font-size: 15px;\n}\r\n"],sourceRoot:""}])},277:function(e,A,t){"use strict";function i(e){var A=parseInt(e/60);A<10&&(A="0"+A);var t=parseInt(e%60);return t<10&&(t="0"+t),A+":"+t}var a;A.a={props:{src:String},data:function(){return{audioSrc:null}},mounted:function(){this.audioSrc=this.src},methods:{play:function(e){var A=e.target,t=A.parentNode,n=t.getElementsByClassName("audioProgressBar")[0].offsetWidth;A.setAttribute("data-play","true"),a=setInterval(function(){t.getElementsByClassName("audioTime")[0].innerHTML=i(A.currentTime),t.getElementsByClassName("audioIcon")[0].style.left=A.currentTime/A.duration*(n-20)+"px",t.getElementsByClassName("audioSpeed")[0].style.width=A.currentTime/A.duration*(n-10)+"px"},500)},pause:function(e){e.target.setAttribute("data-play","false"),window.clearInterval(a)},ended:function(e){var A=e.target,t=A.parentNode;A.setAttribute("data-play","false"),A.pause(),A.currentTime=0,t.parentNode.getElementsByClassName("audioButton")[0].getElementsByTagName("img")[0].setAttribute("src","data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAABW0lEQVRYR+2WwU3DMBiF328GYI6KZbiCixRPQLpBskG6AZWAc9ggbNAe0vQYNmgPzSFV/aNSaKBSieM6CQd8jv2+PL3324SeF/Wsj78PMHjma6Fxz4SkKDHOFS1dulbrwNUT7wQvP0QZSy2gsluKXUGYAPCxGANxUUK5cMMK4OAGIcgkjc9xwx7gS5WRbC+gFjeU24CcD/CpykAwlxQ2hXAGsM8oplpjtLijxBTEKcBBlBGtNwhNQtoOwN6NnAmjusq2BlBl9PfKtg5QV9luAKqmPMwlqe8B7RRgJ5xK+qHZLQBjkg7J68OBlWYE2ZCi4/nQugMMvGgB/9SobhNgpQleP3OAMVlv4Hc+CRl40xpeL3cBA2FRIjL5a7ctYMxA8FJJU9Mb0BXAyWo1AbFtwetWwLN9BTV1oHoVA0bVcurA4JF9QQjAiE2r5RSgyWE239ZmwObQJnv+Ad4Byr7EIY/gRmUAAAAASUVORK5CYII="),t.parentNode.getElementsByClassName("audioTime")[0].innerHTML="00:00",t.parentNode.getElementsByClassName("audioIcon")[0].style.left="0px",t.parentNode.getElementsByClassName("audioSpeed")[0].style.width="0px"},audioPlay:function(e){for(var A=e.target.parentNode.previousSibling,t=document.getElementsByTagName("audio"),i=0;i<t.length;i++)e.target.setAttribute("src","data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAABW0lEQVRYR+2WwU3DMBiF328GYI6KZbiCixRPQLpBskG6AZWAc9ggbNAe0vQYNmgPzSFV/aNSaKBSieM6CQd8jv2+PL3324SeF/Wsj78PMHjma6Fxz4SkKDHOFS1dulbrwNUT7wQvP0QZSy2gsluKXUGYAPCxGANxUUK5cMMK4OAGIcgkjc9xwx7gS5WRbC+gFjeU24CcD/CpykAwlxQ2hXAGsM8oplpjtLijxBTEKcBBlBGtNwhNQtoOwN6NnAmjusq2BlBl9PfKtg5QV9luAKqmPMwlqe8B7RRgJ5xK+qHZLQBjkg7J68OBlWYE2ZCi4/nQugMMvGgB/9SobhNgpQleP3OAMVlv4Hc+CRl40xpeL3cBA2FRIjL5a7ctYMxA8FJJU9Mb0BXAyWo1AbFtwetWwLN9BTV1oHoVA0bVcurA4JF9QQjAiE2r5RSgyWE239ZmwObQJnv+Ad4Byr7EIY/gRmUAAAAASUVORK5CYII="),t[i].pause();"true"!=A.getAttribute("data-play")&&(e.target.setAttribute("src","data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAAAjUlEQVRYR2NkGGDAOMD2M4w6gKgQ0Fj834GBmeE/KLqY/zN8vBrNeAFb1Gkv/W/wl5GBHyZ3I4rxIKEoJsoB2kv/gy2HgoNXoxkdcDjgAAMDgz1M7mo0I0HzCSoAGTbqgNEQGA2B0RAYDYHREBgNgdEQGA2B0RAY8BAg1LSmRJ6oVjElFhDSO+qAAQ8BAPnb0iFyumREAAAAAElFTkSuQmCC"),A.play())},audioThrough:function(e){e.target.parentNode.getElementsByClassName("audioDisabled")[0].style.display="none"},audioSkip:function(e){var A=event||window.event,t=e.target.parentNode.parentNode.parentNode.getElementsByTagName("audio")[0],a=e.target.offsetWidth,n=A.offsetX-t.parentNode.getElementsByClassName("audioIcon")[0].offsetWidth/2,o=(n/a+.05).toFixed(2);o>0&&(t.parentNode.getElementsByClassName("audioIcon")[0].style.left=n+"px",t.parentNode.getElementsByClassName("audioSpeed")[0].style.width=A.offsetX-3+"px",t.parentNode.getElementsByClassName("audioTime")[0].innerHTML=i(t.duration*o),t.currentTime=t.duration*o)}}}},278:function(e,A,t){"use strict";var i=function(){var e=this,A=e.$createElement,t=e._self._c||A;return t("div",{staticClass:"gt_audio"},[t("div",{staticClass:"audioPlayer"},[t("div",{staticClass:"audioDisabled"}),e._v(" "),t("audio",{attrs:{src:e.audioSrc},on:{play:function(A){e.play(A)},pause:function(A){e.pause(A)},ended:function(A){e.ended(A)},canplaythrough:function(A){e.audioThrough(A)}}}),t("div",{staticClass:"audioButton"},[t("img",{attrs:{src:"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAABW0lEQVRYR+2WwU3DMBiF328GYI6KZbiCixRPQLpBskG6AZWAc9ggbNAe0vQYNmgPzSFV/aNSaKBSieM6CQd8jv2+PL3324SeF/Wsj78PMHjma6Fxz4SkKDHOFS1dulbrwNUT7wQvP0QZSy2gsluKXUGYAPCxGANxUUK5cMMK4OAGIcgkjc9xwx7gS5WRbC+gFjeU24CcD/CpykAwlxQ2hXAGsM8oplpjtLijxBTEKcBBlBGtNwhNQtoOwN6NnAmjusq2BlBl9PfKtg5QV9luAKqmPMwlqe8B7RRgJ5xK+qHZLQBjkg7J68OBlWYE2ZCi4/nQugMMvGgB/9SobhNgpQleP3OAMVlv4Hc+CRl40xpeL3cBA2FRIjL5a7ctYMxA8FJJU9Mb0BXAyWo1AbFtwetWwLN9BTV1oHoVA0bVcurA4JF9QQjAiE2r5RSgyWE239ZmwObQJnv+Ad4Byr7EIY/gRmUAAAAASUVORK5CYII="},on:{click:function(A){e.audioPlay(A)}}})]),t("section",{staticClass:"audioProgressBar",on:{click:function(A){e.audioSkip(A)}}},[e._m(0),e._m(1)]),t("div",{staticClass:"audioTime"},[e._v("00:00")])])])},a=[function(){var e=this,A=e.$createElement,t=e._self._c||A;return t("div",{staticClass:"audioProgress"},[t("div",{staticClass:"audioSpeed"})])},function(){var e=this,A=e.$createElement,t=e._self._c||A;return t("div",{staticClass:"audioIconDiv"},[t("img",{staticClass:"audioIcon",attrs:{src:"data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABoAAAAaCAYAAACpSkzOAAACyElEQVRIib2Wz2sTQRTHP7v50aapuoI/KGpBRCoIBUNBqZBLz+lBFA85eezFozm09CL0oP4BXtNjD0LB9uDJ2JOHNiDYoqXQxdaGkkMMTbPJTnY9ZEYnMYnbRnww7OTHvM9833vzdgyCmdH2VOZ3mXd18DfnBmBqc925D3javCewE8QEwsDA9PT0Gdu2U5VK5XW9Xn/vum7ecZx35XL5xebmZhKIAVH5f7WhQJCQXBizbfuREGLH72H1ev3j+vr6PQmMBIEpyAAQL5VKL33f93pBlHmeV9nd3U0DQ3KToW4wXcnw/v7+syCANhNbW1sPNFhHZaaUHV9eXp7wPM89BcgXQhQymcyoFsYWkFIzCFilUunNaSDK9vb2ngPnZApaQqjUDKdSqVHP8477ATmO8wW4AMTbVZlKTS6Xe9wPRNnMzMwYcFblytRCZwJhy7Ku9SrLoDY5OTkqw2YChn7aTcAUQpg91gc213VNDYSuCMAoFAqH/wK0srJySIeKiwDDwOVEIjHeaDSq/eSnUqnsADeAizTPVEgpUo3Q39jYOC4UCrl+1Gxvb7/ld6MFmjFUqkI0m2IkEol8m5qaemgYxonzVavViul0eta27R+AA7gSCmjlDVwFbq+trb06acg8z2ssLi4+BW4BI2jlrYOiNPN0iWZ87+Tz+awfsKkKIapLS0uzwDhwnS4HtqUFAVeAMWAim81mjo6OvveCFIvFz3Nzc0+ABHBTqmlpQXr5qbqPSuCQ3FHcsqz4wsLC3WQyed+yrJFYLHbecZzywcHB19XV1Q/z8/OfgCpQkeNY5kfI4esgowNskGYXjsnd6S81H2gAdaAmHVflaIEAflgDqXc/slKQjoR0Fu0CcjVYTc6F/O3XHaLTG1BXFpLOw9pTP3uetnNXm7dAuoHU9zpQB+trPDkacqjPf9yG/tt1K9C1qA2qW+AL5E9dShbfB+cqswAAAABJRU5ErkJggg=="}})])}],n={render:i,staticRenderFns:a};A.a=n}});
//# sourceMappingURL=14.48c2bd3db30e3aaa4968.js.map