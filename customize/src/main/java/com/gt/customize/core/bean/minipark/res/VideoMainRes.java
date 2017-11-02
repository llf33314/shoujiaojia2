package com.gt.customize.core.bean.minipark.res;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by psr on 2017/11/2 0002.
 */
@ApiModel(value = "主视频对象")
public class VideoMainRes {

    @ApiModelProperty(value = "主视频id")
    private Integer id; // 主视频id

    @ApiModelProperty(value = "主视频图片url")
    private String mainImgUrl; // 主视频图片url

    @ApiModelProperty(value = "主视频url")
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
        return "VideoMainRes{" +
                "id=" + id +
                ", mainImgUrl='" + mainImgUrl + '\'' +
                ", mainVideoUrl='" + mainVideoUrl + '\'' +
                '}';
    }
}
