<template>
    <div>
        <el-form-item label="地址导航：">
            <gt-region-choose :selectedOptions="selectedOptions" v-model="selectedOptions" @change="regionChange"></gt-region-choose>
            <el-input v-model="addressinput" placeholder="请点击选择地址" @focus="openDialog"></el-input>
        </el-form-item>
        <el-dialog title="选择地址" :visible.sync="dialogVisible" top="20%" :close-on-click-modal="false" class="largeDialog">
            <div class="map">
                <el-input v-model="input" placeholder="搜索地点" icon="search" size="small" @blur="searchKeyword" @keydown.enter.native="searchKeyword"></el-input>
                <div id="container"></div>
                <el-radio-group v-model="radio" @change="changefn()">
                    <el-radio :label="index" class="clearfix" :key="index" v-for="(item,index) in Address">
                        <strong>{{item.name}}</strong>
                        <p>{{item.address}}</p>
                    </el-radio>
                </el-radio-group>
            </div>
            <span slot="footer" class="dialog-footer">
                <el-button type="primary" @click="Determine">确 定</el-button>
                <el-button @click="dialogVisible = false">取 消</el-button>
            </span>
        </el-dialog>
    </div>
</template>
<script type='text/ecmascript-6'>
import { TMap } from './TMap'
export default {
    data() {
        return {
            input: '', //弹框的输入框
            radio: 0,   //弹框的单选框
            Address: [],    //地图
            LatLngx: 39.916527,//地图
            LatLngy: 116.397128,//地图
            markers: '',//地图
            searchService: null,//地图
            pois: [],//地图数据
            map: "",//地图
            dialogVisible: false,//弹框
            // detailedAddress: '',//选中的地址
            addressinput: ''
        }
    },
    mounted() {
    },
    methods: {
        //    选择省份地区
        regionChange(e) {
            let _this = this;
            _this.region = '';
            _this.addressinput = '';
            this.input = '';
            this.pois = [];
            _this.selectedOptions = e.value
            e.name.forEach(function(item) {
                _this.region += item
            }, this);
        },
        //    打开弹窗加根据省份初始化地图
        openDialog() {
            if (this.selectedOptions.length == 0) {
                this.$message.error('请选择省市区');
                return false;
            }
            this.dialogVisible = true
            var _this = this;
            this.pois = [];
            TMap('M3KBZ-QUMKU-YJQVE-2OETC-N7TJ5-VLBJW').then(qq => {
                var init = function() {
                    var center = new qq.maps.LatLng(_this.LatLngx, _this.LatLngy);
                    _this.map = new qq.maps.Map(document.getElementById('container'), {
                        center: center,
                        zoom: 13
                    });
                    //设置Poi检索服务，用于本地检索、周边检索
                    _this.searchService = new qq.maps.SearchService({
                        //检索成功的回调函数
                        complete: function(results) {
                            //将单选框数据变空
                            _this.pois = [];
                            //去除掉公交站
                            let originalPois = results.detail.pois;
                            originalPois.forEach(function(element) {
                                if (element.name) {
                                    if (element.name.slice(element.name.length - 5) != '[公交站]') {
                                        _this.pois.push(element);
                                    }
                                } else {
                                    _this.pois.push(element)
                                }
                            }, this);
                            if (!_this.pois) {
                                return false
                            }
                            _this.Address = _this.pois
                            var infoWin = new qq.maps.InfoWindow({
                                map: _this.map
                            });
                            var latlngBounds = new qq.maps.LatLngBounds();
                            //扩展边界范围，用来包含搜索到的Poi点
                            latlngBounds.extend(_this.pois[0].latLng);
                            _this.detailedAddress = _this.pois[0]
                            // //清除覆盖层
                            function clearOverlays() {
                                if (_this.markers) {
                                    _this.markers.setMap(null)
                                }
                            }
                            clearOverlays()
                            _this.markers = new qq.maps.Marker({
                                position: _this.pois[0].latLng,
                                map: _this.map
                            });
                            //调整地图视野
                            _this.map.fitBounds(latlngBounds);

                        },
                        //若服务请求失败，则运行以下函数
                        error: function(err) {
                            _this.$message.error('地址有误 请重新打开弹窗');
                        }
                    });
                    //清除地图上的marker
                    //清除覆盖层
                    function clearOverlays() {
                        if (_this.markers) {
                            _this.markers.setMap(null)
                        }
                    }
                    clearOverlays()
                    //根据输入的城市设置搜索范围
                    _this.searchService.setLocation(_this.region);
                    //设置搜索页码
                    // _this.searchService.setPageIndex(5);
                    //设置每页的结果数
                    _this.searchService.setPageCapacity(10);
                    //根据输入的关键字在搜索范围内检索
                    _this.searchService.search(_this.region);
                }
                init()
            });
        },
        //根据输入框值搜索地图
        searchKeyword() {
            var _this = this;
            //清除地图上的marker
            //清除覆盖层
            function clearOverlays() {
                if (_this.markers) {
                    _this.markers.setMap(null)
                }
            }
            clearOverlays()
            //根据输入的城市设置搜索范围
            _this.searchService.setLocation(_this.region);
            //设置搜索页码
            // _this.searchService.setPageIndex(5);
            //设置每页的结果数
            // _this.searchService.setPageCapacity(10);
            //根据输入的关键字在搜索范围内检索
            _this.searchService.search(_this.input);
            //根据输入的关键字在圆形范围内检索
            //var region = new qq.maps.LatLng(39.916527,116.397128);
            //searchService.searchNearBy(keyword, region , 2000);
            //根据输入的关键字在矩形范围内检索
            //region = new qq.maps.LatLngBounds(new qq.maps.LatLng(39.936273,116.440043),new qq.maps.LatLng(39.896775,116.354212));
            //searchService.searchInBounds(keyword, region);
        },
        //根据单选框值改变 地图蓝点也改变
        changefn() {
            var _this = this;
            this.detailedAddress = this.pois[_this.radio]
            //清除覆盖层
            function clearOverlays() {
                if (_this.markers) {
                    _this.markers.setMap(null)
                }
            }
            clearOverlays()
            var latlngBounds = new qq.maps.LatLngBounds();
            //扩展边界范围，用来包含搜索到的Poi点
            latlngBounds.extend(_this.pois[_this.radio].latLng);
            _this.markers = new qq.maps.Marker({
                position: _this.pois[_this.radio].latLng,
                // animation: qq.maps.MarkerAnimation.DROP,
                map: _this.map
            });
            //调整地图视野
            _this.map.fitBounds(latlngBounds);
        },
        Determine() {
            // this.addressinput= this.detailedAddress.name .address
            if (this.detailedAddress.address) {
                this.addressinput = this.detailedAddress.address
            } else {
                this.addressinput = this.detailedAddress.name
            }
            this.$emit('update:detailedAddress', this.detailedAddress);
            this.dialogVisible = false
        }
    },
    props: ['selectedOptions', 'region', 'detailedAddress'],//省份名字和地址
}
</script>

<style lang='less' rel='stylesheet/less'>
#container {
    width: 100%;
    height: 280px;
}

.largeDialog {
    .el-dialog {
        width: 900px;
    }
}

.map {
    .el-input {
        width: 280px;
        margin-bottom: 20px;
    }
    .el-radio-group {
        display: block;
        margin-top: 10px;
        height: 146px;
        overflow-x: hidden;
        .el-radio {
            display: block;
            border-bottom: 1px solid #dfe6ec;
            margin: 0;
            padding: 10px 30px 10px 0;
        }
        .el-radio__input {
            float: right;
            margin-top: 17px;
        }
        .el-radio__label {
            float: left;
        }
        strong {
            font-size: 14px;
            color: #333333;
            font-weight: normal;
            line-height: 26px;
        }
        p {
            font-size: 14px;
            color: #999999;
            line-height: 26px;
        }
    }
}

//设置弹窗框的滚动条
.largeDialog .el-dialog ::-webkit-scrollbar {
    width: 4px;
    height: 4px;
    background-color: #eef1f6;
}

.largeDialog .el-dialog ::-webkit-scrollbar-track-piece {
    background-color: #fff;
}

.largeDialog .el-dialog ::-webkit-scrollbar-thumb:vertical {
    border: 1px solid #eef1f6;
    background-color: #eef1f6; // border-radius: 5px;
}

.largeDialog .el-dialog ::-webkit-scrollbar-thumb:horizontal {
    border: 1px solid #eef1f6;
    background-color: #eef1f6; // border-radius: 4px;
}

.largeDialog .el-dialog ::-webkit-scrollbar-thumb:hover {
    background-color: #eef1f6; // border-radius: 4px;
}
</style>
