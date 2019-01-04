package com.itapgo.channel.zhangxun.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 撤销返回
 * 
 * @author LiaoZhengHan
 * @date 2019年1月3日
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Revoke20Rsp extends RspBase {

	private String amount;
	private String channelFlag;
	private String transId;
	private String orgTransId;
	private String orderNo;
	private String currency;
	private String outOrderNo;
}
