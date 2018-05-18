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
import com.innoviti.quickemitab.service.ManufacturerService;

/**
 * @author Karim
 *
 */
@RestController
@RequestMapping(value = "/manufacturer")
public class ManufacturerController {

	private static Logger logger = LoggerFactory.getLogger(ManufacturerController.class);
	
	@Autowired
	private ManufacturerService manufacturerService;

	@GetMapping(value = "/fetchManufacturerList/{userId}/{issuerBankCode}")
	public ResponseEntity<Response> fetchManufacturerList(@PathVariable Integer userId,@PathVariable Integer issuerBankCode) {
		logger.info("Entering :: ManufacturerController :: fetchManufacturerList method");
		Response response = manufacturerService.fetchManufacturerListBasedOnUserIdAndBankId(userId,issuerBankCode);
		logger.info("Exiting :: ManufacturerController :: fetchManufacturerList method");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

}
