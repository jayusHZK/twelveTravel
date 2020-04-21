package com.travel.po;
/***
 * 攻略评论
 * @author hzk
 *`comment_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '攻略评论id',
  `comment_txt` varchar(255) DEFAULT NULL COMMENT '攻略评论内容',
  `comment_title` varchar(255) DEFAULT NULL COMMENT '攻略标题',
  `upNum` int(11) DEFAULT NULL COMMENT '点赞数',
  `commentNum` int(11) DEFAULT NULL COMMENT '评论数',
  `readingNum` int(11) DEFAULT NULL COMMENT '阅读数',
  `user_id` int(11) NOT NULL,
  `beat_id` int(11) DEFAULT NULL,
 */
public class StrateComment {
	private Integer comment_id;
	private String comment_txt;
	private String comment_title;
	private Integer upNum;
	private Integer commentNum;
	private Integer readingNum;
	private User user;
	private Integer strategy_id;
	private Integer time;
	public Integer getTime() {
		return time;
	}
	public void setTime(Integer time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "StrateComment [comment_id=" + comment_id + ", comment_txt="
				+ comment_txt + ", comment_title=" + comment_title + ", upNum="
				+ upNum + ", commentNum=" + commentNum + ", readingNum="
				+ readingNum + ", user=" + user + ", strategy_id="
				+ strategy_id + ", time=" + time + "]";
	}
	public Integer getComment_id() {
		return comment_id;
	}
	public void setComment_id(Integer comment_id) {
		this.comment_id = comment_id;
	}
	public String getComment_txt() {
		return comment_txt;
	}
	public void setComment_txt(String comment_txt) {
		this.comment_txt = comment_txt;
	}
	public String getComment_title() {
		return comment_title;
	}
	public void setComment_title(String comment_title) {
		this.comment_title = comment_title;
	}
	public Integer getUpNum() {
		return upNum;
	}
	public void setUpNum(Integer upNum) {
		this.upNum = upNum;
	}
	public Integer getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(Integer commentNum) {
		this.commentNum = commentNum;
	}
	public Integer getReadingNum() {
		return readingNum;
	}
	public void setReadingNum(Integer readingNum) {
		this.readingNum = readingNum;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getStrategy_id() {
		return strategy_id;
	}
	public void setStrategy_id(Integer strategy_id) {
		this.strategy_id = strategy_id;
	}
	
	
}
