package com.gt.customize.core.controller.minipark.mobile;

import com.gt.axis.bean.wxmp.bus.BusUser;
import com.gt.customize.common.base.BaseController;
import com.gt.customize.common.dto.ResponseDTO;
import com.gt.customize.core.bean.minipark.req.MEatInfoReq;
import com.gt.customize.core.bean.minipark.req.MHotelInfoReq;
import com.gt.customize.core.bean.minipark.req.MListEatReq;
import com.gt.customize.core.bean.minipark.req.MListHotelReq;
import com.gt.customize.core.bean.minipark.res.MEatInfoRes;
import com.gt.customize.core.bean.minipark.res.MHotelInfoRes;
import com.gt.customize.core.bean.minipark.res.MListEatRes;
import com.gt.customize.core.bean.minipark.res.MListHotelRes;
import com.gt.customize.core.exception.minipark.MiniParkException;
import com.gt.customize.core.service.minipark.MiniParkMobileService;
import com.gt.customize.core.util.CommonUtil;
import io.swagger.annotations.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by psr on 2017/10/18 0018.
 */
@Api(value = "/m/minipark", description = "潮州定制-小公园[移动端]")
@RestController
@RequestMapping(value = "/m/minipark")
public class MiniParkMobileController extends BaseController {

    private static Logger logger = Logger.getLogger(MiniParkMobileController.class);

    @Autowired
    MiniParkMobileService miniParkMobileService;

    @ApiResponses({
            @ApiResponse(code = 0, message = "统一响应对象", response = ResponseDTO.class),
            @ApiResponse(code = 1, message = "data对象（数组对象）", response = List.class),
            @ApiResponse(code = 2, message = "活动对象", response = MListEatRes.class),
    })
    @ApiOperation(value = "分页获取餐饮店铺列表", notes = "分页获取餐饮店铺列表")
    @RequestMapping(value = "/listEats", method = RequestMethod.POST)
    public ResponseDTO listEats(@RequestBody @ApiParam("分页获取餐饮店铺列表对象") MListEatReq mListEatReq, BindingResult bindingResult, HttpServletRequest request){
        InvalidParameter(bindingResult);
        try {
            BusUser busUser = CommonUtil.getLoginUser(request);
            ResponseDTO<List<MListEatRes>> responseDTO = miniParkMobileService.listEatsByPage(busUser, mListEatReq);
            return responseDTO;
        } catch (MiniParkException e){
            logger.error(e.getMessage(), e.fillInStackTrace());
            return ResponseDTO.createByErrorCodeMessage(e.getCode(), e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.createByError();
        }
    }

    @ApiResponses({
            @ApiResponse(code = 0, message = "统一响应对象", response = ResponseDTO.class),
            @ApiResponse(code = 1, message = "data对象", response = MEatInfoRes.class),
    })
    @ApiOperation(value = "获取餐饮店铺详情", notes = "获取餐饮店铺详情")
    @RequestMapping(value = "/getEat", method = RequestMethod.POST)
    public ResponseDTO getEat(@RequestBody @ApiParam("获取餐饮店铺详情对象") MEatInfoReq mEatInfoReq, BindingResult bindingResult, HttpServletRequest request){
        InvalidParameter(bindingResult);
        try {
            BusUser busUser = CommonUtil.getLoginUser(request);
            MEatInfoRes mEatInfoRes = miniParkMobileService.getEat(busUser, mEatInfoReq);
            return ResponseDTO.createBySuccess("获取餐饮店铺详情成功", mEatInfoRes);
        } catch (MiniParkException e){
            logger.error(e.getMessage(), e.fillInStackTrace());
            return ResponseDTO.createByErrorCodeMessage(e.getCode(), e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.createByError();
        }
    }

    @ApiResponses({
            @ApiResponse(code = 0, message = "统一响应对象", response = ResponseDTO.class),
            @ApiResponse(code = 1, message = "data对象（数组对象）", response = List.class),
            @ApiResponse(code = 2, message = "活动对象", response = MListHotelRes.class),
    })
    @ApiOperation(value = "分页获取酒店店铺列表", notes = "分页获取酒店店铺列表")
    @RequestMapping(value = "/listHotels", method = RequestMethod.POST)
    public ResponseDTO listHotels(@RequestBody @ApiParam("分页获取酒店店铺列表对象") MListHotelReq mListHotelReq, BindingResult bindingResult, HttpServletRequest request){
        InvalidParameter(bindingResult);
        try {
            BusUser busUser = CommonUtil.getLoginUser(request);
            ResponseDTO<List<MListHotelRes>> responseDTO = miniParkMobileService.listHotelsByPage(busUser, mListHotelReq);
            return responseDTO;
        } catch (MiniParkException e){
            logger.error(e.getMessage(), e.fillInStackTrace());
            return ResponseDTO.createByErrorCodeMessage(e.getCode(), e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.createByError();
        }
    }

    @ApiResponses({
            @ApiResponse(code = 0, message = "统一响应对象", response = ResponseDTO.class),
            @ApiResponse(code = 1, message = "data对象", response = MHotelInfoRes.class),
    })
    @ApiOperation(value = "获取酒店店铺详情", notes = "获取酒店店铺详情")
    @RequestMapping(value = "/getHotel", method = RequestMethod.POST)
    public ResponseDTO getHotel(@RequestBody @ApiParam("获取酒店店铺详情对象") MHotelInfoReq mHotelInfoReq, BindingResult bindingResult, HttpServletRequest request){
        InvalidParameter(bindingResult);
        try {
            BusUser busUser = CommonUtil.getLoginUser(request);
            MHotelInfoRes mHotelInfoRes = miniParkMobileService.getHotel(busUser, mHotelInfoReq);
            return ResponseDTO.createBySuccess("获取酒店店铺详情成功", mHotelInfoRes);
        } catch (MiniParkException e){
            logger.error(e.getMessage(), e.fillInStackTrace());
            return ResponseDTO.createByErrorCodeMessage(e.getCode(), e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.createByError();
        }
    }

}
