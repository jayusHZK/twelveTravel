package com.travel.po;
/***
 * 景点评论实体
 * @author hzk
 *
 */
public class AttrComment {
	private Integer comment_id;
	private String comment;
	private Integer comment_time;
	private User user;
	private Integer attr_id;
	@Override
	public String toString() {
		return "AttrComment [comment_id=" + comment_id + ", comment=" + comment
				+ ", comment_time=" + comment_time + ", user=" + user
				+ ", attr_id=" + attr_id + "]";
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
	public Integer getComment_time() {
		return comment_time;
	}
	public void setComment_time(Integer comment_time) {
		this.comment_time = comment_time;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getAttr_id() {
		return attr_id;
	}
	public void setAttr_id(Integer attr_id) {
		this.attr_id = attr_id;
	}
}
