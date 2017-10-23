package com.gt.customize.core.service.minipark.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.gt.customize.core.bean.minipark.req.MListEatReq;
import com.gt.customize.core.bean.minipark.res.MListEatRes;
import com.gt.customize.core.dao.minipark.CustomizeMiniparkEatDAO;
import com.gt.customize.core.entity.minipark.CustomizeMiniparkEat;
import com.gt.customize.core.service.minipark.CustomizeMiniparkEatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 多粉定制开发-小公园餐饮表 服务实现类
 * </p>
 *
 * @author psr
 * @since 2017-10-18
 */
@Service
public class CustomizeMiniparkEatServiceImpl extends ServiceImpl<CustomizeMiniparkEatDAO, CustomizeMiniparkEat> implements CustomizeMiniparkEatService {

    @Autowired
    CustomizeMiniparkEatDAO customizeMiniparkEatDAO;

    /**
     * 分页获取距离
     *
     * @param page
     * @return
     */
    @Override
    public List<MListEatRes> selectListOrderDistanceByPage(Page<MListEatRes> page, Double lon, Double lat) {
        return customizeMiniparkEatDAO.selectListOrderDistanceByPage(page, lon, lat);
    }
}
