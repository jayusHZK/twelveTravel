package com.travel.po;

/***
 * 角色实体
 * @author cgy
 *
 */
public class Role {
	private Integer role_id; // 角色id
	private Integer user_id; // 用户id
	private String role_name; // 角色名称

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	@Override
	public String toString() {
		return "Role [role_id=" + role_id + ", user_id=" + user_id
				+ ", role_name=" + role_name + "]";
	}

	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
}
