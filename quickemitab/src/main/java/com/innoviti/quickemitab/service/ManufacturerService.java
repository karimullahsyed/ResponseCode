package com.innoviti.quickemitab.service;

import com.innoviti.quickemitab.model.Response;

public interface ManufacturerService {

	public Response fetchManufacturerListBasedOnUserIdAndBankId(Integer issuerBankCode,Integer userId);
}
