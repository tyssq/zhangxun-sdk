package com.itapgo.channel.zhangxun;

import lombok.Getter;

/**
 * 扫码类型
 * @author LiaoZhengHan
 * @date 2019年1月3日
 */
@Getter
public enum ScanType {
	DT("2"),
	GD("0"),
	;
	private String value;

	private ScanType(String value) {
		this.value = value;
	}
}
