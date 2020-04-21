package com.travel.po;

public class Country {
	@Override
	public String toString() {
		return "Country [country_id=" + country_id + ", country_name="
				+ country_name + ", counttry_img=" + counttry_img
				+ ", country_interduce=" + country_interduce + "]";
	}
	private Integer country_id;
	private String country_name;
	private String counttry_img;
	private String country_interduce;
	public Integer getCountry_id() {
		return country_id;
	}
	public void setCountry_id(Integer country_id) {
		this.country_id = country_id;
	}
	public String getCountry_name() {
		return country_name;
	}
	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}
	public String getCounttry_img() {
		return counttry_img;
	}
	public void setCounttry_img(String counttry_img) {
		this.counttry_img = counttry_img;
	}
	public String getCountry_interduce() {
		return country_interduce;
	}
	public void setCountry_interduce(String country_interduce) {
		this.country_interduce = country_interduce;
	}
	
}
