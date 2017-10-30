package com.gt.customize.core.service.minipark.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.gt.axis.bean.wxmp.bus.BusUser;
import com.gt.customize.common.dto.PageDTO;
import com.gt.customize.common.dto.ResponseDTO;
import com.gt.customize.common.enums.ResponseEnums;
import com.gt.customize.core.bean.minipark.req.MEatInfoReq;
import com.gt.customize.core.bean.minipark.req.MHotelInfoReq;
import com.gt.customize.core.bean.minipark.req.MListEatReq;
import com.gt.customize.core.bean.minipark.req.MListHotelReq;
import com.gt.customize.core.bean.minipark.res.MEatInfoRes;
import com.gt.customize.core.bean.minipark.res.MHotelInfoRes;
import com.gt.customize.core.bean.minipark.res.MListEatRes;
import com.gt.customize.core.bean.minipark.res.MListHotelRes;
import com.gt.customize.core.entity.minipark.CustomizeMiniparkEat;
import com.gt.customize.core.entity.minipark.CustomizeMiniparkHotel;
import com.gt.customize.core.exception.minipark.MiniParkException;
import com.gt.customize.core.service.minipark.CustomizeMiniparkEatService;
import com.gt.customize.core.service.minipark.CustomizeMiniparkHotelService;
import com.gt.customize.core.service.minipark.MiniParkMobileService;
import com.gt.customize.core.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        List<MListEatRes> mListEatResList = customizeMiniparkEatService.selectListOrderDistanceByPage(page, busUser.getId(), Double.valueOf(mListEatReq.getLon()), Double.valueOf(mListEatReq.getLat()));
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
        List<MListHotelRes> mListHotelResList = customizeMiniparkHotelService.selectListOrderDistanceByPage(page, busUser.getId(), Double.valueOf(mListHotelReq.getLon()), Double.valueOf(mListHotelReq.getLat()));
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

}
