package com.gt.customize.core.bean.minipark.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * Created by psr on 2017/10/18 0018.
 */
@ApiModel(value = "编辑餐饮店铺")
public class ModifyEatReq {

    @NotNull(message = "id不能为空")
    @ApiModelProperty(value = "主键id")
    private Integer id;

    @NotNull(message = "店铺名称不能为空")
    @ApiModelProperty(value = "店铺名称")
    private String name; // 店铺名称

    @NotNull(message = "logo链接不能为空")
    @ApiModelProperty(value = "logo链接")
    private String logoUrl; // logo链接

    @NotNull(message = "简介不能为空")
    @ApiModelProperty(value = "简介")
    private String introduce; // 简介

    @NotNull(message = "店铺地址不能为空")
    @ApiModelProperty(value = "店铺地址")
    private String address; // 店铺地址

    @NotNull(message = "经度不能为空")
    @ApiModelProperty(value = "经度")
    private String lon; // 经度

    @NotNull(message = "纬度不能为空")
    @ApiModelProperty(value = "纬度")
    private String lat; // 纬度

    @NotNull(message = "店铺电话不能为空")
    @ApiModelProperty(value = "店铺电话")
    private String phone; // 店铺电话

    @NotNull(message = "banner图链接不能为空")
    @ApiModelProperty(value = "banner图链接")
    private String bannerUrl; // banner图链接

    @ApiModelProperty(value = "店铺介绍[非必填]")
    private String remark; // 店铺介绍

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ModifyEatReq{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", logoUrl='" + logoUrl + '\'' +
                ", introduce='" + introduce + '\'' +
                ", address='" + address + '\'' +
                ", lon='" + lon + '\'' +
                ", lat='" + lat + '\'' +
                ", phone='" + phone + '\'' +
                ", bannerUrl='" + bannerUrl + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
