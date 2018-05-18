package com.innoviti.quickemitab.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.innoviti.quickemitab.dao.model.IssuerBin;
import com.innoviti.quickemitab.dao.model.IssuerSchemeModelUser;
import com.innoviti.quickemitab.model.ErrorCode;
import com.innoviti.quickemitab.model.IssuerBankResponse;
import com.innoviti.quickemitab.model.Response;
import com.innoviti.quickemitab.repository.config.IssuerBinRepository;
import com.innoviti.quickemitab.repository.config.IssuerSchemeModelUserRepository;
import com.innoviti.quickemitab.service.IssuerBankService;

@Service
@Transactional("configManager")
public class IssuerBankServiceImpl implements IssuerBankService {
	
	private static Logger logger = LoggerFactory.getLogger(IssuerBankServiceImpl.class);

	@Autowired
	private IssuerSchemeModelUserRepository issuerSchemeModelUserRepository;
	
	@Autowired
	private IssuerBinRepository issuerBinRepository;
	
	@Override
	public Response findByuserId(Integer userId) {
		logger.info("Entering :: IssuerBankServiceImpl :: findByuserId method");
		List<IssuerSchemeModelUser> issuerSchemeModelUserList = null;
		Response response = new Response();
		IssuerBankResponse issuerBankResponse = null;
		List<IssuerBankResponse> issuerBankList =  new ArrayList<>();
		issuerSchemeModelUserList = issuerSchemeModelUserRepository.findByIssuerSchemeModelUserCompositeUserId(userId);
		if(issuerSchemeModelUserList.isEmpty()) {
			 response.setResponseCode(ErrorCode.ERROR_BANK_NOT_FOUND);
			 response.setResponseMessage(ErrorCode.getInstance().getMessage(ErrorCode.ERROR_BANK_NOT_FOUND));
			 return response;
		}
		for(IssuerSchemeModelUser issuerSchemeModelUser : issuerSchemeModelUserList) {
			issuerBankResponse = new IssuerBankResponse();
			issuerBankResponse.setIssuerBankCode(issuerSchemeModelUser.getIssuerSchemeModelUserComposite().getIssuerSchemeModel().getIssuerScheme().getIssuerBank().getIssuerBankCode());
			issuerBankResponse.setIssuerBankDisplayName(issuerSchemeModelUser.getIssuerSchemeModelUserComposite().getIssuerSchemeModel().getIssuerScheme().getIssuerBank().getIssuerBankDisplayName());
			issuerBankResponse.setIssuerMinEmiAmount(issuerSchemeModelUser.getIssuerSchemeModelUserComposite().getIssuerSchemeModel().getIssuerScheme().getIssuerBank().getIssuerMinEmiAmount());
			issuerBankList.add(issuerBankResponse);
		}
		response.setResponseCode(ErrorCode.SUCCESS);
		response.setResponseMessage(ErrorCode.getInstance().getMessage(ErrorCode.SUCCESS));
		response.setResponseList(issuerBankList);
		logger.info("Exiting :: IssuerBankServiceImpl :: findByuserId method");
		return response;
	}

	@Override
	public Response findByIssuerBin(Integer issuerBinNo,Integer issuerBankCode) {
		logger.info("Entering :: IssuerBankServiceImpl :: findByIssuerBin method");
		Response response = new Response();
		IssuerBin issuerBin = issuerBinRepository.validateBin(issuerBinNo,issuerBankCode);
		if (issuerBin == null) {
			 response.setResponseCode(ErrorCode.ERROR_BIN_NOT_FOUND);
			 response.setResponseMessage(ErrorCode.getInstance().getMessage(ErrorCode.ERROR_BIN_NOT_FOUND));
			 return response;
		}
		response.setResponseCode(ErrorCode.SUCCESS);
		response.setResponseMessage(ErrorCode.getInstance().getMessage(ErrorCode.SUCCESS));
		logger.info("Exiting  :: IssuerBankServiceImpl :: findByIssuerBin method");
		return response;
	}

}
