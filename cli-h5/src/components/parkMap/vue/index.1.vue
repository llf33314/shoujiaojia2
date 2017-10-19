<template>
  <section>
    <div id="allmap" class="map"></div>
  </section>
</template>
<script>
  export default {
    name: 'index',
    mounted() {
      setTimeout(() => {
        //百度地图API功能
        var map = new BMap.Map('allmap');
        map.centerAndZoom(new BMap.Point(116.6739800000, 23.3559900000), 300);

        map.addControl(new BMap.NavigationControl()); // 添加平移缩放控件
        map.addControl(new BMap.ScaleControl()); // 添加比例尺控件
        map.addControl(new BMap.OverviewMapControl()); //添加缩略地图控件
        map.enableScrollWheelZoom(); //启用滚轮放大缩小
        map.disable3DBuilding();

        //个性化在线编辑器地址：http://developer.baidu.com/map/custom/
        var styleJson = [{
            "featureType": "all",
            "elementType": "geometry",
            "stylers": {
              "hue": "#007fff",
              "saturation": 89
            }
          },
          {
            "featureType": "water",
            "elementType": "all",
            "stylers": {
              "color": "#ffffff"
            }
          }
        ]
        map.setMapStyle({
          styleJson: styleJson
        });
        var map = new BMap.Map("allmap");
        var point = new BMap.Point(116.6739800000, 23.3559900000);
        map.centerAndZoom(point, 300);
        var marker = new BMap.Marker(point); // 创建标注
        map.addOverlay(marker); // 将标注添加到地图中

        var label = new BMap.Label("我是文字标注哦", {
          offset: new BMap.Size(20, -10)
        });
        marker.setLabel(label);
        var marker = new BMap.Marker(point); // 创建标注
        map.addOverlay(marker); // 将标注添加到地图中

        var label = new BMap.Label("我是文字标注哦", {
          offset: new BMap.Size(20, -10)
        });
        marker.setLabel(label);
      }, 200)
    }

  }

</script>
<style>
  .map {
    height: 500px;
    width: 500px;
    border: 1px solid #000000;
  }

</style>
