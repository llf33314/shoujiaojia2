package com.gt.customize.core.service.minipark;

import com.gt.axis.bean.wxmp.bus.BusUser;
import com.gt.customize.common.dto.ResponseDTO;
import com.gt.customize.core.bean.minipark.req.*;
import com.gt.customize.core.bean.minipark.res.*;
import com.gt.customize.core.exception.minipark.MiniParkException;

import java.util.List;

/**
 * 小公园手机端接口
 * Created by psr on 2017/10/18 0018.
 */
public interface MiniParkMobileService {

    /**
     * 分页获取餐饮店铺列表
     * @param busUser
     * @param mListEatReq
     * @return
     */
    ResponseDTO<List<MListEatRes>> listEatsByPage(BusUser busUser, MListEatReq mListEatReq) throws MiniParkException;

    /**
     * 获取餐饮店铺详情
     * @param busUser
     * @param mEatInfoReq
     * @return
     */
    MEatInfoRes getEat(BusUser busUser, MEatInfoReq mEatInfoReq) throws MiniParkException;

    /**
     * 分页获取酒店店铺列表
     * @param busUser
     * @param mListHotelReq
     * @return
     */
    ResponseDTO<List<MListHotelRes>> listHotelsByPage(BusUser busUser, MListHotelReq mListHotelReq) throws MiniParkException;

    /**
     * 获取餐饮店铺详情
     * @param busUser
     * @param mHotelInfoReq
     * @return
     */
    MHotelInfoRes getHotel(BusUser busUser, MHotelInfoReq mHotelInfoReq) throws MiniParkException;

    /**
     * 获取主视频
     * @param busUser
     * @return
     */
    MVideoMainRes getVideoMain(BusUser busUser);

    /**
     * 获取视频列表
     * @param busUser
     * @param mListVideoReq
     * @return
     */
    ResponseDTO<List<MListVideoRes>> listVideos(BusUser busUser, MListVideoReq mListVideoReq);
}
