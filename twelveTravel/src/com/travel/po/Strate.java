package com.travel.po;
/***
 *攻略实体
 * @author you
 *
 */
public class Strate {
	public Integer getStrategy_id() {
		return strategy_id;
	}
	public void setStrategy_id(Integer strategy_id) {
		this.strategy_id = strategy_id;
	}
	public String getTxt() {
		return txt;
	}
	public void setTxt(String txt) {
		this.txt = txt;
	}
	public Integer getStrate_time() {
		return strate_time;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setStrate_time(Integer strate_time) {
		this.strate_time = strate_time;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Beat getBeat() {
		return beat;
	}
	public void setBeat(Beat beat) {
		this.beat = beat;
	}
	@Override
	public String toString() {
		return "Strate [strategy_id=" + strategy_id + ", txt=" + txt
				+ ", strate_time=" + strate_time + ", user=" + user + ", beat="
				+ beat + ", time=" + time + ", title=" + title + ", img=" + img
				+ ", readimgNum=" + readimgNum + "]";
	}
	private Integer strategy_id;
	private String txt;
	private Integer strate_time;
	private User user;
	private Beat beat;
	private String time;
	private String title;
	private String img;
	private Integer readimgNum;
	
	
	
	public Integer getReadimgNum() {
		return readimgNum;
	}
	public void setReadimgNum(Integer readimgNum) {
		this.readimgNum = readimgNum;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
}
