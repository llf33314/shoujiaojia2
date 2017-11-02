package com.gt.customize.core.controller.minipark;

import com.gt.axis.bean.wxmp.bus.BusUser;
import com.gt.customize.common.base.BaseController;
import com.gt.customize.common.dto.ResponseDTO;
import com.gt.customize.core.bean.minipark.req.*;
import com.gt.customize.core.bean.minipark.res.ListEatRes;
import com.gt.customize.core.bean.minipark.res.ListHotelRes;
import com.gt.customize.core.bean.minipark.res.VideoMainRes;
import com.gt.customize.core.entity.minipark.CustomizeMiniparkVideo;
import com.gt.customize.core.exception.minipark.MiniParkException;
import com.gt.customize.core.service.minipark.MiniParkStageService;
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
import javax.validation.Valid;
import java.util.List;

/**
 *
 * Created by psr on 2017/10/18 0018.
 */
@Api(value = "/app/minipark", description = "潮州定制-小公园[后台]")
@RestController
@RequestMapping(value = "/app/minipark")
public class MiniParkStageController extends BaseController {

    private static Logger logger = Logger.getLogger(MiniParkStageController.class);

    @Autowired
    MiniParkStageService miniParkStageService;

    @ApiResponses({
            @ApiResponse(code = 0, message = "统一响应对象", response = ResponseDTO.class),
            @ApiResponse(code = 1, message = "data对象（数组对象）", response = List.class),
            @ApiResponse(code = 2, message = "活动对象", response = ListEatRes.class),
    })
    @ApiOperation(value = "分页获取餐饮店铺列表", notes = "分页获取餐饮店铺列表")
    @RequestMapping(value = "/listEats", method = RequestMethod.POST)
    public ResponseDTO listEats(@RequestBody @ApiParam("分页获取餐饮店铺列表对象") @Valid ListEatReq listEatReq, BindingResult bindingResult, HttpServletRequest request){
        InvalidParameter(bindingResult);
        try {
            logger.debug(listEatReq.toString());
            BusUser busUser = CommonUtil.getLoginUser(request);
            ResponseDTO<List<ListEatRes>> responseDTO = miniParkStageService.listEatsByPage(busUser, listEatReq);
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
    })
    @ApiOperation(value = "新增餐饮店铺", notes = "新增餐饮店铺")
    @RequestMapping(value = "/addEat", method = RequestMethod.POST)
    public ResponseDTO addEat(@RequestBody @ApiParam("新增餐饮店铺对象") @Valid AddEatReq addEatReq, BindingResult bindingResult, HttpServletRequest request){
        InvalidParameter(bindingResult);
        try {
            logger.debug(addEatReq.toString());
            BusUser busUser = CommonUtil.getLoginUser(request);
            miniParkStageService.addEat(busUser, addEatReq);
            return ResponseDTO.createBySuccessMessage("新增餐饮店铺成功");
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
    })
    @ApiOperation(value = "编辑餐饮店铺", notes = "编辑餐饮店铺")
    @RequestMapping(value = "/modifyEat", method = RequestMethod.POST)
    public ResponseDTO modifyEat(@RequestBody @ApiParam("编辑餐饮店铺对象") @Valid ModifyEatReq modifyEatReq, BindingResult bindingResult, HttpServletRequest request){
        InvalidParameter(bindingResult);
        try {
            logger.debug(modifyEatReq.toString());
            BusUser busUser = CommonUtil.getLoginUser(request);
            miniParkStageService.modifyEat(busUser, modifyEatReq);
            return ResponseDTO.createBySuccessMessage("编辑餐饮店铺成功");
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
    })
    @ApiOperation(value = "删除餐饮店铺", notes = "删除餐饮店铺")
    @RequestMapping(value = "/delEat", method = RequestMethod.POST)
    public ResponseDTO delEat(@RequestBody @ApiParam("删除餐饮店铺对象") @Valid DelEatReq delEatReq, BindingResult bindingResult, HttpServletRequest request){
        InvalidParameter(bindingResult);
        try {
            BusUser busUser = CommonUtil.getLoginUser(request);
            miniParkStageService.delEat(busUser, delEatReq);
            return ResponseDTO.createBySuccessMessage("删除餐饮店铺成功");
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
            @ApiResponse(code = 2, message = "活动对象", response = ListEatRes.class),
    })
    @ApiOperation(value = "分页获取酒店店铺列表", notes = "分页获取酒店店铺列表")
    @RequestMapping(value = "/listHotels", method = RequestMethod.POST)
    public ResponseDTO listHotels(@RequestBody @ApiParam("分页获取酒店店铺列表对象") @Valid ListHotelReq listHotelReq, BindingResult bindingResult, HttpServletRequest request){
        InvalidParameter(bindingResult);
        try {
            BusUser busUser = CommonUtil.getLoginUser(request);
            ResponseDTO<List<ListHotelRes>> responseDTO = miniParkStageService.listHotelsByPage(busUser, listHotelReq);
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
    })
    @ApiOperation(value = "新增酒店店铺", notes = "新增酒店店铺")
    @RequestMapping(value = "/addHotel", method = RequestMethod.POST)
    public ResponseDTO addHotel(@RequestBody @ApiParam("新增酒店店铺对象") @Valid AddHotelReq addHotelReq, BindingResult bindingResult, HttpServletRequest request){
        InvalidParameter(bindingResult);
        try {
            BusUser busUser = CommonUtil.getLoginUser(request);
            miniParkStageService.addHotel(busUser, addHotelReq);
            return ResponseDTO.createBySuccessMessage("新增酒店店铺成功");
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
    })
    @ApiOperation(value = "编辑酒店店铺", notes = "编辑酒店店铺")
    @RequestMapping(value = "/modifyHotel", method = RequestMethod.POST)
    public ResponseDTO modifyHotel(@RequestBody @ApiParam("编辑酒店店铺对象") @Valid ModifyHotelReq modifyHotelReq, BindingResult bindingResult, HttpServletRequest request){
        InvalidParameter(bindingResult);
        try {
            BusUser busUser = CommonUtil.getLoginUser(request);
            miniParkStageService.modifyHotel(busUser, modifyHotelReq);
            return ResponseDTO.createBySuccessMessage("编辑酒店店铺成功");
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
    })
    @ApiOperation(value = "删除酒店店铺", notes = "删除酒店店铺")
    @RequestMapping(value = "/delHotel", method = RequestMethod.POST)
    public ResponseDTO delHotel(@RequestBody @ApiParam("删除餐饮店铺对象") @Valid DelHotelReq delHotelReq, BindingResult bindingResult, HttpServletRequest request){
        InvalidParameter(bindingResult);
        try {
            BusUser busUser = CommonUtil.getLoginUser(request);
            miniParkStageService.delHotel(busUser, delHotelReq);
            return ResponseDTO.createBySuccessMessage("删除酒店店铺成功");
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
            @ApiResponse(code = 2, message = "活动对象", response = ListEatRes.class),
    })
    @ApiOperation(value = "获取视频列表", notes = "获取视频列表")
    @RequestMapping(value = "/listVideos", method = RequestMethod.POST)
    public ResponseDTO listVideos(@RequestBody @ApiParam("请求对象") @Valid ListVideoReq listVideoReq, BindingResult bindingResult, HttpServletRequest request){
        InvalidParameter(bindingResult);
        try {
            BusUser busUser = CommonUtil.getLoginUser(request);
            ResponseDTO<List<CustomizeMiniparkVideo>> responseDTO = miniParkStageService.listVideoAll(busUser, listVideoReq);
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
    })
    @ApiOperation(value = "新增视频", notes = "新增视频")
    @RequestMapping(value = "/addVideo", method = RequestMethod.POST)
    public ResponseDTO addVideo(@RequestBody @ApiParam("新增视频对象") @Valid AddVideoReq addVideoReq, BindingResult bindingResult, HttpServletRequest request){
        InvalidParameter(bindingResult);
        try {
            logger.debug(addVideoReq.toString());
            BusUser busUser = CommonUtil.getLoginUser(request);
            miniParkStageService.addVideo(busUser, addVideoReq);
            return ResponseDTO.createBySuccessMessage("新增视频成功");
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
    })
    @ApiOperation(value = "修改视频", notes = "修改视频")
    @RequestMapping(value = "/modifyVideo", method = RequestMethod.POST)
    public ResponseDTO modifyVideo(@RequestBody @ApiParam("修改视频对象") @Valid ModifyVideoReq modifyVideoReq, BindingResult bindingResult, HttpServletRequest request){
        InvalidParameter(bindingResult);
        try {
            logger.debug(modifyVideoReq.toString());
            BusUser busUser = CommonUtil.getLoginUser(request);
            miniParkStageService.modifyVideo(busUser, modifyVideoReq);
            return ResponseDTO.createBySuccessMessage("修改视频成功");
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
    })
    @ApiOperation(value = "删除视频", notes = "删除视频")
    @RequestMapping(value = "/delVideo", method = RequestMethod.POST)
    public ResponseDTO delVideo(@RequestBody @ApiParam("删除视频对象") @Valid DelVideoReq delVideoReq, BindingResult bindingResult, HttpServletRequest request){
        InvalidParameter(bindingResult);
        try {
            logger.debug(delVideoReq.toString());
            BusUser busUser = CommonUtil.getLoginUser(request);
            miniParkStageService.delVideo(busUser, delVideoReq);
            return ResponseDTO.createBySuccessMessage("修改视频成功");
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
            @ApiResponse(code = 1, message = "data对象（数组对象）", response = VideoMainRes.class),
    })
    @ApiOperation(value = "获取主视频", notes = "获取主视频")
    @RequestMapping(value = "/getMainVideo", method = RequestMethod.POST)
    public ResponseDTO getMainVideo(HttpServletRequest request){
        try {
            logger.debug("getMainVideo");
            BusUser busUser = CommonUtil.getLoginUser(request);
            VideoMainRes videoMainRes = miniParkStageService.getMainVideo(busUser);
            return ResponseDTO.createBySuccess("获取主视频成功", videoMainRes);
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
            @ApiResponse(code = 1, message = "data对象（数组对象）", response = VideoMainRes.class),
    })
    @ApiOperation(value = "新增或修改主视频", notes = "新增或修改主视频")
    @RequestMapping(value = "/addOrModifyMainVideo", method = RequestMethod.POST)
    public ResponseDTO addOrModifyMainVideo(@RequestBody @ApiParam("请求对象") @Valid VideoMainReq videoMainReq, BindingResult bindingResult, HttpServletRequest request){
        InvalidParameter(bindingResult);
        try {
            logger.debug(videoMainReq.toString());
            BusUser busUser = CommonUtil.getLoginUser(request);
            miniParkStageService.addOrModifyMainVideo(busUser, videoMainReq);
            return ResponseDTO.createBySuccessMessage("新增或修改主视频成功");
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
    })
    @ApiOperation(value = "修改视频排序", notes = "修改视频排序")
    @RequestMapping(value = "/modifySort", method = RequestMethod.POST)
    public ResponseDTO modifySort(@RequestBody List<CustomizeMiniparkVideo> customizeMiniparkVideoList){
        try {
            logger.debug("modifySort");
            miniParkStageService.modifySort(customizeMiniparkVideoList);
            return ResponseDTO.createBySuccessMessage("视频排序成功");
        } catch (MiniParkException e){
            logger.error(e.getMessage(), e.fillInStackTrace());
            return ResponseDTO.createByErrorCodeMessage(e.getCode(), e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
            return ResponseDTO.createByError();
        }
    }

}
