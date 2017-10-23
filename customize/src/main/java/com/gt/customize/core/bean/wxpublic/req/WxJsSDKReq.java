package com.gt.customize.core.bean.wxpublic.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by psr on 2017/10/23 0023.
 */
@ApiModel(value = "微信js-sdk请求类")
public class WxJsSDKReq {

    @ApiModelProperty(value = "微信分享链接")
    private String shareUrl; // 分享链接

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }
}
