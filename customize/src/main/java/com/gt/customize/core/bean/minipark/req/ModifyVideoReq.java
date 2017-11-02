package com.gt.customize.core.bean.minipark.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * Created by psr on 2017/10/18 0018.
 */
@ApiModel(value = "修改视频")
public class ModifyVideoReq {

    @ApiModelProperty(value = "视频ID")
    @NotNull(message = "视频ID不能为空")
    private Integer id;

    /**
     * 视频名称
     */
    @ApiModelProperty(value = "视频名称")
    @NotNull(message = "视频名称不能为空")
    private String videoName;
    /**
     * 视频链接
     */
    @ApiModelProperty(value = "视频链接")
    @NotNull(message = "视频链接不能为空")
    private String videoUrl;
    /**
     * 图片链接
     */
    @ApiModelProperty(value = "图片链接")
    @NotNull(message = "图片链接不能为空")
    private String imgUrl;

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ModifyVideoReq{" +
                "id=" + id +
                ", videoName='" + videoName + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
