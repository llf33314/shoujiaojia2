package com.gt.customize.core.bean.minipark.res;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * Created by psr on 2017/10/18 0018.
 */
@ApiModel(value = "获取餐饮店铺列表（后台）")
public class ListEatRes {

    @ApiModelProperty(value = "主键id")
    private Integer id; // 主键id

    @ApiModelProperty(value = "店铺名称")
    private String name; // 店铺名称

    @ApiModelProperty(value = "店铺地址")
    private String address; // 地址

    @ApiModelProperty(value = "店铺电话")
    private String phone; // 电话

    @ApiModelProperty(value = "创建时间")
    private Date createTime; // 创建时间

    // ------ 编辑的信息
    @ApiModelProperty(value = "logo链接")
    private String logoUrl; // logo链接

    @ApiModelProperty(value = "简介")
    private String introduce; // 简介

    @ApiModelProperty(value = "经度")
    private String lon; // 经度

    @ApiModelProperty(value = "纬度")
    private String lat; // 纬度

    @ApiModelProperty(value = "banner图链接")
    private String bannerUrl; // banner图链接

    @ApiModelProperty(value = "店铺介绍")
    private String remark; // 店铺介绍


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    @Override
    public String toString() {
        return "ListEatRes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", createTime=" + createTime +
                ", logoUrl='" + logoUrl + '\'' +
                ", introduce='" + introduce + '\'' +
                ", lon='" + lon + '\'' +
                ", lat='" + lat + '\'' +
                ", bannerUrl='" + bannerUrl + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
