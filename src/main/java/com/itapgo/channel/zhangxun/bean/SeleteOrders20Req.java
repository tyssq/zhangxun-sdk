package com.itapgo.channel.zhangxun.bean;

import lombok.Data;

/**
 * 
 * @author LiaoZhengHan
 * @date 2019年1月3日
 */
@Data
public class SeleteOrders20Req {

	private String termNo;
	private String startTime;
	private String endTime;
	private String transType;
	private String operatorId;
}
