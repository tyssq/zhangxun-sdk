package com.itapgo.channel.zhangxun.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 查询（包括消费，撤销和退款）返回
 * 
 * @author LiaoZhengHan
 * @date 2019年1月3日
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class OrderQuery20Rsp extends RspBase{

	private String amount;
	private String channelFlag;
	private String orderNo;
	private String orgTransId;
	private String orgReqId;
	private String outOrderNo;
	private String transType;
	private String transStatus;
	private String operatorId;
	private String currency;
	private String buyerId;
	private String uuid;
	private String payTime;
	private String totalAmount;
	private String receiptAmount;
	private String invoiceAmount;
	private String buyerPayAmount;
	private String goodsName;
	private String extraDesc;
	private String bankType;
}
