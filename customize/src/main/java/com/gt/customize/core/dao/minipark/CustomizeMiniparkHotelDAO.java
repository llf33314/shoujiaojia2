package com.gt.customize.core.dao.minipark;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.gt.customize.core.bean.minipark.res.MListHotelRes;
import com.gt.customize.core.entity.minipark.CustomizeMiniparkHotel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
  * 多粉定制开发-小公园酒店表 Mapper 接口
 * </p>
 *
 * @author psr
 * @since 2017-10-18
 */
public interface CustomizeMiniparkHotelDAO extends BaseMapper<CustomizeMiniparkHotel> {

    List<MListHotelRes> selectListOrderDistanceByPage(@Param("page") Page<MListHotelRes> page, @Param("lon") Double lon, @Param("lat") Double lat);
}