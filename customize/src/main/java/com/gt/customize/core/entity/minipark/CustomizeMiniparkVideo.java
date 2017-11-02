package com.gt.customize.core.entity.minipark;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 定制-小公园视频表
 * </p>
 *
 * @author psr
 * @since 2017-11-02
 */
@Data
@Accessors(chain = true)
@TableName("t_customize_minipark_video")
public class CustomizeMiniparkVideo extends Model<CustomizeMiniparkVideo> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 商家ID
     */
	private Integer busId;
    /**
     * 视频名称
     */
	private String videoName;
    /**
     * 视频链接
     */
	private String videoUrl;
    /**
     * 图片链接
     */
	private String imgUrl;
    /**
     * 排序
     */
	private Integer videoSort;
    /**
     * 创建时间
     */
	private Date createTime;
    /**
     * 删除状态（0：正常，1：删除）
     */
	private Integer deleteFlag;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBusId() {
		return busId;
	}

	public void setBusId(Integer busId) {
		this.busId = busId;
	}

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

	public Integer getVideoSort() {
		return videoSort;
	}

	public void setVideoSort(Integer videoSort) {
		this.videoSort = videoSort;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
