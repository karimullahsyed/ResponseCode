package com.innoviti.quickemitab.model;

import java.sql.Timestamp;

public class EmiTxnProcessRequest {

	private String primId;

	private Integer userId;
	
	private Integer issuerBankCode;
	
	private String issuerSchemeCode;
	
	private String modelCode;
	
	private String txnAmount;
	
	private Timestamp  txnDateTime;
	
	private String cardHolderName;
	
	private String mobileNo;
		
	private String maskCardNumber;
	
	private String encryptedCardNumber;
	
	private String invoiceNumber;
	
	private String approvalCode;
	
	private String rrnNumber;
	
	private EmiDetails emiDetails;
	
	private byte[] signature;
	
	private byte[] chargeSlip;
	
	private String termsAndConditions;
	
	
	public String getPrimId() {
		return primId;
	}

	public void setPrimId(String primId) {
		this.primId = primId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getIssuerBankCode() {
		return issuerBankCode;
	}

	public void setIssuerBankCode(Integer issuerBankCode) {
		this.issuerBankCode = issuerBankCode;
	}


	public String getIssuerSchemeCode() {
		return issuerSchemeCode;
	}

	public void setIssuerSchemeCode(String issuerSchemeCode) {
		this.issuerSchemeCode = issuerSchemeCode;
	}

	public String getTxnAmount() {
		return txnAmount;
	}

	public void setTxnAmount(String txnAmount) {
		this.txnAmount = txnAmount;
	}


	public Timestamp getTxnDateTime() {
		return txnDateTime;
	}

	public void setTxnDateTime(Timestamp txnDateTime) {
		this.txnDateTime = txnDateTime;
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getMaskCardNumber() {
		return maskCardNumber;
	}

	public void setMaskCardNumber(String maskCardNumber) {
		this.maskCardNumber = maskCardNumber;
	}

	public String getEncryptedCardNumber() {
		return encryptedCardNumber;
	}

	public void setEncryptedCardNumber(String encryptedCardNumber) {
		this.encryptedCardNumber = encryptedCardNumber;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public String getApprovalCode() {
		return approvalCode;
	}

	public void setApprovalCode(String approvalCode) {
		this.approvalCode = approvalCode;
	}
	

	public String getRrnNumber() {
		return rrnNumber;
	}

	public void setRrnNumber(String rrnNumber) {
		this.rrnNumber = rrnNumber;
	}

	public EmiDetails getEmiDetails() {
		return emiDetails;
	}

	public void setEmiDetails(EmiDetails emiDetails) {
		this.emiDetails = emiDetails;
	}

	public byte[] getSignature() {
		return signature;
	}

	public void setSignature(byte[] signature) {
		this.signature = signature;
	}


	public byte[] getChargeSlip() {
		return chargeSlip;
	}

	public void setChargeSlip(byte[] chargeSlip) {
		this.chargeSlip = chargeSlip;
	}

	public String getTermsAndConditions() {
		return termsAndConditions;
	}

	public void setTermsAndConditions(String termsAndConditions) {
		this.termsAndConditions = termsAndConditions;
	}

	public String getModelCode() {
		return modelCode;
	}

	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}
}
