package com.gt.customize.core.bean.minipark.req;

import com.gt.customize.common.base.PageReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by psr on 2017/10/18 0018.
 */
@ApiModel(value = "分页获取餐饮店铺列表（后台）")
public class ListEatReq extends PageReq{

    @Override
    public String toString() {
        return "ListEatReq{" +
                "current=" + current +
                ", size=" + size +
                '}';
    }
}
