package com.itapgo.channel.zhangxun;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.cglib.beans.BeanMap;

import com.alibaba.fastjson.JSONObject;
import com.itapgo.http.HttpUtil;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author LiaoZhengHan
 * @date 2019年1月3日
 */
@Data
@Slf4j
public class ZhangxunBase {

	protected String reqUrl = "http://scptest.yufu99.com/scanpay-api/api/";
	protected String key = "1111111111111111111111111111111111111111111111111111111111111111";
	protected String merNo = "SAS100000009253";
	protected String termNo = "00001081";
	protected Map<String, String> reqMap = new HashMap<>();
	
	protected String sign;
	
	protected String rspStr;
	protected String errMsg;
	protected JSONObject rspJson;
	
	protected boolean createSign() {
		sign = createSign(reqMap);
		reqMap.put("signIn", sign);
		return true;
	}

	/**
	 * 生成签名
	 * 
	 * @author LiaoZhengHan
	 * @date 2019年1月3日
	 * @param reqMap
	 * @return
	 */
	protected String createSign(Map<String, String> reqMap) {

		StringBuilder sb = new StringBuilder();

		TreeMap<String, String> signMap = new TreeMap<>(reqMap);
		Iterator<Entry<String, String>> it = signMap.entrySet().iterator();
		Entry<String, String> entry;
		boolean bl = false;
		while (it.hasNext()) {
			entry = it.next();
			if ("signOut".equals(entry.getKey())) {
				continue;
			}
			if (StringUtils.isNotEmpty(entry.getKey()) && entry.getValue() != null) {
				if (bl) {
					sb.append('&');
				} else {
					bl = true;
				}
				sb.append(entry.getKey());
				sb.append('=');
				sb.append(entry.getValue());
			}
		}
		sb.append(key);
		return DigestUtils.md5Hex(sb.toString()).toUpperCase();
	}

	protected boolean doPost(String apiName) {
		rspStr = HttpUtil.httpPostForm(reqUrl + apiName, reqMap);
		try {
			rspJson = JSONObject.parseObject(rspStr);
		} catch (Exception e) {
			log.error("返回数据不是json类型，返回数据：{}", rspStr);
			return false;
		}
		return true;
	}
	
	protected boolean postDeal(String apiName, Object req) {
		if (req != null) {
			try {
				beanToMap(req, reqMap);
			} catch (Exception e) {
				log.error("BeanUtils.copyProperties出错", e);
			}
		}
		return postDeal(apiName);
	}
	
	protected boolean postDeal(String apiName) {
		
		/**
		 * 1.公共参数
		 */
		reqMap.put("merNo", merNo);
		
		if (!createSign()) {
			return false;
		}
		
		if (!doPost(apiName)) {
			return false;
		}
		
		if (result() && checkSign()) {
			return true;
		}
		
		return false;
	}
	
	protected boolean checkSign() {
		
		@SuppressWarnings("unchecked")
		Map<String, String> signMap = rspJson.toJavaObject(Map.class);
		String sign = createSign(signMap);
		if (sign.equalsIgnoreCase(signMap.get("signOut"))) {
			return true;
		}
		log.warn("验证签名失败");
		return false;
	}
	
	protected boolean result() {
		if ("0000".equals(rspJson.get("result"))) {
			return true;
		}
		errMsg = rspJson.getString("desc");
		return false;
	}
	
	public <T extends Object> T getRsp(Class<T> cls) {
		T t = rspJson.toJavaObject(cls);
		return t;
	}
	
	public static <T> void beanToMap(T bean, Map<String, String> map) {
        if (bean != null) {
            BeanMap beanMap = BeanMap.create(bean);
            for (Object key : beanMap.keySet()) {
            	if (beanMap.get(key) != null) {
            		map.put(key + "", (String) beanMap.get(key));
            	}
            }
        }
    }
}
