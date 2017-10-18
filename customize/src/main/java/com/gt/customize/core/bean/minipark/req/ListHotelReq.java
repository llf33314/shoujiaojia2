package com.gt.customize.core.bean.minipark.req;

import com.gt.customize.common.base.PageReq;
import io.swagger.annotations.ApiModel;

/**
 * Created by psr on 2017/10/18 0018.
 */
@ApiModel(value = "分页获取酒店店铺列表（后台）")
public class ListHotelReq extends PageReq{

    @Override
    public String toString() {
        return "ListHotelReq{" +
                "current=" + current +
                ", size=" + size +
                '}';
    }
}
