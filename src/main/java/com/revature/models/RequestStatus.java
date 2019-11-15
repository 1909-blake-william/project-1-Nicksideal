package com.revature.models;

public class RequestStatus {
	private int req_status_id;
	private String req_status;
	public RequestStatus() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RequestStatus(int req_status_id, String req_status) {
		super();
		this.req_status_id = req_status_id;
		this.req_status = req_status;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((req_status == null) ? 0 : req_status.hashCode());
		result = prime * result + req_status_id;
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
		RequestStatus other = (RequestStatus) obj;
		if (req_status == null) {
			if (other.req_status != null)
				return false;
		} else if (!req_status.equals(other.req_status))
			return false;
		if (req_status_id != other.req_status_id)
			return false;
		return true;
	}
	public int getReq_status_id() {
		return req_status_id;
	}
	public void setReq_status_id(int req_status_id) {
		this.req_status_id = req_status_id;
	}
	public String getReq_status() {
		return req_status;
	}
	public void setReq_status(String req_status) {
		this.req_status = req_status;
	}
	@Override
	public String toString() {
		return "RequestStatus [req_status_id=" + req_status_id + ", req_status=" + req_status + "]";
	}
	
}
