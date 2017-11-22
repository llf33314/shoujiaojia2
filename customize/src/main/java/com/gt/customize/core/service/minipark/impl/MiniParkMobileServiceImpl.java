package com.gt.customize.core.service.minipark.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.gt.axis.bean.wxmp.bus.BusUser;
import com.gt.customize.common.dto.PageDTO;
import com.gt.customize.common.dto.ResponseDTO;
import com.gt.customize.common.enums.ResponseEnums;
import com.gt.customize.core.bean.minipark.req.*;
import com.gt.customize.core.bean.minipark.res.*;
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
import java.util.List;

/**
 * 潮州定制-小公园手机端
 * Created by psr on 2017/10/18 0018.
 */
@Service
public class MiniParkMobileServiceImpl implements MiniParkMobileService {

    @Autowired
    CustomizeMiniparkEatService customizeMiniparkEatService;

    @Autowired
    CustomizeMiniparkHotelService customizeMiniparkHotelService;

    @Autowired
    CustomizeMiniparkVideoMainService customizeMiniparkVideoMainService;

    @Autowired
    CustomizeMiniparkVideoService customizeMiniparkVideoService;

    /**
     * 分页获取餐饮店铺列表
     *
     * @param busUser
     * @param mListEatReq
     * @return
     */
    @Override
    public ResponseDTO<List<MListEatRes>> listEatsByPage(BusUser busUser, MListEatReq mListEatReq) throws MiniParkException {
        Page<MListEatRes> page = new Page<>(mListEatReq.getCurrent(), mListEatReq.getSize());
        Double lon = 114.43721;
        Double lat = 23.08828;
        if (CommonUtil.isNotEmpty(mListEatReq.getLon())){
            lon = Double.valueOf(mListEatReq.getLon());
        }
        if (CommonUtil.isNotEmpty(mListEatReq.getLat())){
            lat = Double.valueOf(mListEatReq.getLat());
        }
        List<MListEatRes> mListEatResList = customizeMiniparkEatService.selectListOrderDistanceByPage(page, busUser.getId(), lon, lat);
        PageDTO pageDTO = new PageDTO(page.getPages(), page.getTotal());
        return ResponseDTO.createBySuccessPage("分页获取餐饮店铺列表成功", mListEatResList, pageDTO);
    }

    /**
     * 获取餐饮店铺详情
     *
     * @param busUser
     * @param mEatInfoReq
     * @return
     */
    @Override
    public MEatInfoRes getEat(BusUser busUser, MEatInfoReq mEatInfoReq) throws MiniParkException {
        CustomizeMiniparkEat customizeMiniparkEat = customizeMiniparkEatService.selectById(mEatInfoReq.getId());
        if (CommonUtil.isEmpty(customizeMiniparkEat)){
            throw new MiniParkException(ResponseEnums.INFO_NULL);
        }
        if (!busUser.getId().equals(customizeMiniparkEat.getBusId())){
            throw new MiniParkException(ResponseEnums.DIFF_USER);
        }
        MEatInfoRes mEatInfoRes = new MEatInfoRes();
        mEatInfoRes.setAddress(customizeMiniparkEat.getShopAdd());
        mEatInfoRes.setBannerUrl(customizeMiniparkEat.getShopBannerUrl());
        mEatInfoRes.setName(customizeMiniparkEat.getShopName());
        mEatInfoRes.setPhone(customizeMiniparkEat.getShopPhone());
        mEatInfoRes.setRemark(customizeMiniparkEat.getShopRemark());
        mEatInfoRes.setLat(customizeMiniparkEat.getShopLat());
        mEatInfoRes.setLon(customizeMiniparkEat.getShopLon());
        return mEatInfoRes;
    }

    /**
     * 分页获取酒店店铺列表
     *
     * @param busUser
     * @param mListHotelReq
     * @return
     */
    @Override
    public ResponseDTO<List<MListHotelRes>> listHotelsByPage(BusUser busUser, MListHotelReq mListHotelReq) throws MiniParkException {
        Page<MListHotelRes> page = new Page<>(mListHotelReq.getCurrent(), mListHotelReq.getSize());
        Double lon = 114.43721;
        Double lat = 23.08828;
        if (CommonUtil.isNotEmpty(mListHotelReq.getLon())){
            lon = Double.valueOf(mListHotelReq.getLon());
        }
        if (CommonUtil.isNotEmpty(mListHotelReq.getLat())){
            lat = Double.valueOf(mListHotelReq.getLat());
        }
        List<MListHotelRes> mListHotelResList = customizeMiniparkHotelService.selectListOrderDistanceByPage(page, busUser.getId(), lon, lat);
        PageDTO pageDTO = new PageDTO(page.getPages(), page.getTotal());
        return ResponseDTO.createBySuccessPage("分页获取酒店店铺列表成功", mListHotelResList, pageDTO);
    }

    /**
     * 获取餐饮店铺详情
     *
     * @param busUser
     * @param mHotelInfoReq
     * @return
     */
    @Override
    public MHotelInfoRes getHotel(BusUser busUser, MHotelInfoReq mHotelInfoReq) throws MiniParkException {
        CustomizeMiniparkHotel customizeMiniparkHotel = customizeMiniparkHotelService.selectById(mHotelInfoReq.getId());
        if (CommonUtil.isEmpty(customizeMiniparkHotel)){
            throw new MiniParkException(ResponseEnums.INFO_NULL);
        }
        if (!busUser.getId().equals(customizeMiniparkHotel.getBusId())){
            throw new MiniParkException(ResponseEnums.DIFF_USER);
        }
        MHotelInfoRes mHotelInfoRes = new MHotelInfoRes();
        mHotelInfoRes.setAddress(customizeMiniparkHotel.getShopAdd());
        mHotelInfoRes.setBannerUrl(customizeMiniparkHotel.getShopBannerUrl());
        mHotelInfoRes.setName(customizeMiniparkHotel.getShopName());
        mHotelInfoRes.setPhone(customizeMiniparkHotel.getShopPhone());
        mHotelInfoRes.setRemark(customizeMiniparkHotel.getShopRemark());
        mHotelInfoRes.setLat(customizeMiniparkHotel.getShopLat());
        mHotelInfoRes.setLon(customizeMiniparkHotel.getShopLon());
        return mHotelInfoRes;
    }

    /**
     * 获取主视频
     *
     * @param busUser
     * @return
     */
    @Override
    public MVideoMainRes getVideoMain(BusUser busUser) {
        MVideoMainRes mVideoMainRes = new MVideoMainRes();
        EntityWrapper<CustomizeMiniparkVideoMain> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("bus_id", busUser.getId());
        CustomizeMiniparkVideoMain customizeMiniparkVideoMain = customizeMiniparkVideoMainService.selectOne(entityWrapper);
        if (CommonUtil.isNotEmpty(customizeMiniparkVideoMain)){
            mVideoMainRes.setImgUrl(customizeMiniparkVideoMain.getMainImgUrl());
            mVideoMainRes.setVideoUrl(customizeMiniparkVideoMain.getMainVideoUrl());
        }
        return mVideoMainRes;
    }

    /**
     * 获取视频列表
     *
     * @param busUser
     * @param mListVideoReq
     * @return
     */
    @Override
    public ResponseDTO<List<MListVideoRes>> listVideos(BusUser busUser, MListVideoReq mListVideoReq) {
        List<MListVideoRes> mListVideoResList = new ArrayList<>();
        EntityWrapper<CustomizeMiniparkVideo> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("bus_id", busUser.getId());
        entityWrapper.orderBy("video_sort");
        List<CustomizeMiniparkVideo> customizeMiniparkVideoList = customizeMiniparkVideoService.selectList(entityWrapper);
        for (CustomizeMiniparkVideo customizeMiniparkVideo : customizeMiniparkVideoList){
            MListVideoRes mListVideoRes = new MListVideoRes();
            mListVideoRes.setImgUrl(customizeMiniparkVideo.getImgUrl());
            mListVideoRes.setVideoUrl(customizeMiniparkVideo.getVideoUrl());
            mListVideoResList.add(mListVideoRes);
        }
        return ResponseDTO.createBySuccess("获取视频列表成功", mListVideoResList);
    }
}
