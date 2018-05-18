package com.innoviti.quickemitab.serviceImpl;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.innoviti.quickemitab.model.EmiTxnProcessRequest;
import com.innoviti.quickemitab.model.ErrorCode;
import com.innoviti.quickemitab.model.Response;
import com.innoviti.quickemitab.repository.txn.EmiTxnProcess;
import com.innoviti.quickemitab.repository.txn.EmiTxnProcessRepository;
import com.innoviti.quickemitab.service.EmiTxnProcessService;
import com.innoviti.quickemitab.utils.CommonUtil;

@Service
@Transactional("transactionManager")
public class EmiTxnProcessServiceImpl implements EmiTxnProcessService {
	
	private static Logger logger = LoggerFactory.getLogger(EmiTxnProcessServiceImpl.class);
	
	@Autowired
	private EmiTxnProcessRepository emiTxnProcessRepository;

	@Override
	public Response saveEmiTxnProcessDetails(String jsonEmiTxnProcessRequest,MultipartFile[] files) throws JsonParseException, JsonMappingException, IOException {
		logger.info("Entering :: EmiTxnProcessServiceImpl :: saveEmiTxnProcessDetails method");
		EmiTxnProcessRequest emiTxnProcessRequest = new ObjectMapper().readValue(jsonEmiTxnProcessRequest, EmiTxnProcessRequest.class);
		Response response = new Response();
		if (files != null && files.length > 0) {
			try {
				for (MultipartFile file : files) {
					if (file.getOriginalFilename().contains("signature")) {
						emiTxnProcessRequest.setSignature(file.getBytes());
						logger.info(" saveEmiTxnProcessDetails method :: signature");
					}
					if (file.getOriginalFilename().contains("attachfile")) {
						emiTxnProcessRequest.setChargeSlip(file.getBytes());
						logger.info(" saveEmiTxnProcessDetails method :: attachFile");
					} else if (file.getOriginalFilename().contains("takesnap")) {
						emiTxnProcessRequest.setChargeSlip(file.getBytes());
						logger.info(" saveEmiTxnProcessDetails method :: takeSnap");
					}
				}
			} catch (Exception e) {
				 response.setResponseCode(ErrorCode.ERROR_FAILED_TO_UPLOAD);
				 response.setResponseMessage(ErrorCode.getInstance().getMessage(ErrorCode.ERROR_FAILED_TO_UPLOAD));
				 return response;
			}
		} else {
			 response.setResponseCode(ErrorCode.ERROR_UNABLE_TO_UPLOAD_FILE_IS_EMPTY);
			 response.setResponseMessage(ErrorCode.getInstance().getMessage(ErrorCode.ERROR_UNABLE_TO_UPLOAD_FILE_IS_EMPTY));
			 return response;
		}
		EmiTxnProcess emiTxnProcess = CommonUtil.copyBeanProperties(emiTxnProcessRequest, EmiTxnProcess.class);
		emiTxnProcess.setEmiDetails(CommonUtil.convertObjectToJsonStr(emiTxnProcessRequest.getEmiDetails()));
		emiTxnProcessRepository.save(emiTxnProcess);
		response.setResponseCode(ErrorCode.SUCCESS);
		response.setResponseMessage(ErrorCode.getInstance().getMessage(ErrorCode.SUCCESS));
		logger.info("Exiting  :: EmiTxnProcessServiceImpl :: saveEmiTxnProcessDetails method");
		return response;
	}


}
