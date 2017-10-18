package com.gt.customize.core.bean.minipark.req;

import com.gt.customize.common.base.PageReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * Created by psr on 2017/10/18 0018.
 */
@ApiModel(value = "获取餐饮店铺详情（移动端）")
public class MEatInfoReq {

    @NotNull(message = "id不能为空")
    @ApiModelProperty(value = "主键id")
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MEatInfoReq{" +
                "id=" + id +
                '}';
    }
}
