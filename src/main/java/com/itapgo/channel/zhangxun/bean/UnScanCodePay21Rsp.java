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
public class UnScanCodePay21Rsp extends RspBase{

	private String orderNo;// 商户订单号（回传）
	private String outOrderNo;// 渠道订单号
	private String channelFlag;// 见附录【4.4支付渠道】
	private String buyerId;// 【支付宝】消费交易可返回
	private String currency;// 默认 CNY
	private String uuid;// 微信支付下的openid,支付宝支付下的 userid
	private String payTime;// 支付完成时间
	private String totalAmount;// 支付宝交易：totalAmount订单金额（单位元）
	private String receiptAmount;// receiptAmount实收金额（单位元）
	private String invoiceAmount;// invoiceAmount开票金额（单位元）
	private String buyerPayAmount;// buyerPayAmount付款金额（单位元）
	private String bankType;// 见【附录4.5 银行类型】
}
