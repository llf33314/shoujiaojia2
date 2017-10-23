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
import com.gt.customize.core.entity.minipark.CustomizeMiniparkEat;
import com.gt.customize.core.entity.minipark.CustomizeMiniparkHotel;
import com.gt.customize.core.exception.minipark.MiniParkException;
import com.gt.customize.core.service.minipark.CustomizeMiniparkEatService;
import com.gt.customize.core.service.minipark.CustomizeMiniparkHotelService;
import com.gt.customize.core.service.minipark.MiniParkStageService;
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
        Page<CustomizeMiniparkEat> page = new Page<>(listHotelReq.getCurrent(), listHotelReq.getSize());
        EntityWrapper<CustomizeMiniparkHotel> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("deleteflag", 0);
        entityWrapper.eq("shop_status", 0);
        entityWrapper.eq("bus_id", busUser.getId());
        List<CustomizeMiniparkHotel> customizeMiniparkHotelList = customizeMiniparkHotelService.selectList(entityWrapper);
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
}
