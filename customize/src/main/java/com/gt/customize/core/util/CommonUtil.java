package com.gt.customize.core.util;


import com.alibaba.fastjson.JSONObject;
import com.gt.api.util.SessionUtils;
import com.gt.axis.bean.wxmp.bus.BusUser;
import com.gt.axis.bean.wxmp.bus.BusUserApiReq;
import com.gt.axis.server.wxmp.BusServer;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * 获取登录用户信息
 * 
 * @author Administrator
 * 
 */
public class CommonUtil {
	private static final Logger log = Logger.getLogger(CommonUtil.class);

	/**
	 * 获取session中的登录用户（开发中）
	 *
	 * @param request
	 * @return
	 */
	public static BusUser getLoginUser(HttpServletRequest request) {
		try {
			com.gt.api.bean.session.BusUser apiBusUser = SessionUtils.getLoginUser(request);
//			BusUser busUser = new BusUser();
//			busUser.setId(apiBusUser.getId());
			BusUserApiReq busUserApiReq = new BusUserApiReq();
			busUserApiReq.setUserId(apiBusUser.getId());
//			busUser.setAddSource();
//			busUser.setAdvert();
//			busUser.setAgentid();
//			busUser.setBusmoneyLevel();
//			busUser.setCityId();
//			busUser.setCtime();
//			return busUser;
			return BusServer.getBusUserApi(busUserApiReq).getData();
		} catch (Exception e) {
			log.info(e.getLocalizedMessage());
			e.printStackTrace();
		}
		return null;
	};

	/**
	 * 获取session中的登录用户（开发中）
	 *
	 * @param request
	 * @return
	 */
	public static BusUser getDevLoginUser(HttpServletRequest request) {
		try {
			BusUserApiReq busUserApiReq = new BusUserApiReq();
			// TODO 后续应该从共享的session中获取
			busUserApiReq.setUserId(33);
			return BusServer.getBusUserApi(busUserApiReq).getData();
		} catch (Exception e) {
			log.info(e.getLocalizedMessage());
			e.printStackTrace();
		}
		return null;
	};

	/**
	 * 获取session中的用户
	 * @param request
	 * @return
	 */
	public static String getSessionLoginUser(HttpServletRequest request) {
		try {
			com.gt.api.bean.session.BusUser busUser = SessionUtils.getLoginUser(request);
			String busStr = JSONObject.toJSONString(busUser);
			return busStr;
		} catch (Exception e) {
			log.info(e.getLocalizedMessage());
			e.printStackTrace();
		}
		return null;
	};

	/**
	 * 判断对象是否为空
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean isEmpty(Object obj) {
		boolean b = false;
		try {
			if (obj == null || "".equals(obj)) {
				b = true;
			} else {
				b = false;
			}
		} catch (Exception e) {
			b = false;
			e.printStackTrace();
		}
		return b;
	}

	/**
	 * 判断对象是否不为空
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean isNotEmpty(Object obj) {
		boolean b = false;
		try {
			if (obj == null || "".equals(obj)) {
				b = false;
			} else {
				b = true;
			}
		} catch (Exception e) {
			b = false;
			e.printStackTrace();
		}
		return b;
	}

	/**
	 * 转Integer
	 *
	 * @param obj
	 */
	public static Integer toInteger(Object obj) {
		try {
			if (!isEmpty(obj)) {
				return Integer.parseInt(obj.toString());
			} else {
				throw new Exception("对象为空，转换失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 转string
	 * @param obj
	 * @return
	 */
	public static String Blob2String(Object obj) {
		String string = null;
		try {
			if (obj == null || "".equals(obj)) {
				return "";
			}
			byte[] bytes = (byte[]) obj;
			string = new String(bytes, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return string;
	}
}
