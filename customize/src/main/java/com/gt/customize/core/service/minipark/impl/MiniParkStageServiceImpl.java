package com.gt.customize.core.service.minipark.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.gt.axis.bean.wxmp.bus.BusUser;
import com.gt.customize.common.dto.PageDTO;
import com.gt.customize.common.dto.ResponseDTO;
import com.gt.customize.common.enums.ResponseEnums;
import com.gt.customize.core.bean.minipark.req.*;
import com.gt.customize.core.bean.minipark.res.ListEatRes;
import com.gt.customize.core.bean.minipark.res.ListHotelRes;
import com.gt.customize.core.bean.minipark.res.VideoMainRes;
import com.gt.customize.core.entity.minipark.CustomizeMiniparkEat;
import com.gt.customize.core.entity.minipark.CustomizeMiniparkHotel;
import com.gt.customize.core.entity.minipark.CustomizeMiniparkVideo;
import com.gt.customize.core.entity.minipark.CustomizeMiniparkVideoMain;
import com.gt.customize.core.exception.minipark.MiniParkException;
import com.gt.customize.core.service.minipark.*;
import com.gt.customize.core.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 潮州定制-小公园后台
 * Created by psr on 2017/10/18 0018.
 */
@Service
public class MiniParkStageServiceImpl implements MiniParkStageService {

    @Autowired
    CustomizeMiniparkEatService customizeMiniparkEatService;

    @Autowired
    CustomizeMiniparkHotelService customizeMiniparkHotelService;

    @Autowired
    CustomizeMiniparkVideoService customizeMiniparkVideoService;

    @Autowired
    CustomizeMiniparkVideoMainService customizeMiniparkVideoMainService;

    /**
     * 获取餐饮店铺列表
     *
     * @return
     * @exception MiniParkException
     */
    @Override
    public ResponseDTO<List<ListEatRes>> listEatsByPage(BusUser busUser, ListEatReq listEatReq) throws MiniParkException {
        Page<CustomizeMiniparkEat> page = new Page<>(listEatReq.getCurrent(), listEatReq.getSize());
        EntityWrapper<CustomizeMiniparkEat> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("deleteflag", 0);
        entityWrapper.eq("shop_status", 0);
        entityWrapper.eq("bus_id", busUser.getId());
        List<CustomizeMiniparkEat> customizeMiniparkEatList = customizeMiniparkEatService.selectPage(page, entityWrapper).getRecords();
        List<ListEatRes> listEatResList = new ArrayList<>();
        for (CustomizeMiniparkEat customizeMiniparkEat : customizeMiniparkEatList){
            ListEatRes listEatRes = new ListEatRes();
            listEatRes.setId(customizeMiniparkEat.getId());
            listEatRes.setName(customizeMiniparkEat.getShopName());
            listEatRes.setAddress(customizeMiniparkEat.getShopAdd());
            listEatRes.setPhone(customizeMiniparkEat.getShopPhone());
            listEatRes.setCreateTime(customizeMiniparkEat.getCreateTime());
            // ----- 编辑的信息
            listEatRes.setBannerUrl(customizeMiniparkEat.getShopBannerUrl());
            listEatRes.setIntroduce(customizeMiniparkEat.getShopIntroduce());
            listEatRes.setLogoUrl(customizeMiniparkEat.getShopLogoUrl());
            listEatRes.setRemark(customizeMiniparkEat.getShopRemark());
            listEatRes.setLat(customizeMiniparkEat.getShopLat());
            listEatRes.setLon(customizeMiniparkEat.getShopLon());
            listEatResList.add(listEatRes);
        }
        PageDTO pageDTO = new PageDTO(page.getPages(), page.getTotal());
        return ResponseDTO.createBySuccessPage("分页获取餐饮店铺列表成功", listEatResList, pageDTO);
    }

    /**
     * 新增餐饮店铺
     *
     * @param busUser
     * @param addEatReq
     */
    @Override
    public void addEat(BusUser busUser, AddEatReq addEatReq) throws MiniParkException {
        CustomizeMiniparkEat customizeMiniparkEat = new CustomizeMiniparkEat();
        customizeMiniparkEat.setBusId(busUser.getId());
        customizeMiniparkEat.setShopName(addEatReq.getName());
        customizeMiniparkEat.setShopLogoUrl(addEatReq.getLogoUrl());
        customizeMiniparkEat.setShopIntroduce(addEatReq.getIntroduce());
        customizeMiniparkEat.setShopAdd(addEatReq.getAddress());
        customizeMiniparkEat.setShopLon(addEatReq.getLon());
        customizeMiniparkEat.setShopLat(addEatReq.getLat());
        customizeMiniparkEat.setShopPhone(addEatReq.getPhone());
        customizeMiniparkEat.setShopBannerUrl(addEatReq.getBannerUrl());
        customizeMiniparkEat.setShopRemark(addEatReq.getRemark());
        customizeMiniparkEat.setShopStatus(0);
        customizeMiniparkEat.setCreateTime(new Date());
        customizeMiniparkEat.setDeleteflag(0);
        customizeMiniparkEatService.insert(customizeMiniparkEat);
    }

    /**
     * 编辑餐饮店铺
     *
     * @param busUser
     * @param modifyEatReq
     */
    @Override
    public void modifyEat(BusUser busUser, ModifyEatReq modifyEatReq) throws MiniParkException {
        CustomizeMiniparkEat  customizeMiniparkEat = customizeMiniparkEatService.selectById(modifyEatReq.getId());
        if (CommonUtil.isEmpty(customizeMiniparkEat)){
            throw new MiniParkException(ResponseEnums.INFO_NULL);
        }
        if (!busUser.getId().equals(customizeMiniparkEat.getBusId())){
            throw new MiniParkException(ResponseEnums.DIFF_USER);
        }
        customizeMiniparkEat.setShopName(modifyEatReq.getName());
        customizeMiniparkEat.setShopLogoUrl(modifyEatReq.getLogoUrl());
        customizeMiniparkEat.setShopIntroduce(modifyEatReq.getIntroduce());
        customizeMiniparkEat.setShopAdd(modifyEatReq.getAddress());
        customizeMiniparkEat.setShopLon(modifyEatReq.getLon());
        customizeMiniparkEat.setShopLat(modifyEatReq.getLat());
        customizeMiniparkEat.setShopPhone(modifyEatReq.getPhone());
        customizeMiniparkEat.setShopBannerUrl(modifyEatReq.getBannerUrl());
        customizeMiniparkEat.setShopRemark(modifyEatReq.getRemark());
        customizeMiniparkEatService.updateAllColumnById(customizeMiniparkEat);
    }

    /**
     * 删除餐饮店铺
     *
     * @param busUser
     * @param delEatReq
     */
    @Override
    public void delEat(BusUser busUser, DelEatReq delEatReq) throws MiniParkException {
        CustomizeMiniparkEat  customizeMiniparkEat = customizeMiniparkEatService.selectById(delEatReq.getId());
        if (CommonUtil.isEmpty(customizeMiniparkEat)){
            throw new MiniParkException(ResponseEnums.INFO_NULL);
        }
        if (!busUser.getId().equals(customizeMiniparkEat.getBusId())){
            throw new MiniParkException(ResponseEnums.DIFF_USER);
        }
        customizeMiniparkEat.setDeleteflag(1);
        customizeMiniparkEatService.updateById(customizeMiniparkEat);
    }

    /**
     * 获取酒店店铺列表
     *
     * @return
     * @exception MiniParkException
     */
    @Override
    public ResponseDTO<List<ListHotelRes>> listHotelsByPage(BusUser busUser, ListHotelReq listHotelReq) throws MiniParkException {
        Page<CustomizeMiniparkHotel> page = new Page<>(listHotelReq.getCurrent(), listHotelReq.getSize());
        EntityWrapper<CustomizeMiniparkHotel> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("deleteflag", 0);
        entityWrapper.eq("shop_status", 0);
        entityWrapper.eq("bus_id", busUser.getId());
        List<CustomizeMiniparkHotel> customizeMiniparkHotelList = customizeMiniparkHotelService.selectPage(page, entityWrapper).getRecords();
        List<ListHotelRes> listHotelResList = new ArrayList<>();
        for (CustomizeMiniparkHotel customizeMiniparkHotel : customizeMiniparkHotelList){
            ListHotelRes listHotelRes = new ListHotelRes();
            listHotelRes.setId(customizeMiniparkHotel.getId());
            listHotelRes.setName(customizeMiniparkHotel.getShopName());
            listHotelRes.setAddress(customizeMiniparkHotel.getShopAdd());
            listHotelRes.setPhone(customizeMiniparkHotel.getShopPhone());
            listHotelRes.setCreateTime(customizeMiniparkHotel.getCreateTime());
            // ----- 编辑的信息
            listHotelRes.setBannerUrl(customizeMiniparkHotel.getShopBannerUrl());
            listHotelRes.setIntroduce(customizeMiniparkHotel.getShopIntroduce());
            listHotelRes.setLogoUrl(customizeMiniparkHotel.getShopLogoUrl());
            listHotelRes.setRemark(customizeMiniparkHotel.getShopRemark());
            listHotelRes.setLat(customizeMiniparkHotel.getShopLat());
            listHotelRes.setLon(customizeMiniparkHotel.getShopLon());
            listHotelResList.add(listHotelRes);
        }
        PageDTO pageDTO = new PageDTO(page.getPages(), page.getTotal());
        return ResponseDTO.createBySuccessPage("分页获取酒店店铺列表成功", listHotelResList, pageDTO);
    }

    /**
     * 新增酒店店铺
     *
     * @param busUser
     * @param addHotelReq
     */
    @Override
    public void addHotel(BusUser busUser, AddHotelReq addHotelReq) throws MiniParkException {
        CustomizeMiniparkHotel customizeMiniparkHotel = new CustomizeMiniparkHotel();
        customizeMiniparkHotel.setBusId(busUser.getId());
        customizeMiniparkHotel.setShopName(addHotelReq.getName());
        customizeMiniparkHotel.setShopLogoUrl(addHotelReq.getLogoUrl());
        customizeMiniparkHotel.setShopIntroduce(addHotelReq.getIntroduce());
        customizeMiniparkHotel.setShopAdd(addHotelReq.getAddress());
        customizeMiniparkHotel.setShopLon(addHotelReq.getLon());
        customizeMiniparkHotel.setShopLat(addHotelReq.getLat());
        customizeMiniparkHotel.setShopPhone(addHotelReq.getPhone());
        customizeMiniparkHotel.setShopBannerUrl(addHotelReq.getBannerUrl());
        customizeMiniparkHotel.setShopRemark(addHotelReq.getRemark());
        customizeMiniparkHotel.setShopStatus(0);
        customizeMiniparkHotel.setCreateTime(new Date());
        customizeMiniparkHotel.setDeleteflag(0);
        customizeMiniparkHotelService.insert(customizeMiniparkHotel);
    }

    /**
     * 编辑酒店店铺
     *
     * @param busUser
     * @param modifyHotelReq
     */
    @Override
    public void modifyHotel(BusUser busUser, ModifyHotelReq modifyHotelReq) throws MiniParkException {
        CustomizeMiniparkHotel  customizeMiniparkHotel = customizeMiniparkHotelService.selectById(modifyHotelReq.getId());
        if (CommonUtil.isEmpty(customizeMiniparkHotel)){
            throw new MiniParkException(ResponseEnums.INFO_NULL);
        }
        if (!busUser.getId().equals(customizeMiniparkHotel.getBusId())){
            throw new MiniParkException(ResponseEnums.DIFF_USER);
        }
        customizeMiniparkHotel.setShopName(modifyHotelReq.getName());
        customizeMiniparkHotel.setShopLogoUrl(modifyHotelReq.getLogoUrl());
        customizeMiniparkHotel.setShopIntroduce(modifyHotelReq.getIntroduce());
        customizeMiniparkHotel.setShopAdd(modifyHotelReq.getAddress());
        customizeMiniparkHotel.setShopLon(modifyHotelReq.getLon());
        customizeMiniparkHotel.setShopLat(modifyHotelReq.getLat());
        customizeMiniparkHotel.setShopPhone(modifyHotelReq.getPhone());
        customizeMiniparkHotel.setShopBannerUrl(modifyHotelReq.getBannerUrl());
        customizeMiniparkHotel.setShopRemark(modifyHotelReq.getRemark());
        customizeMiniparkHotelService.updateById(customizeMiniparkHotel);
    }

    /**
     * 删除酒店店铺
     *
     * @param busUser
     * @param delHotelReq
     */
    @Override
    public void delHotel(BusUser busUser, DelHotelReq delHotelReq) throws MiniParkException {
        CustomizeMiniparkHotel  customizeMiniparkHotel = customizeMiniparkHotelService.selectById(delHotelReq.getId());
        if (CommonUtil.isEmpty(customizeMiniparkHotel)){
            throw new MiniParkException(ResponseEnums.INFO_NULL);
        }
        if (!busUser.getId().equals(customizeMiniparkHotel.getBusId())){
            throw new MiniParkException(ResponseEnums.DIFF_USER);
        }
        customizeMiniparkHotel.setDeleteflag(1);
        customizeMiniparkHotelService.updateById(customizeMiniparkHotel);
    }

    /**
     * 获取商家下的所有视频
     *
     * @param busUser
     * @param listVideoReq
     * @return
     * @exception MiniParkException
     */
    @Override
    public ResponseDTO<List<CustomizeMiniparkVideo>> listVideoAll(BusUser busUser, ListVideoReq listVideoReq) throws MiniParkException {
        Page<CustomizeMiniparkVideo> page = new Page<>(listVideoReq.getCurrent(), listVideoReq.getSize());
        EntityWrapper<CustomizeMiniparkVideo> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("bus_id", busUser.getId());
        entityWrapper.eq("delete_flag", 0);
        entityWrapper.orderBy("video_sort", true);
        List<CustomizeMiniparkVideo> customizeMiniparkVideoList = customizeMiniparkVideoService.selectPage(page, entityWrapper).getRecords();
        PageDTO pageDTO = new PageDTO(page.getPages(), page.getTotal());
        return ResponseDTO.createBySuccessPage("获取视频列表成功", customizeMiniparkVideoList, pageDTO);
    }

    /**
     * 新增视频
     *
     * @param busUser
     * @param addVideoReq
     */
    @Override
    public void addVideo(BusUser busUser, AddVideoReq addVideoReq) {
        EntityWrapper<CustomizeMiniparkVideo> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("bus_id", busUser.getId());
        entityWrapper.orderBy("video_sort", false);
        Page<CustomizeMiniparkVideo> page = new Page<>(1, 1);
        List<CustomizeMiniparkVideo> cmvList =  customizeMiniparkVideoService.selectPage(page, entityWrapper).getRecords();
        int videoSort = 1;
        if (CommonUtil.isNotEmpty(cmvList) && cmvList.size() > 0){
            videoSort = cmvList.get(0).getVideoSort() + 1;
        }
        CustomizeMiniparkVideo customizeMiniparkVideo = new CustomizeMiniparkVideo();
        customizeMiniparkVideo.setBusId(busUser.getId());
        customizeMiniparkVideo.setCreateTime(new Date());
        customizeMiniparkVideo.setDeleteFlag(0);
        customizeMiniparkVideo.setImgUrl(addVideoReq.getImgUrl());
        customizeMiniparkVideo.setVideoName(addVideoReq.getVideoName());
        customizeMiniparkVideo.setVideoUrl(addVideoReq.getVideoUrl());
        customizeMiniparkVideo.setVideoSort(videoSort);
        customizeMiniparkVideoService.insertAllColumn(customizeMiniparkVideo);
    }

    /**
     * 修改视频
     *
     * @param busUser
     * @param modifyVideoReq
     */
    @Override
    public void modifyVideo(BusUser busUser, ModifyVideoReq modifyVideoReq) {
        EntityWrapper<CustomizeMiniparkVideo> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("id", modifyVideoReq.getId());
        entityWrapper.eq("bus_id", busUser.getId());
        entityWrapper.eq("delete_flag", 0);
        CustomizeMiniparkVideo customizeMiniparkVideo =  customizeMiniparkVideoService.selectOne(entityWrapper);
        if (CommonUtil.isEmpty(customizeMiniparkVideo)){
            throw new MiniParkException(ResponseEnums.INFO_NULL);
        }
        customizeMiniparkVideo.setVideoUrl(modifyVideoReq.getVideoUrl());
        customizeMiniparkVideo.setVideoName(modifyVideoReq.getVideoName());
        customizeMiniparkVideo.setImgUrl(modifyVideoReq.getImgUrl());
        customizeMiniparkVideoService.updateAllColumnById(customizeMiniparkVideo);
    }

    /**
     * 删除视频
     *
     * @param busUser
     * @param delVideoReq
     */
    @Override
    public void delVideo(BusUser busUser, DelVideoReq delVideoReq) {
        EntityWrapper<CustomizeMiniparkVideo> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("id", delVideoReq.getId());
        entityWrapper.eq("bus_id", busUser.getId());
        entityWrapper.eq("delete_flag", 0);
        CustomizeMiniparkVideo customizeMiniparkVideo =  customizeMiniparkVideoService.selectOne(entityWrapper);
        if (CommonUtil.isEmpty(customizeMiniparkVideo)){
            throw new MiniParkException(ResponseEnums.INFO_NULL);
        }
        customizeMiniparkVideoService.deleteById(delVideoReq.getId());
    }

    /**
     * 获取主视频信息
     *
     * @param busUser
     * @return
     */
    @Override
    public VideoMainRes getMainVideo(BusUser busUser) {
        VideoMainRes videoMainRes = new VideoMainRes();
        EntityWrapper<CustomizeMiniparkVideoMain> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("bus_id", busUser.getId());
        entityWrapper.eq("delete_flag", 0);
        CustomizeMiniparkVideoMain customizeMiniparkVideoMain = customizeMiniparkVideoMainService.selectOne(entityWrapper);
        if (CommonUtil.isNotEmpty(customizeMiniparkVideoMain)){
            videoMainRes.setId(customizeMiniparkVideoMain.getId());
            videoMainRes.setMainImgUrl(customizeMiniparkVideoMain.getMainImgUrl());
            videoMainRes.setMainVideoUrl(customizeMiniparkVideoMain.getMainVideoUrl());
        }
        return videoMainRes;
    }

    /**
     * 新增或修改主视频信息
     *
     * @param busUser
     * @param videoMainReq
     */
    @Override
    public void addOrModifyMainVideo(BusUser busUser, VideoMainReq videoMainReq) {
        EntityWrapper<CustomizeMiniparkVideoMain> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("bus_id", busUser.getId());
        CustomizeMiniparkVideoMain customizeMiniparkVideoMain = customizeMiniparkVideoMainService.selectOne(entityWrapper);
        if (CommonUtil.isEmpty(customizeMiniparkVideoMain)){ // 新增
            if (CommonUtil.isNotEmpty(videoMainReq.getId())){
                throw new MiniParkException(ResponseEnums.DATA_ERROR);
            }
            customizeMiniparkVideoMain = new CustomizeMiniparkVideoMain();
            customizeMiniparkVideoMain.setBusId(busUser.getId());
            customizeMiniparkVideoMain.setCreateTime(new Date());
            customizeMiniparkVideoMain.setDeleteFlag(0);
            customizeMiniparkVideoMain.setMainVideoUrl(videoMainReq.getMainVideoUrl());
            customizeMiniparkVideoMain.setMainImgUrl(videoMainReq.getMainImgUrl());
            customizeMiniparkVideoMainService.insertAllColumn(customizeMiniparkVideoMain);
        }else { // 修改
            if (!customizeMiniparkVideoMain.getId().equals(videoMainReq.getId())){
                throw new MiniParkException(ResponseEnums.DATA_ERROR);
            }
            customizeMiniparkVideoMain.setMainImgUrl(videoMainReq.getMainImgUrl());
            customizeMiniparkVideoMain.setMainVideoUrl(videoMainReq.getMainVideoUrl());
            customizeMiniparkVideoMainService.updateAllColumnById(customizeMiniparkVideoMain);
        }
    }

    /**
     * 修改视频排序
     *
     * @param customizeMiniparkVideoList
     */
    @Override
    public void modifySort(List<CustomizeMiniparkVideo> customizeMiniparkVideoList) {
        customizeMiniparkVideoService.updateBatchById(customizeMiniparkVideoList);
    }
}
