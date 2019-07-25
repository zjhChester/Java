package com.love.domain;

public class Comment {
	private String userId;
	private String createTime;
	private String comment;
	private String statu;
	public Comment(String userId, String createTime, String comment, String statu) {
		super();
		this.userId = userId;
		this.createTime = createTime;
		this.comment = comment;
		this.statu = statu;
	}
	public Comment() {
		super();
	}
	@Override
	public String toString() {
		return "Comment [userId=" + userId + ", createTime=" + createTime + ", comment=" + comment + ", statu=" + statu
				+ "]";
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getStatu() {
		return statu;
	}
	public void setStatu(String statu) {
		this.statu = statu;
	}
	
}