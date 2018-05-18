package com.innoviti.quickemitab.service;

import com.innoviti.quickemitab.model.ForgotPasswordRequest;

public interface EmailService {
	
	public String toSendMail(ForgotPasswordRequest forgotPassword);

}
