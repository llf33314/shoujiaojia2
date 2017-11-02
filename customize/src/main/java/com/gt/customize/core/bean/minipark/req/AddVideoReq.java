package com.gt.customize.core.bean.minipark.req;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by psr on 2017/10/18 0018.
 */
@ApiModel(value = "新增视频")
public class AddVideoReq {

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

    @Override
    public String toString() {
        return "AddVideoReq{" +
                "videoName='" + videoName + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
