package com.gt.customize.core.bean.minipark.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * Created by psr on 2017/10/18 0018.
 */
@ApiModel(value = "获取酒店店铺详情（移动端）")
public class MHotelInfoReq {

    @ApiModelProperty(value = "商家id")
    @NotNull(message = "商家id不能为空")
    private Integer busId;

    @NotNull(message = "id不能为空")
    @ApiModelProperty(value = "主键id")
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBusId() {
        return busId;
    }

    public void setBusId(Integer busId) {
        this.busId = busId;
    }

    @Override
    public String toString() {
        return "MHotelInfoReq{" +
                "busId=" + busId +
                ", id=" + id +
                '}';
    }
}
