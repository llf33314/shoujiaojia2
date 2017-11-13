# 多粉项目-应用类-前端脚手架

#### 一、项目打开路径： 域名/#/项目名/index 例如：localhost:8080/#/welcome/index

#### 二、目录结构
```$xslt
├─build
├─config
├─src
│  ├─assets
|  |  ├─js
|  |  |  ├─util.js  // 项目公共的函数方法       
│  ├─components
│  │  ├─Dome      // 项目一: 演示dome 
│  │  │  ├─css   
│  │  │  ├─img   
│  │  │  ├─js 
│  │  │  ├─api    // 该项目下的所有请求方法
│  │  │  │  └─index.js  
│  │  │  └─vue    
│  │  │  │  └─index.vue   // 默认加载该路由
│  │  │  └─router.js    // 统一打包配置演示dome项目下的路由
│  │  ├─PublicVue  // 公共vue
│  │  │  ├─button
│  │  │  └─null-data
│  │  └─ErrorState   // 页面错误提示如：404
│  │  └─AdvancedReservation   // 高级预约
│  │  └─PersonalCenter   // 个人中心
│  │  └─Welcome          // 欢迎页 
│  │  └─EvaluationSystem   // 评价系统
│  │  └─PermissonView   // 权限查看
│  │  └─ScanCodeSignIn   // 扫码签到 
│  │  ├─Notice          // 公告栏
│  │  └─MicroTicket    // 微购票 
│  │  └─MicroMessage    // 微留言 
│  │  └─MicroSignIn    // 微签到
│  │  └─MicroCommunity   // 微社区
│  │  └─MicroVoting    // 微投票
│  │  └─MicroField     // 微外勤
│  │  └─MicroDownload     // 微下载
│  │  └─MicroAlbum    // 微相册
│  │  └─MiscroReservation   // 微预约 
│  │  └─ArticleComment   // 文章评论 
│  │  └─ShakePerimeter   // 摇一摇周边 
│  │  └─PreferentialPay   // 优惠买单 
│  │  └─OnlineRegistration   // 在线报名

│  ├─http
│  │   └─index.js    // 统一初始化各个项目的axios请求方法
│  └─router
│  │   └─index.js    // 加载各个项目的路由
└─static   // 公共资源目录
│   ├─css
│   ├─imgs
│   └─js
│       └─lib    // 项目引入的插件
│         └─jquery-2.2.2.min.js
├─index.html  // 项目入口
│
│

```
#### 访问菜单
```
- http://localhost:8099/index.html
```
#### 四、具体方法可以参考以下：
> 访问路径: http://localhost:8080/#/dome/child1/0
```$xslt
├─build
├─config
├─src
│  ├─assets
│  ├─components
│  │  ├─Dome    // 演示项目
│  │  │  ├─css 
│  │  │  ├─img
│  │  │  ├─js
│  │  │  └─vue
│  │  │  ├─api   
│  │  │  │  └─index.js 
│  │  │  └─router.js
```