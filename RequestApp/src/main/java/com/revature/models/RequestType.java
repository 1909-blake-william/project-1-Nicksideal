package com.revature.models;

public class RequestType {
	private int req_type_id;
	private String req_type;
	public RequestType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RequestType(int req_type_id, String req_type) {
		super();
		this.req_type_id = req_type_id;
		this.req_type = req_type;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((req_type == null) ? 0 : req_type.hashCode());
		result = prime * result + req_type_id;
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
		RequestType other = (RequestType) obj;
		if (req_type == null) {
			if (other.req_type != null)
				return false;
		} else if (!req_type.equals(other.req_type))
			return false;
		if (req_type_id != other.req_type_id)
			return false;
		return true;
	}
	public int getReq_type_id() {
		return req_type_id;
	}
	public void setReq_type_id(int req_type_id) {
		this.req_type_id = req_type_id;
	}
	public String getReq_type() {
		return req_type;
	}
	public void setReq_type(String req_type) {
		this.req_type = req_type;
	}
	@Override
	public String toString() {
		return "RequestType [req_type_id=" + req_type_id + ", req_type=" + req_type + "]";
	}
	
	

}
