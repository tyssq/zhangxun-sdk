package com.itapgo.channel.zhangxun.bean;

import lombok.Data;

/**
 * 退款接口非必传参数
 * 
 * @author LiaoZhengHan
 * @date 2019年1月3日
 */
@Data
public class Refund20Req {

	private String orderNo;
	private String termNo;
	private String money;
	private String orgTransId;
	private String orgReqId;
	private String operatorId;
	private String extraDesc;
}
