package com.travel.po;

import java.util.Date;

/***
 * 城市实体
 * 
 * @author cgy
 * 
 */
public class Beat {

	private Integer beat_id;
	private String beat_name;
	private String beat_img;
	private String beat_introduce;
	private Integer hotNum;
	private Province province;

	@Override
	public String toString() {
		return "Beat [beat_id=" + beat_id + ", beat_name=" + beat_name
				+ ", beat_img=" + beat_img + ", beat_introduce="
				+ beat_introduce + ", hotNum=" + hotNum + ", province="
				+ province + ", parent_id=" + parent_id + ", create_date="
				+ create_date + "]";
	}

	private Integer parent_id;

	private Integer province_id;

	private Date create_date;

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

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

}
