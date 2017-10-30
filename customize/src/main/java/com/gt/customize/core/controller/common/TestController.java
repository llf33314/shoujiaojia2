package com.gt.customize.core.controller.common;

import com.gt.customize.core.util.CommonUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by psr on 2017/10/28 0028.
 */
@Api(value = "/app/test", description = "测试")
@RestController
@RequestMapping(value = "/app/test")
public class TestController {

    @ApiOperation(value = "获取session中的用户", notes = "获取session中的用户")
    @RequestMapping(value = "/getSessionUser", method = RequestMethod.POST)
    public String getSessionUser(HttpServletRequest httpServletRequest){
        return CommonUtil.getSessionLoginUser(httpServletRequest);
    }

}
