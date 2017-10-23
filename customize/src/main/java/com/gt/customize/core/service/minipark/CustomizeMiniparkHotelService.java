package com.gt.customize.core.service.minipark;

import com.baomidou.mybatisplus.plugins.Page;
import com.gt.customize.core.bean.minipark.req.MListHotelReq;
import com.gt.customize.core.bean.minipark.res.MListHotelRes;
import com.gt.customize.core.entity.minipark.CustomizeMiniparkHotel;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 多粉定制开发-小公园酒店表 服务类
 * </p>
 *
 * @author psr
 * @since 2017-10-18
 */
public interface CustomizeMiniparkHotelService extends IService<CustomizeMiniparkHotel> {

    /**
     * 根据距离分页获取店铺信息
     * @param page
     * @param lon
     * @param lat
     * @return
     */
    List<MListHotelRes> selectListOrderDistanceByPage(Page<MListHotelRes> page, Double lon, Double lat);
}
