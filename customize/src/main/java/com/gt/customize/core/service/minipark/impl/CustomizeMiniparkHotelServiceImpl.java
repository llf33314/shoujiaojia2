package com.gt.customize.core.service.minipark.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.gt.customize.core.bean.minipark.res.MListHotelRes;
import com.gt.customize.core.entity.minipark.CustomizeMiniparkHotel;
import com.gt.customize.core.dao.minipark.CustomizeMiniparkHotelDAO;
import com.gt.customize.core.service.minipark.CustomizeMiniparkHotelService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 多粉定制开发-小公园酒店表 服务实现类
 * </p>
 *
 * @author psr
 * @since 2017-10-18
 */
@Service
public class CustomizeMiniparkHotelServiceImpl extends ServiceImpl<CustomizeMiniparkHotelDAO, CustomizeMiniparkHotel> implements CustomizeMiniparkHotelService {

    @Autowired
    CustomizeMiniparkHotelDAO customizeMiniparkHotelDAO;

    /**
     * 根据距离分页获取店铺信息
     *
     * @param page
     * @param lon
     * @param lat
     * @return
     */
    @Override
    public List<MListHotelRes> selectListOrderDistanceByPage(Page<MListHotelRes> page, Double lon, Double lat) {
        return customizeMiniparkHotelDAO.selectListOrderDistanceByPage(page, lon, lat);
    }
}
