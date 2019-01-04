package com.itapgo.channel.zhangxun.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 
 * @author LiaoZhengHan
 * @date 2019年1月3日
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class WxGZHUnifiedOrder20Rsp extends RspBase{

	private String transId;
	private String reqId;
	private String orderNo;
	private String appId;
	private String timeStamp;
	private String nonceStr;
	private String pack;
	private String signType;
	private String paySign;
	private String paySignForXiaoChengXu;
}
