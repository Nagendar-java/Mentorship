package com.bfs.tms.model;

public class Responses {

private String errormessage;
	
	private String errorcode;
	 public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "Responses [errormessage=" + errormessage + ", errorcode=" + errorcode + ", token=" + token + "]";
	}

	private String token;

	public String getErrormessage() {
		return errormessage;
	}

	public void setErrormessage(String errormessage) {
		this.errormessage = errormessage;
	}

	public String getErrorcode() {
		return errorcode;
	}

	public void setErrorcode(String errorcode) {
		this.errorcode = errorcode;
	}

	public Responses(String errormessage, String errorcode, String token) {
		super();
		this.errormessage = errormessage;
		this.errorcode = errorcode;
		this.token = token;
	}

	public Responses() {
		super();
		// TODO Auto-generated constructor stub
	}
}
