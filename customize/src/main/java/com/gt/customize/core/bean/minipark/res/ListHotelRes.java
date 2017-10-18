package com.gt.customize.core.bean.minipark.res;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * Created by psr on 2017/10/18 0018.
 */
@ApiModel(value = "获取酒店店铺列表（后台）")
public class ListHotelRes {

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

    @Override
    public String toString() {
        return "ListEatRes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
