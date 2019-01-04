package com.itapgo.channel.zhangxun.bean;

import lombok.Data;

/**
 * 
 * @author LiaoZhengHan
 * @date 2019年1月3日
 */
@Data
public class OrderQuery20Req {

	private String orderNo;// 商户订单号或平台方流水号
	private String termNo;// 终端编码
	private String orgReqId;// 商户请求交易的流水号
	private String orgTransId;// 平台方唯一交易请求流水号
	private String outOrderNo;// 渠道订单号
	private String payChnlOrderNo;// 支付渠道订单号
	private String operatorId;// 商户操作员编号
}
