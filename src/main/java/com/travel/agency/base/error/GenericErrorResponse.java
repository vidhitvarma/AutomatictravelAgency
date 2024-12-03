package com.travel.agency.base.error;

public class GenericErrorResponse {
	
	private int statusCode;
	private String message;
	private Long time;
	
	public GenericErrorResponse(int statusCode, String message, Long time) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.time = time;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "GenericErrorResponse [statusCode=" + statusCode + ", message=" + message + ", time=" + time + "]";
	}
	
	
	

}
