package com.travel.vo;

import java.util.Date;

/***
 * 区域查询前台映射Vo
 * 
 * @author tp
 * 
 */
public class BeatVO {

	// 城市ID
	private Integer beat_id;
	// 城市名称
	private String beat_name;
	// 图片路径编码
	private String beat_img;
	// 说明
	private String beat_introduce;
	// 是否热点
	private Integer hotNum;
	// 城市上级编码
	private Integer parent_id;
	// 省区域编码
	private Integer province_id;
	//省名称
	private String  province_name;

	public Integer getProvince_id() {
		return province_id;
	}

	public void setProvince_id(Integer province_id) {
		this.province_id = province_id;
	}

	public Integer getBeat_id() {
		return beat_id;
	}

	public void setBeat_id(Integer beat_id) {
		this.beat_id = beat_id;
	}

	public String getBeat_name() {
		return beat_name;
	}

	public void setBeat_name(String beat_name) {
		this.beat_name = beat_name;
	}

	public String getBeat_img() {
		return beat_img;
	}

	public void setBeat_img(String beat_img) {
		this.beat_img = beat_img;
	}

	public String getBeat_introduce() {
		return beat_introduce;
	}

	public void setBeat_introduce(String beat_introduce) {
		this.beat_introduce = beat_introduce;
	}

	public Integer getHotNum() {
		return hotNum;
	}

	public void setHotNum(Integer hotNum) {
		this.hotNum = hotNum;
	}

	public Integer getParent_id() {
		return parent_id;
	}

	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}

	public String getProvince_name() {
		return province_name;
	}

	public void setProvince_name(String province_name) {
		this.province_name = province_name;
	}
	
	
   
}
