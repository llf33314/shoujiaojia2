package com.gt.customize.core.bean.minipark.req;

import com.gt.customize.common.base.PageReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * Created by psr on 2017/10/18 0018.
 */
@ApiModel(value = "分页获取酒店店铺列表（移动端）")
public class MListHotelReq extends PageReq{

    @ApiModelProperty(value = "商家id")
    @NotNull(message = "商家id不能为空")
    private Integer busId;

    @ApiModelProperty(value = "经度")
    private String lon; // 经度

    @ApiModelProperty(value = "纬度")
    private String lat; // 纬度

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public Integer getBusId() {
        return busId;
    }

    public void setBusId(Integer busId) {
        this.busId = busId;
    }

    @Override
    public String toString() {
        return "MListHotelReq{" +
                "current=" + current +
                ", busId=" + busId +
                ", lon='" + lon + '\'' +
                ", lat='" + lat + '\'' +
                ", size=" + size +
                '}';
    }
}
