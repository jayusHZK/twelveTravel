package com.travel.po;
/***
 * 权限实体
 * @author hzk
 *
 */
public class Power {
	@Override
	public String toString() {
		return "Power [power_id=" + power_id + ", power_name=" + power_name
				+ ", controller=" + controller + ", action=" + action + ", pt="
				+ pt + "]";
	}
	private Integer power_id;
	private String power_name;
	private String controller;
	private String action;
	private Integer isshow;
	public Integer getPower_id() {
		return power_id;
	}
	public void setPower_id(Integer power_id) {
		this.power_id = power_id;
	}
	public String getPower_name() {
		return power_name;
	}
	public void setPower_name(String power_name) {
		this.power_name = power_name;
	}
	public String getController() {
		return controller;
	}
	public void setController(String controller) {
		this.controller = controller;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public Integer getIsshow() {
		return isshow;
	}
	public void setIsshow(Integer isshow) {
		this.isshow = isshow;
	}
	public Power_Type getPt() {
		return pt;
	}
	public void setPt(Power_Type pt) {
		this.pt = pt;
	}
	private Power_Type pt;
	
}
