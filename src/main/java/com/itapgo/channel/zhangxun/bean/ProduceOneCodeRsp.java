package com.itapgo.channel.zhangxun.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 一码付生成二维码(动态码)
 * 
 * @author LiaoZhengHan
 * @date 2019年1月3日
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ProduceOneCodeRsp extends RspBase {

	private String termNo;
	private String reqId;
	private String orderNo;
	private String oneCodeUrl;
	private String merNo;
}
