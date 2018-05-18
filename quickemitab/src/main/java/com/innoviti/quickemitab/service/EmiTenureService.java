package com.innoviti.quickemitab.service;

import com.innoviti.quickemitab.model.Response;

public interface EmiTenureService {

	public Response fetchEmiTenureListBasedOnUserIdBankIdManufactorerCodeCategoryCodeAndModelCode(Integer userId,Integer issuerBankCode,String manufactureCode,String categoryCode,String modelCode,String amount);
}
