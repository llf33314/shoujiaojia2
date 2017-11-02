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
 * 定制-小公园主视频
 * </p>
 *
 * @author psr
 * @since 2017-11-02
 */
@Data
@Accessors(chain = true)
@TableName("t_customize_minipark_video_main")
public class CustomizeMiniparkVideoMain extends Model<CustomizeMiniparkVideoMain> {

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
     * 主视频名称
     */
	private String mainVideoName;
    /**
     * 主视频链接
     */
	private String mainVideoUrl;
    /**
     * 主视频图片链接
     */
	private String mainImgUrl;
    /**
     * 创建时间
     */
	private Date createTime;
    /**
     * 删除标识（0：正常，1：删除）
     */
	private Integer deleteFlag;


	@Override
	protected Serializable pkVal() {
		return this.id;
	}

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

	public String getMainVideoName() {
		return mainVideoName;
	}

	public void setMainVideoName(String mainVideoName) {
		this.mainVideoName = mainVideoName;
	}

	public String getMainVideoUrl() {
		return mainVideoUrl;
	}

	public void setMainVideoUrl(String mainVideoUrl) {
		this.mainVideoUrl = mainVideoUrl;
	}

	public String getMainImgUrl() {
		return mainImgUrl;
	}

	public void setMainImgUrl(String mainImgUrl) {
		this.mainImgUrl = mainImgUrl;
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
}
