package com.itapgo.channel.zhangxun.bean;

import lombok.Data;

/**
 * 一码付生成二维码(动态码)
 * 
 * @author LiaoZhengHan
 * @date 2019年1月3日
 */
@Data
public class ProduceOneCodeReq {

	private String termNo;
	private String goodsName;// 固码不能填
}
