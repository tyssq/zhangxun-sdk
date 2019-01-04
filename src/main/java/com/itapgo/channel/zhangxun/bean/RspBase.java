package com.itapgo.channel.zhangxun.bean;

import lombok.Data;

/**
 * 
 * @author LiaoZhengHan
 * @date 2019年1月3日
 */
@Data
public class RspBase {

	private String result;// 详见【附录4.6】
	private String desc;// 详见【附录4.6】
	private String signOut;// 可用于验签
	private String transId;// 平台方唯一交易请求流水号
	private String reqId;// 请求交易的流水号（回传）
}
