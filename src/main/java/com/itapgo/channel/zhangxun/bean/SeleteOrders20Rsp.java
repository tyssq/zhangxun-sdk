package com.itapgo.channel.zhangxun.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 
 * @author LiaoZhengHan
 * @date 2019年1月3日
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class SeleteOrders20Rsp extends RspBase{

	private OrderVo orderList;
	private String pageIndex;
	private String pageSize;
	private String recordNum;
}
