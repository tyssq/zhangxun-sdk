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
public class Refund20Rsp extends RspBase{

	private String amount;
	private String channelFlag;
	private String orgTransId;
	private String transId;
	private String out_refund_no;
	private String orderNo;
	private String currency;
}
