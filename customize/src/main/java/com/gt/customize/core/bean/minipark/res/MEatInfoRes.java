package com.gt.customize.core.bean.minipark.res;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by psr on 2017/10/18 0018.
 */
@ApiModel(value = "餐饮店铺详情（移动端）")
public class MEatInfoRes {

    @ApiModelProperty(value = "店铺名称")
    private String name; // 店铺名称

    @ApiModelProperty(value = "店铺地址")
    private String address; // 地址

    @ApiModelProperty(value = "店铺电话")
    private String phone; // 电话

    @ApiModelProperty(value = "店铺介绍")
    private String remark; // 店铺介绍

    @ApiModelProperty(value = "banner图链接")
    private String bannerUrl; // banner图链接

    @ApiModelProperty(value = "经度")
    private String lon; // 经度

    @ApiModelProperty(value = "纬度")
    private String lat; // 纬度

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

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

    @Override
    public String toString() {
        return "MEatInfoRes{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", remark='" + remark + '\'' +
                ", bannerUrl='" + bannerUrl + '\'' +
                ", lon='" + lon + '\'' +
                ", lat='" + lat + '\'' +
                '}';
    }
}
