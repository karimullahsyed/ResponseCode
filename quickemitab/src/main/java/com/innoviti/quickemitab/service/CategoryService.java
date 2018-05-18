package com.innoviti.quickemitab.service;

import com.innoviti.quickemitab.model.Response;

public interface CategoryService {

	public Response fetchCategoryListBasedOnUserIdBankIdAndManufactureCode(Integer userId,Integer issuerBankCode,String merchantCode);
}
