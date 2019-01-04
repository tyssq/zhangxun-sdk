package com.itapgo.channel.zhangxun;

import lombok.Getter;

/**
 * 支付渠道
 * 
 * @author LiaoZhengHan
 * @date 2019年1月3日
 */
@Getter
public enum ChannelFlag {
	/**
	 * 微信
	 */
	WEIXIN("00"),
	/**
	 * 支付宝
	 */
	ALI("01"),
	/**
	 * 翼支付
	 */
	YZF("03"),
	;
	private String value;

	private ChannelFlag(String value) {
		this.value = value;
	}
	
}
