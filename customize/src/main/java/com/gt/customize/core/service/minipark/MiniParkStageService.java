package com.gt.customize.core.service.minipark;

import com.gt.axis.bean.wxmp.bus.BusUser;
import com.gt.customize.common.dto.ResponseDTO;
import com.gt.customize.core.bean.minipark.req.*;
import com.gt.customize.core.bean.minipark.res.ListEatRes;
import com.gt.customize.core.bean.minipark.res.ListHotelRes;
import com.gt.customize.core.exception.minipark.MiniParkException;

import java.util.List;

/**
 * 小公园后台接口
 * Created by psr on 2017/10/18 0018.
 */
public interface MiniParkStageService {

    /**
     * 获取餐饮店铺列表
     * @return
     * @throws MiniParkException
     */
    ResponseDTO<List<ListEatRes>> listEatsByPage(BusUser busUser, ListEatReq listEatReq) throws MiniParkException;

    /**
     * 新增餐饮店铺
     * @param busUser
     * @param addEatReq
     */
    void addEat(BusUser busUser, AddEatReq addEatReq) throws MiniParkException;

    /**
     * 编辑餐饮店铺
     * @param busUser
     * @param modifyEatReq
     */
    void modifyEat(BusUser busUser, ModifyEatReq modifyEatReq) throws MiniParkException;

    /**
     * 删除餐饮店铺
     * @param busUser
     * @param delEatReq
     */
    void delEat(BusUser busUser, DelEatReq delEatReq) throws MiniParkException;

    /**
     * 获取酒店店铺列表
     * @return
     * @throws MiniParkException
     */
    ResponseDTO<List<ListHotelRes>> listHotelsByPage(BusUser busUser, ListHotelReq listHotelReq) throws MiniParkException;

    /**
     * 新增酒店店铺
     * @param busUser
     * @param addHotelReq
     */
    void addHotel(BusUser busUser, AddHotelReq addHotelReq) throws MiniParkException;

    /**
     * 编辑酒店店铺
     * @param busUser
     * @param modifyHotelReq
     */
    void modifyHotel(BusUser busUser, ModifyHotelReq modifyHotelReq) throws MiniParkException;

    /**
     * 删除酒店店铺
     * @param busUser
     * @param delHotelReq
     */
    void delHotel(BusUser busUser, DelHotelReq delHotelReq) throws MiniParkException;
}
