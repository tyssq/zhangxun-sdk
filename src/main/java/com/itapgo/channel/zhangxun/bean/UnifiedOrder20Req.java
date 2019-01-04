package com.itapgo.channel.zhangxun.bean;

import lombok.Data;

/**
 * 预统一下单非必要参数
 * 
 * @author LiaoZhengHan
 * @date 2019年1月3日
 */
@Data
public class UnifiedOrder20Req {

	private String customerId;// 账户号
	private String operatorId;// 商户操作员编号
	private String currency;// 默认CNY
	private String goodsName;// 商品名称
	private String alipayUserId;// 买家的支付宝唯一用户号2088102146225135，当channelFlag=01，且此参数不为空，则返回tradeNo，可在支付浏览器用js发起支付，参考https://doc.open.alipay.com/docs/doc.htm?&docType=1&articleId=105672
	private String extraDesc;// 附加信息
}
