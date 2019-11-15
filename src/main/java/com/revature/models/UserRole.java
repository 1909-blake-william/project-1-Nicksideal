package com.revature.models;

public class UserRole {
	private int req_user_role_id;
	private String user_role;
	public UserRole() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserRole(int req_user_role_id, String user_role) {
		super();
		this.req_user_role_id = req_user_role_id;
		this.user_role = user_role;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + req_user_role_id;
		result = prime * result + ((user_role == null) ? 0 : user_role.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserRole other = (UserRole) obj;
		if (req_user_role_id != other.req_user_role_id)
			return false;
		if (user_role == null) {
			if (other.user_role != null)
				return false;
		} else if (!user_role.equals(other.user_role))
			return false;
		return true;
	}
	public int getReq_user_role_id() {
		return req_user_role_id;
	}
	public void setReq_user_role_id(int req_user_role_id) {
		this.req_user_role_id = req_user_role_id;
	}
	public String getUser_role() {
		return user_role;
	}
	public void setUser_role(String user_role) {
		this.user_role = user_role;
	}
	@Override
	public String toString() {
		return "UserRole [req_user_role_id=" + req_user_role_id + ", user_role=" + user_role + "]";
	}
	

}
