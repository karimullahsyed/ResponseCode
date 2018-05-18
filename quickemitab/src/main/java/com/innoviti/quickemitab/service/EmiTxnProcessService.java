package com.innoviti.quickemitab.service;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.web.multipart.MultipartFile;

import com.innoviti.quickemitab.model.Response;

public interface EmiTxnProcessService {
	
	public Response saveEmiTxnProcessDetails(String jsonEmiTxnProcessRequest,MultipartFile[] files) throws JsonParseException, JsonMappingException, IOException;

}
