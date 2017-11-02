package com.gt.customize.core.bean.minipark.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * Created by psr on 2017/11/2 0002.
 */
@ApiModel(value = "排序请求")
public class SaveSortReq {

    @ApiModelProperty(value = "主键id")
    @NotNull(message = "主键id不能为空")
    private Integer id;

    @ApiModelProperty(value = "排序数字")
    private Integer videoSort = 0;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVideoSort() {
        return videoSort;
    }

    public void setVideoSort(Integer videoSort) {
        this.videoSort = videoSort;
    }

    @Override
    public String toString() {
        return "SaveSortReq{" +
                "id=" + id +
                ", videoSort=" + videoSort +
                '}';
    }
}
