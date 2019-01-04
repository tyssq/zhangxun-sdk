package com.itapgo.channel.zhangxun.bean;

import lombok.Data;

/**
 * 微信公众号支付请求非必要参数
 * @author LiaoZhengHan
 * @date 2019年1月3日
 */
@Data
public class WxGZHUnifiedOrder20Req {

	private String goodsName;
	private String operatorId;
	private String currency;
	private String extraDesc;
	private String channelFlag;
}
