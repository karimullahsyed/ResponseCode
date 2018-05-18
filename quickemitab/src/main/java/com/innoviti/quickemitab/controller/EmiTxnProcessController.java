package com.innoviti.quickemitab.controller;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.innoviti.quickemitab.model.Response;
import com.innoviti.quickemitab.service.EmiTxnProcessService;

@RestController
@RequestMapping(value = "/emiTxnProcess")
public class EmiTxnProcessController {
	
	private static Logger logger = LoggerFactory.getLogger(EmiTxnProcessController.class);
	
	@Autowired
	private EmiTxnProcessService emiTxnProcessService;
	
	
	@PostMapping(value = "/saveEmiTxnProcessDetails")
	public ResponseEntity<Response> saveEmiTxnProcessDetails(@RequestPart("jsonEmiTxnProcessRequest")String jsonEmiTxnProcessRequest,@RequestPart("files") MultipartFile[] files) throws JsonParseException, JsonMappingException, IOException {
		logger.info("Entering :: EmiTxnProcessController :: saveEmiTxnProcessDetails method");
		Response response = emiTxnProcessService.saveEmiTxnProcessDetails(jsonEmiTxnProcessRequest,files);
		logger.info("Exiting :: EmiTxnProcessController :: saveEmiTxnProcessDetails method");
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

}
