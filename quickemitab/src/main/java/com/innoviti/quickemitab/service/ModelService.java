package com.innoviti.quickemitab.service;

import com.innoviti.quickemitab.model.Response;

public interface ModelService {

	public Response fetchModelListBasedOnUserIdBankIdManufactorerCodeCategoryCode(Integer userId,Integer issuerBankCode,String manufactureCode,String categoryCode);
}
