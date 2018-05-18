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
import com.innoviti.quickemitab.service.IssuerBankService;

/**
 * @author Karim
 *
 */
@RestController
@RequestMapping(value = "/issuerBank")
public class IssuerBankController {

	private static Logger logger = LoggerFactory.getLogger(IssuerBankController.class);

	@Autowired
	private IssuerBankService issuerBankService;

	@GetMapping(value = "/fetchBankList/{userId}")
	public ResponseEntity<Response> fetchBankList(@PathVariable Integer userId) {
		logger.info("Entering :: IssuerBankController :: fetchBankList method");
		Response response = issuerBankService.findByuserId(userId);
		logger.info("Exiting :: IssuerBankController :: fetchBankList method");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/fetchBin/{issuerBinNo}/{issuerBankCode}")
	public ResponseEntity<Response> fetchBin(@PathVariable Integer issuerBinNo,@PathVariable Integer issuerBankCode) {
		logger.info("Entering :: IssuerBankController :: fetchBin method");
		Response response = issuerBankService.findByIssuerBin(issuerBinNo,issuerBankCode);
		logger.info("Exiting :: IssuerBankController :: fetchBin method");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

}
