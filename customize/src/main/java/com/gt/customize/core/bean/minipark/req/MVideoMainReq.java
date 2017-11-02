package com.gt.customize.core.bean.minipark.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * Created by psr on 2017/10/18 0018.
 */
@ApiModel(value = "获取主视频（移动端）")
public class MVideoMainReq {

    @ApiModelProperty(value = "商家id")
    @NotNull(message = "商家id不能为空")
    private Integer busId;

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
                '}';
    }
}
