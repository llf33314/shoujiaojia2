package com.gt.customize.core.bean.minipark.res;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author ps
 * Created by psr on 2017/10/18 0018.
 */
@ApiModel(value = "主视频（移动端）")
public class MVideoMainRes {

    @ApiModelProperty(value = "图片链接")
    private String imgUrl; // 图片链接

    @ApiModelProperty(value = "视频链接")
    private String videoUrl; // 视频链接

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }
}
