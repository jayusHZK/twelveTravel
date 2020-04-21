package com.travel.po;

import java.util.List;
/***
 * 权限类型实体
 * @author hzk
 *
 */
public class Power_Type {
	private Integer power_type_id;
	private String type_name;
	private List<Power> pList;
	public Integer getPower_type_id() {
		return power_type_id;
	}
	public void setPower_type_id(Integer power_type_id) {
		this.power_type_id = power_type_id;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	public List<Power> getpList() {
		return pList;
	}
	@Override
	public String toString() {
		return "Power_Type [power_type_id=" + power_type_id + ", type_name="
				+ type_name + ", pList=" + pList + "]";
	}
	public void setpList(List<Power> pList) {
		this.pList = pList;
	}
	
}
