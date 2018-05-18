package com.innoviti.quickemitab.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.innoviti.quickemitab.model.Response;
import com.innoviti.quickemitab.service.ModelService;

/**
 * @author Karim
 *
 */
@RestController
@RequestMapping(value = "/model")
public class ModelController {

	private static Logger logger = LoggerFactory.getLogger(ModelController.class);
	
	@Autowired
	private ModelService modelService;

	@GetMapping(value = "/fetchModelList/{userId}/{issuerBankCode}/{manufactoreCode}/{categoryCode}")
	public ResponseEntity<Response> fetchModelList(@PathVariable Integer userId,@PathVariable Integer issuerBankCode,
															 @PathVariable String manufactoreCode,@PathVariable String categoryCode) {
		logger.info("Entering :: ModelController :: fetchModelList method");
		Response response = modelService.fetchModelListBasedOnUserIdBankIdManufactorerCodeCategoryCode(userId,issuerBankCode,manufactoreCode,categoryCode);
		logger.info("Exiting :: ModelController :: fetchModelList method");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

}
