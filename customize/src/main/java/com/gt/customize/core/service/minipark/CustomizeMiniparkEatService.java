package com.gt.customize.core.service.minipark;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.gt.customize.core.bean.minipark.req.MListEatReq;
import com.gt.customize.core.bean.minipark.res.MListEatRes;
import com.gt.customize.core.entity.minipark.CustomizeMiniparkEat;

import java.util.List;

/**
 * <p>
 * 多粉定制开发-小公园餐饮表 服务类
 * </p>
 *
 * @author psr
 * @since 2017-10-18
 */
public interface CustomizeMiniparkEatService extends IService<CustomizeMiniparkEat> {

    /**
     * 分页获取距离
     * @param page
     * @return
     */
    List<MListEatRes> selectListOrderDistanceByPage(Page<MListEatRes> page, Integer busId, Double lon, Double lat);
}
