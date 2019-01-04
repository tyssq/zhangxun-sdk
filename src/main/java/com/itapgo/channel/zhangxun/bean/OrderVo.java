package com.itapgo.channel.zhangxun.bean;

import lombok.Data;

/**
 * 分页查询订单对象
 * 
 * @author LiaoZhengHan
 * @date 2019年1月3日
 */
@Data
public class OrderVo {

	private String channelFlag;
	private String orderNo;
	private String money;
	private String orgTransId;
	private String orgReqId;
	private String transType;
	private String transResult;
	private String transStatus;
	private String operatorId;
	private String currency;
	private String fee;
	private String payTime;
	private String goodsName;
	private String extraDesc;
}
