package com.itapgo.channel.zhangxun.bean;

import lombok.Data;

/**
 * 3.4 撤销非必须请求参数, orgTransId-》orgReqId-》orderNo 定位原始消费交易的优先级，三个字段必须传一个
 * 
 * @author LiaoZhengHan
 * @date 2019年1月3日
 */
@Data
public class Revoke20Req {

	private String orderNo;
	private String termNo;
	private String orgTransId;
	private String orgReqId;
	private String operatorId;
	private String extraDesc;
}
