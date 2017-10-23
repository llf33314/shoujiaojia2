package com.gt.customize.core.controller.common;

import com.gt.axis.bean.wxmp.bus.BusUser;
import com.gt.axis.bean.wxmp.wxpublic.WxJsSdk;
import com.gt.axis.bean.wxmp.wxpublic.WxJsSdkResult;
import com.gt.axis.bean.wxmp.wxpublic.WxPublicUsers;
import com.gt.axis.server.wxmp.WxPublicServer;
import com.gt.customize.common.base.BaseController;
import com.gt.customize.common.dto.ResponseDTO;
import com.gt.customize.core.bean.minipark.req.MEatInfoReq;
import com.gt.customize.core.bean.minipark.res.MEatInfoRes;
import com.gt.customize.core.bean.wxpublic.req.WxJsSDKReq;
import com.gt.customize.core.exception.minipark.MiniParkException;
import com.gt.customize.core.util.CommonUtil;
import com.gt.customize.core.util.QRcodeKit;
import io.swagger.annotations.*;
import org.apache.log4j.Logger;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by psr on 2017/10/23 0023.
 */
@Api(value = "/app/wxPublic", description = "微信公众号服务")
@RestController
@RequestMapping(value = "/app/wxPublic")
public class WxPublicController extends BaseController {

    private static Logger logger = Logger.getLogger(WxPublicController.class);

    @ApiResponses({
            @ApiResponse(code = 0, message = "统一响应对象", response = ResponseDTO.class),
            @ApiResponse(code = 1, message = "data对象", response = MEatInfoRes.class),
    })
    @ApiOperation(value = "获取微信js-sdk", notes = "获取微信js-sdk")
    @RequestMapping(value = "/getWxJsSDK", method = RequestMethod.POST)
    public ResponseDTO getWxJsSDK(@RequestBody @ApiParam("获取微信js-sdk对象") WxJsSDKReq wxJsSDKReq, BindingResult bindingResult, HttpServletRequest request){
        InvalidParameter(bindingResult);
        try {
            BusUser busUser = CommonUtil.getLoginUser(request);
            WxPublicUsers wxPublicUsers = WxPublicServer.selectByBusId(busUser.getId()).getData();
            WxJsSdk wxJsSdk = new WxJsSdk();
            wxJsSdk.setPublicId(wxPublicUsers.getId());
            wxJsSdk.setUrl(wxJsSDKReq.getShareUrl());
            WxJsSdkResult wxJsSdkResult = WxPublicServer.getWxjssdk(wxJsSdk).getData();
            return ResponseDTO.createBySuccess("获取微信js-sdk成功", wxJsSdkResult);
        } catch (MiniParkException e){
            logger.error(e.getMessage(), e.fillInStackTrace());
            return ResponseDTO.createByErrorCodeMessage(e.getCode(), e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.createByError();
        }
    }


}
