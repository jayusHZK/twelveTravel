package com.travel.po;

public class Attractions {

	private Integer attractions_id;// 景点id
	private String attractions_name;// 景点名
	private Integer attractions_hot;// 景点热度
	private String attractions_img;// 景点图片
	private String attractions_introduce;// 景点简介
	private Integer attractions_commentNum;// 景点评论数
	private Beat beat;// 城市实体
	private Province province;// 省份实体
	private Country country;// 国家实体

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Integer getAttractions_hot() {
		return attractions_hot;
	}

	public void setAttractions_hot(Integer attractions_hot) {
		this.attractions_hot = attractions_hot;
	}

	@Override
	public String toString() {
		return "Attractions [attractions_id=" + attractions_id
				+ ", attractions_name=" + attractions_name
				+ ", attractions_hot=" + attractions_hot + ", attractions_img="
				+ attractions_img + ", attractions_introduce="
				+ attractions_introduce + ", attractions_commentNum="
				+ attractions_commentNum + ", beat=" + beat + ", province="
				+ province + ", country=" + country + "]";
	}

	public Integer getAttractions_id() {
		return attractions_id;
	}

	public void setAttractions_id(Integer attractions_id) {
		this.attractions_id = attractions_id;
	}

	public String getAttractions_name() {
		return attractions_name;
	}

	public void setAttractions_name(String attractions_name) {
		this.attractions_name = attractions_name;
	}

	public String getAttractions_img() {
		return attractions_img;
	}

	public void setAttractions_img(String attractions_img) {
		this.attractions_img = attractions_img;
	}

	public String getAttractions_introduce() {
		return attractions_introduce;
	}

	public void setAttractions_introduce(String attractions_introduce) {
		this.attractions_introduce = attractions_introduce;
	}

	public Integer getAttractions_commentNum() {
		return attractions_commentNum;
	}

	public void setAttractions_commentNum(Integer attractions_commentNum) {
		this.attractions_commentNum = attractions_commentNum;
	}

	public Beat getBeat() {
		return beat;
	}

	public void setBeat(Beat beat) {
		this.beat = beat;
	}

}
