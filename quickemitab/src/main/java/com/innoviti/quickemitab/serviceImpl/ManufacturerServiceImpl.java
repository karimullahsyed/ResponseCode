package com.innoviti.quickemitab.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.innoviti.quickemitab.model.ErrorCode;
import com.innoviti.quickemitab.model.ManufacturerResponse;
import com.innoviti.quickemitab.model.Response;
import com.innoviti.quickemitab.repository.config.ManufacturerRepository;
import com.innoviti.quickemitab.service.ManufacturerService;

@Service
@Transactional("configManager")
public class ManufacturerServiceImpl implements ManufacturerService {

	private static Logger logger = LoggerFactory.getLogger(ManufacturerServiceImpl.class);
	
	@Autowired
	private ManufacturerRepository manufacturerRepository;
	
	@Override
	public Response fetchManufacturerListBasedOnUserIdAndBankId(Integer userId,Integer issuerBankCode) {
		logger.info("Entering :: ManufacturerServiceImpl :: fetchManufacturerListBasedOnUserIdAndBankId method");
		Response response = new Response();
		ManufacturerResponse manufacturerResponse = null;
		List<ManufacturerResponse> manufacturerList =  new ArrayList<>();
		List<Object[]> objectList = manufacturerRepository.fetchManufacturerBasedOnUserIdAndBankId(userId,issuerBankCode);
		if(objectList.isEmpty()) {
			 response.setResponseCode(ErrorCode.ERROR_MANUFACUTURER_CODE_NOT_FOUND);
			 response.setResponseMessage(ErrorCode.getInstance().getMessage(ErrorCode.ERROR_MANUFACUTURER_CODE_NOT_FOUND));
			 return response;
		}
		for (Object[] manufacturerData : objectList) {
			manufacturerResponse = new ManufacturerResponse();
		    manufacturerResponse.setManufacturerCode(String.valueOf(manufacturerData[0]));
		    manufacturerResponse.setManufacturerDisplayName(String.valueOf(manufacturerData[1]));
		    manufacturerList.add(manufacturerResponse);
		}
		response.setResponseCode(ErrorCode.SUCCESS);
		response.setResponseMessage(ErrorCode.getInstance().getMessage(ErrorCode.SUCCESS));
		response.setResponseList(manufacturerList);
		logger.info("Exiting :: ManufacturerServiceImpl :: fetchManufacturerListBasedOnUserIdAndBankId method");
		return response;
	}

}
