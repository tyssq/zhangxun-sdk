package com.itapgo.channel.zhangxun.bean;

import lombok.Data;

/**
 * 反扫支付非必要参数
 * 
 * @author LiaoZhengHan
 * @date 2019年1月3日
 */
@Data
public class UnScanCodePay21Req {

	private String goodsName;// 商品名
	private String operatorId;// 商户操作员编号
	private String currency;// 默认 CNY
	private String extraDesc;// 附加信息
}
