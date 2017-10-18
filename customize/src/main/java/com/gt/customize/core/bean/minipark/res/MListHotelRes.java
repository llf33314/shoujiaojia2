package com.gt.customize.core.bean.minipark.res;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by psr on 2017/10/18 0018.
 */
@ApiModel(value = "获取酒店店铺列表（移动端）")
public class MListHotelRes {

    @ApiModelProperty(value = "主键id")
    private Integer id; // 主键id

    @ApiModelProperty(value = "logo链接")
    private String logoUrl; // logo链接

    @ApiModelProperty(value = "店铺名称")
    private String name; // 店铺名称

    @ApiModelProperty(value = "简介")
    private String introduce; // 简介

    @ApiModelProperty(value = "店铺地址")
    private String address; // 地址

    @ApiModelProperty(value = "店铺电话")
    private String phone; // 电话

    @ApiModelProperty(value = "距离（单位米）")
    private Double distance; // 距离（单位米）

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    @Override
    public String toString() {
        return "MListEatRes{" +
                "id=" + id +
                ", logoUrl='" + logoUrl + '\'' +
                ", name='" + name + '\'' +
                ", introduce='" + introduce + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", distance=" + distance +
                '}';
    }
}
