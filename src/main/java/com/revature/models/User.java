package com.revature.models;


public class User {
	private int user_id;
	private String username;
	private String password;
	private String race;
	private String class_type;
	private String userRole;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int user_id, String username, String password, String race, String class_type, String userRole) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.race = race;
		this.class_type = class_type;
		this.userRole = userRole;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((class_type == null) ? 0 : class_type.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((race == null) ? 0 : race.hashCode());
		result = prime * result + ((userRole == null) ? 0 : userRole.hashCode());
		result = prime * result + user_id;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		User other = (User) obj;
		if (class_type == null) {
			if (other.class_type != null)
				return false;
		} else if (!class_type.equals(other.class_type))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (race == null) {
			if (other.race != null)
				return false;
		} else if (!race.equals(other.race))
			return false;
		if (userRole == null) {
			if (other.userRole != null)
				return false;
		} else if (!userRole.equals(other.userRole))
			return false;
		if (user_id != other.user_id)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public String getClass_type() {
		return class_type;
	}
	public void setClass_type(String class_type) {
		this.class_type = class_type;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username + ", password=" + password + ", race=" + race
				+ ", class_type=" + class_type + ", userRole=" + userRole + "]";
	}
			
}

