package com.itapgo.channel.zhangxun.bean;

import lombok.Data;

/**
 * 
 * @author LiaoZhengHan
 * @date 2019年1月3日
 */
@Data
public class WxGZHUnifiedOrder21Req {

	private String goodsName;
	private String operatorId;
	private String currency;
	private String extraDesc;
}
