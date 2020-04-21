package com.travel.po;
/***
 * 区域评论实体类
 * @author hzk
 *
 */
public class BeatComment {
	private Integer comment_id;
	private String comment;
	private int comment_time;
	private User user;
	private Integer beat_id;
	@Override
	public String toString() {
		return "BeatComment [comment_id=" + comment_id + ", comment=" + comment
				+ ", comment_time=" + comment_time + ", user=" + user
				+ ", beat_id=" + beat_id + "]";
	}
	public Integer getComment_id() {
		return comment_id;
	}
	public void setComment_id(Integer comment_id) {
		this.comment_id = comment_id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getComment_time() {
		return comment_time;
	}
	public void setComment_time(int comment_time) {
		this.comment_time = comment_time;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getBeat_id() {
		return beat_id;
	}
	public void setBeat_id(Integer beat_id) {
		this.beat_id = beat_id;
	}
}
