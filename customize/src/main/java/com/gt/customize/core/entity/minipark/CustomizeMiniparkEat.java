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
 * 多粉定制开发-小公园餐饮表
 * </p>
 *
 * @author psr
 * @since 2017-10-18
 */
@Data
@Accessors(chain = true)
@TableName("t_customize_minipark_eat")
public class CustomizeMiniparkEat extends Model<CustomizeMiniparkEat> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * 商家id
     */
	private Integer busId;
    /**
     * 店铺名称
     */
	private String shopName;
    /**
     * logo图片
     */
	private String shopLogoUrl;
    /**
     * 简介
     */
	private String shopIntroduce;
    /**
     * 店铺地址
     */
	private String shopAdd;
    /**
     * 店铺经度
     */
	private String shopLon;
    /**
     * 店铺纬度
     */
	private String shopLat;
    /**
     * 店铺电话
     */
	private String shopPhone;
    /**
     * 店铺banner图片
     */
	private String shopBannerUrl;
    /**
     * 店铺详情
     */
	private String shopRemark;
    /**
     * 店铺状态（0：正常，1：停用）
     */
	private Integer shopStatus;
    /**
     * 创建时间
     */
	private Date createTime;
    /**
     * 删除标识（0：正常，1：删除）
     */
	private Integer deleteflag;


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

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopLogoUrl() {
		return shopLogoUrl;
	}

	public void setShopLogoUrl(String shopLogoUrl) {
		this.shopLogoUrl = shopLogoUrl;
	}

	public String getShopIntroduce() {
		return shopIntroduce;
	}

	public void setShopIntroduce(String shopIntroduce) {
		this.shopIntroduce = shopIntroduce;
	}

	public String getShopAdd() {
		return shopAdd;
	}

	public void setShopAdd(String shopAdd) {
		this.shopAdd = shopAdd;
	}

	public String getShopLon() {
		return shopLon;
	}

	public void setShopLon(String shopLon) {
		this.shopLon = shopLon;
	}

	public String getShopLat() {
		return shopLat;
	}

	public void setShopLat(String shopLat) {
		this.shopLat = shopLat;
	}

	public String getShopPhone() {
		return shopPhone;
	}

	public void setShopPhone(String shopPhone) {
		this.shopPhone = shopPhone;
	}

	public String getShopBannerUrl() {
		return shopBannerUrl;
	}

	public void setShopBannerUrl(String shopBannerUrl) {
		this.shopBannerUrl = shopBannerUrl;
	}

	public String getShopRemark() {
		return shopRemark;
	}

	public void setShopRemark(String shopRemark) {
		this.shopRemark = shopRemark;
	}

	public Integer getShopStatus() {
		return shopStatus;
	}

	public void setShopStatus(Integer shopStatus) {
		this.shopStatus = shopStatus;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getDeleteflag() {
		return deleteflag;
	}

	public void setDeleteflag(Integer deleteflag) {
		this.deleteflag = deleteflag;
	}
}
