package com.revature.models;

import java.sql.Timestamp;

public class Request {
	private int req_id;
	private String req_name;
	private int req_value;
	private Timestamp req_submitted;
	private Timestamp req_approved;
	private String memo;
	private int req_author;
	private String req_author_name;
	private int req_resolver;
	private String req_resolver_name;
	private int req_status_id;
	private String req_status_id_name;
	private int req_type_id;
	private String req_type_id_name;
	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Request(int req_id, String req_name, int req_value, Timestamp req_submitted, Timestamp req_approved,
			String memo, int req_author, String req_author_name, int req_resolver, String req_resolver_name,
			int req_status_id, String req_status_id_name, int req_type_id, String req_type_id_name) {
		super();
		this.req_id = req_id;
		this.req_name = req_name;
		this.req_value = req_value;
		this.req_submitted = req_submitted;
		this.req_approved = req_approved;
		this.memo = memo;
		this.req_author = req_author;
		this.req_author_name = req_author_name;
		this.req_resolver = req_resolver;
		this.req_resolver_name = req_resolver_name;
		this.req_status_id = req_status_id;
		this.req_status_id_name = req_status_id_name;
		this.req_type_id = req_type_id;
		this.req_type_id_name = req_type_id_name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((memo == null) ? 0 : memo.hashCode());
		result = prime * result + ((req_approved == null) ? 0 : req_approved.hashCode());
		result = prime * result + req_author;
		result = prime * result + ((req_author_name == null) ? 0 : req_author_name.hashCode());
		result = prime * result + req_id;
		result = prime * result + ((req_name == null) ? 0 : req_name.hashCode());
		result = prime * result + req_resolver;
		result = prime * result + ((req_resolver_name == null) ? 0 : req_resolver_name.hashCode());
		result = prime * result + req_status_id;
		result = prime * result + ((req_status_id_name == null) ? 0 : req_status_id_name.hashCode());
		result = prime * result + ((req_submitted == null) ? 0 : req_submitted.hashCode());
		result = prime * result + req_type_id;
		result = prime * result + ((req_type_id_name == null) ? 0 : req_type_id_name.hashCode());
		result = prime * result + req_value;
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
		Request other = (Request) obj;
		if (memo == null) {
			if (other.memo != null)
				return false;
		} else if (!memo.equals(other.memo))
			return false;
		if (req_approved == null) {
			if (other.req_approved != null)
				return false;
		} else if (!req_approved.equals(other.req_approved))
			return false;
		if (req_author != other.req_author)
			return false;
		if (req_author_name == null) {
			if (other.req_author_name != null)
				return false;
		} else if (!req_author_name.equals(other.req_author_name))
			return false;
		if (req_id != other.req_id)
			return false;
		if (req_name == null) {
			if (other.req_name != null)
				return false;
		} else if (!req_name.equals(other.req_name))
			return false;
		if (req_resolver != other.req_resolver)
			return false;
		if (req_resolver_name == null) {
			if (other.req_resolver_name != null)
				return false;
		} else if (!req_resolver_name.equals(other.req_resolver_name))
			return false;
		if (req_status_id != other.req_status_id)
			return false;
		if (req_status_id_name == null) {
			if (other.req_status_id_name != null)
				return false;
		} else if (!req_status_id_name.equals(other.req_status_id_name))
			return false;
		if (req_submitted == null) {
			if (other.req_submitted != null)
				return false;
		} else if (!req_submitted.equals(other.req_submitted))
			return false;
		if (req_type_id != other.req_type_id)
			return false;
		if (req_type_id_name == null) {
			if (other.req_type_id_name != null)
				return false;
		} else if (!req_type_id_name.equals(other.req_type_id_name))
			return false;
		if (req_value != other.req_value)
			return false;
		return true;
	}
	public int getReq_id() {
		return req_id;
	}
	public void setReq_id(int req_id) {
		this.req_id = req_id;
	}
	public String getReq_name() {
		return req_name;
	}
	public void setReq_name(String req_name) {
		this.req_name = req_name;
	}
	public int getReq_value() {
		return req_value;
	}
	public void setReq_value(int req_value) {
		this.req_value = req_value;
	}
	public Timestamp getReq_submitted() {
		return req_submitted;
	}
	public void setReq_submitted(Timestamp req_submitted) {
		this.req_submitted = req_submitted;
	}
	public Timestamp getReq_approved() {
		return req_approved;
	}
	public void setReq_approved(Timestamp req_approved) {
		this.req_approved = req_approved;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public int getReq_author() {
		return req_author;
	}
	public void setReq_author(int req_author) {
		this.req_author = req_author;
	}
	public String getReq_author_name() {
		return req_author_name;
	}
	public void setReq_author_name(String req_author_name) {
		this.req_author_name = req_author_name;
	}
	public int getReq_resolver() {
		return req_resolver;
	}
	public void setReq_resolver(int req_resolver) {
		this.req_resolver = req_resolver;
	}
	public String getReq_resolver_name() {
		return req_resolver_name;
	}
	public void setReq_resolver_name(String req_resolver_name) {
		this.req_resolver_name = req_resolver_name;
	}
	public int getReq_status_id() {
		return req_status_id;
	}
	public void setReq_status_id(int req_status_id) {
		this.req_status_id = req_status_id;
	}
	public String getReq_status_id_name() {
		return req_status_id_name;
	}
	public void setReq_status_id_name(String req_status_id_name) {
		this.req_status_id_name = req_status_id_name;
	}
	public int getReq_type_id() {
		return req_type_id;
	}
	public void setReq_type_id(int req_type_id) {
		this.req_type_id = req_type_id;
	}
	public String getReq_type_id_name() {
		return req_type_id_name;
	}
	public void setReq_type_id_name(String req_type_id_name) {
		this.req_type_id_name = req_type_id_name;
	}
	@Override
	public String toString() {
		return "Request [req_id=" + req_id + ", req_name=" + req_name + ", req_value=" + req_value + ", req_submitted="
				+ req_submitted + ", req_approved=" + req_approved + ", memo=" + memo + ", req_author=" + req_author
				+ ", req_author_name=" + req_author_name + ", req_resolver=" + req_resolver + ", req_resolver_name="
				+ req_resolver_name + ", req_status_id=" + req_status_id + ", req_status_id_name=" + req_status_id_name
				+ ", req_type_id=" + req_type_id + ", req_type_id_name=" + req_type_id_name + "]";
	}
		
}
