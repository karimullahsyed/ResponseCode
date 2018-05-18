package com.innoviti.quickemitab.model;

import java.util.List;

public class Response {

	  private String responseCode;

	  private String responseMessage;
	  
	  private List<?> responseList;
	  
	 
	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public List<?> getResponseList() {
		return responseList;
	}

	public void setResponseList(List<?> responseList) {
		this.responseList = responseList;
	}
	
}
