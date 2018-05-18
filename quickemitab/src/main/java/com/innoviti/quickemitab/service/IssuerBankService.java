package com.innoviti.quickemitab.service;

import com.innoviti.quickemitab.model.Response;

public interface IssuerBankService {

	public Response findByuserId(Integer userId);
	
	public Response findByIssuerBin(Integer issuerBinNo,Integer issuerBankCode);
}
