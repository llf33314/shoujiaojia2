package com.gt.customize.core.dao.minipark;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.gt.customize.core.bean.minipark.req.MListEatReq;
import com.gt.customize.core.bean.minipark.res.MListEatRes;
import com.gt.customize.core.entity.minipark.CustomizeMiniparkEat;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
  * 多粉定制开发-小公园餐饮表 Mapper 接口
 * </p>
 *
 * @author psr
 * @since 2017-10-18
 */
public interface CustomizeMiniparkEatDAO extends BaseMapper<CustomizeMiniparkEat> {

    List<MListEatRes> selectListOrderDistanceByPage(@Param("page") Page<MListEatRes> page, @Param("lon") Double lon, @Param("lat") Double lat);
}