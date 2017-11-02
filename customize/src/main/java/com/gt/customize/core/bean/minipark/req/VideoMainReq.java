package com.gt.customize.core.bean.minipark.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * Created by psr on 2017/11/2 0002.
 */
@ApiModel(value = "主视频对象")
public class VideoMainReq {

    @ApiModelProperty(value = "主视频id")
    private Integer id; // 主视频id

    @ApiModelProperty(value = "主视频图片url")
    @NotNull(message = "主视频图片url不能为空")
    private String mainImgUrl; // 主视频图片url

    @ApiModelProperty(value = "主视频url")
    @NotNull(message = "主视频url不能为空")
    private String mainVideoUrl; // 主视频url

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMainImgUrl() {
        return mainImgUrl;
    }

    public void setMainImgUrl(String mainImgUrl) {
        this.mainImgUrl = mainImgUrl;
    }

    public String getMainVideoUrl() {
        return mainVideoUrl;
    }

    public void setMainVideoUrl(String mainVideoUrl) {
        this.mainVideoUrl = mainVideoUrl;
    }

    @Override
    public String toString() {
        return "VideoMainReq{" +
                "id=" + id +
                ", mainImgUrl='" + mainImgUrl + '\'' +
                ", mainVideoUrl='" + mainVideoUrl + '\'' +
                '}';
    }
}
