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
public class UnifiedOrder20Rsp extends RspBase {

	private String orderNo;// 商户订单号（回传）
	private String codeUrl;// 渠道返回的二维码链接，可将该参数值生成二维码展示出来进行扫码支付，返回码为0000时不为空
	private String tradeNo;// 支付宝交易号
}
