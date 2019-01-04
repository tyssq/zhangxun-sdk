package com.itapgo.channel.zhangxun;

import java.util.Date;
import java.util.Map;

import com.itapgo.channel.zhangxun.bean.OrderQuery20Req;
import com.itapgo.channel.zhangxun.bean.ProduceOneCodeReq;
import com.itapgo.channel.zhangxun.bean.Refund20Req;
import com.itapgo.channel.zhangxun.bean.Revoke20Req;
import com.itapgo.channel.zhangxun.bean.SeleteOrders20Req;
import com.itapgo.channel.zhangxun.bean.UnScanCodePay21Req;
import com.itapgo.channel.zhangxun.bean.WxGZHUnifiedOrder20Req;
import com.itapgo.utils.StringUtil;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

/**
 * 掌讯支付
 * 
 * @author LiaoZhengHan
 * @date 2019年1月3日
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Slf4j
public class ZhangxunPay extends ZhangxunBase {

	private String beforeUrl = "https://qrpay.itapgo.com/qrpay/mvc/testnotify";
	private String notifyUrl = "https://qrpay.itapgo.com/qrpay/mvc/testnotify";

	/**
	 * 统一预下单
	 * 
	 * @author LiaoZhengHan
	 * @date 2019年1月3日
	 * @param orderNo     订单编号
	 * @param channelFlag 支付渠道
	 * @param amount      金额（单位：分）
	 * @return
	 */
	public boolean unifiedOrder20(String orderNo, ChannelFlag channelFlag, String amount) {

		reqMap.put("merNo", merNo);
		reqMap.put("termNo", termNo);
		reqMap.put("orderNo", orderNo);
		reqMap.put("channelFlag", channelFlag.getValue());
		reqMap.put("amount", amount);
		reqMap.put("reqId", StringUtil.getRandomOrder());
		reqMap.put("reqTime", StringUtil.getDateStr(new Date()));
		reqMap.put("notifyUrl", notifyUrl);
		reqMap.put("beforeUrl", beforeUrl);

		return postDeal("unifiedOrder20");
	}

	/**
	 * 反扫支付
	 * 
	 * @author LiaoZhengHan
	 * @date 2019年1月3日
	 * @param authCode
	 * @param orderNo
	 * @param amount
	 * @return
	 */
	public boolean unScanCodePay21(String authCode, String orderNo, String amount) {
		return unScanCodePay21(authCode, orderNo, amount, null);
	}

	/**
	 * 反扫支付
	 * 
	 * @author LiaoZhengHan
	 * @date 2019年1月3日
	 * @param authCode
	 * @param orderNo
	 * @param amount
	 * @param unScanCodePay21
	 * @return
	 */
	public boolean unScanCodePay21(String authCode, String orderNo, String amount, UnScanCodePay21Req unScanCodePay21) {

		reqMap.put("merNo", merNo);
		reqMap.put("termNo", termNo);
		reqMap.put("reqId", StringUtil.getRandomOrder());
		reqMap.put("reqTime", StringUtil.getDateStr(new Date()));
		reqMap.put("notifyUrl", notifyUrl);
		reqMap.put("orderNo", orderNo);
		reqMap.put("amount", amount);
		reqMap.put("authCode", authCode);

		if (unScanCodePay21 != null) {
			reqMap.put("goodsName", unScanCodePay21.getGoodsName());
			reqMap.put("operatorId", unScanCodePay21.getOperatorId());
			reqMap.put("currency", unScanCodePay21.getCurrency());
			reqMap.put("extraDesc", unScanCodePay21.getExtraDesc());
		}

		return postDeal("unScanCodePay21");
	}

	public boolean orderQuery20(OrderQuery20Req req) {
		return postDeal("orderQuery20", req);
	}

	public boolean revoke20(Revoke20Req req) {

		reqMap.put("reqId", StringUtil.getRandomOrder());
		reqMap.put("reqTime", StringUtil.getDateStr(new Date()));

		return postDeal("revoke20", req);
	}

	public boolean refund20(Refund20Req req) {

		reqMap.put("reqId", StringUtil.getRandomOrder());
		reqMap.put("reqTime", StringUtil.getDateStr(new Date()));

		return postDeal("refund20", req);
	}

	public boolean seleteOrders20(int pageIndex, int pageSize, SeleteOrders20Req req) {
		reqMap.put("pageIndex", pageIndex + "");
		reqMap.put("pageSize", pageSize + "");
		return postDeal("seleteOrders20", req);
	}

	public boolean notify(Map<String, String> notifyMap) {

		/**
		 * 1.判断商户号
		 */
		if (!merNo.equals(notifyMap.get("merNo"))) {
			errMsg = "未识别的商户号";
			log.warn("未识别的商户号：{}", merNo);
			return false;
		}

		/**
		 * 2.验证签名
		 */
		String sign = createSign(notifyMap);
		String signOut = notifyMap.get("signOut");
		if (!sign.equalsIgnoreCase(signOut)) {
			errMsg = "验证签名失败";
			log.warn("验证签名失败");
			return false;
		}
		return true;
	}

	/**
	 * 微信公众号支付
	 * 
	 * @author LiaoZhengHan
	 * @date 2019年1月3日
	 * @param orderNo   商户订单号或平台方流水号
	 * @param amount    订单金额（单位：分）
	 * @param subAppId  接入方微信公众号 id（于微信分配）
	 * @param subOpenId 接入方下单前需要调用微信【网页授权获取用户信息】接口获取到用户的 openId
	 * @param req
	 * @return
	 */
	public boolean wxGZHUnifiedOrder20(String orderNo, long amount, String subAppId, String subOpenId,
			WxGZHUnifiedOrder20Req req) {

		reqMap.put("reqId", StringUtil.getRandomOrder());
		reqMap.put("reqTime", StringUtil.getDateStr(new Date()));
		reqMap.put("orderNo", orderNo);
		reqMap.put("amount", amount + "");
		reqMap.put("subAppId", subAppId);
		reqMap.put("subOpenId", subOpenId);

		return postDeal("wxGZHUnifiedOrder20", req);
	}

	/**
	 * 一码付生成二维码
	 * 
	 * @author LiaoZhengHan
	 * @date 2019年1月3日
	 * @param scanType
	 * @param orderNo
	 * @param amount
	 * @param req
	 * @return
	 */
	public boolean produceOneCode(ScanType scanType, String orderNo, Long amount, ProduceOneCodeReq req) {

		reqMap.put("reqId", StringUtil.getRandomOrder());
		reqMap.put("reqTime", StringUtil.getDateStr(new Date()));
		if (scanType == ScanType.DT) {
			reqMap.put("orderNo", orderNo);
			reqMap.put("amount", amount + "");
			reqMap.put("reqId", StringUtil.getRandomOrder());
			reqMap.put("reqTime", StringUtil.getDateStr(new Date()));
		}
		reqMap.put("scanType", scanType.getValue());// 固定填2:一码付动码
		reqMap.put("notifyUrl", notifyUrl);

		return postDeal("produceOneCode", req);
	}

}
