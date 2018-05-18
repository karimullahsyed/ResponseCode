package com.innoviti.quickemitab.model;

/**
 * @author Karim
 *
 */

public class EmiTenureRequest {

	private String emiTenureCode;

	private String emiTenureDisplayName;

	private String emiTenureMonth;
	
	private Double actualTxnAmount;

	private Integer issuerBankCode;

	private String advancedEmi;
	
	private String issuerSchemeProcessingFees;
	
	private String issuerRateOfInterest;

	private String cashBack;
	
	private String issuerDefaultCashbackFlag;
	
	private String issuerDisplayName;
	
	private Double emiCalculatedTxnAmount;
	
	private String issuerSchemeCode;
	
	private String modelCode;
	


	public String getIssuerSchemeCode() {
		return issuerSchemeCode;
	}

	public void setIssuerSchemeCode(String issuerSchemeCode) {
		this.issuerSchemeCode = issuerSchemeCode;
	}

	public Integer getIssuerBankCode() {
		return issuerBankCode;
	}

	public void setIssuerBankCode(Integer issuerBankCode) {
		this.issuerBankCode = issuerBankCode;
	}

	public Double getEmiCalculatedTxnAmount() {
		return emiCalculatedTxnAmount;
	}

	public void setEmiCalculatedTxnAmount(Double emiCalculatedTxnAmount) {
		this.emiCalculatedTxnAmount = emiCalculatedTxnAmount;
	}

	public String getEmiTenureCode() {
		return emiTenureCode;
	}

	public void setEmiTenureCode(String emiTenureCode) {
		this.emiTenureCode = emiTenureCode;
	}


	public String getEmiTenureDisplayName() {
		return emiTenureDisplayName;
	}

	public void setEmiTenureDisplayName(String emiTenureDisplayName) {
		this.emiTenureDisplayName = emiTenureDisplayName;
	}

	public String getEmiTenureMonth() {
		return emiTenureMonth;
	}

	public void setEmiTenureMonth(String emiTenureMonth) {
		this.emiTenureMonth = emiTenureMonth;
	}

	public String getIssuerRateOfInterest() {
		return issuerRateOfInterest;
	}

	public void setIssuerRateOfInterest(String issuerRateOfInterest) {
		this.issuerRateOfInterest = issuerRateOfInterest;
	}


	public String getCashBack() {
		return cashBack;
	}

	public void setCashBack(String cashBack) {
		this.cashBack = cashBack;
	}


	public String getAdvancedEmi() {
		return advancedEmi;
	}

	public void setAdvancedEmi(String advancedEmi) {
		this.advancedEmi = advancedEmi;
	}

	public String getIssuerSchemeProcessingFees() {
		return issuerSchemeProcessingFees;
	}

	public void setIssuerSchemeProcessingFees(String issuerSchemeProcessingFees) {
		this.issuerSchemeProcessingFees = issuerSchemeProcessingFees;
	}

	public String getIssuerDefaultCashbackFlag() {
		return issuerDefaultCashbackFlag;
	}

	public void setIssuerDefaultCashbackFlag(String issuerDefaultCashbackFlag) {
		this.issuerDefaultCashbackFlag = issuerDefaultCashbackFlag;
	}

	public String getIssuerDisplayName() {
		return issuerDisplayName;
	}

	public void setIssuerDisplayName(String issuerDisplayName) {
		this.issuerDisplayName = issuerDisplayName;
	}

	public Double getActualTxnAmount() {
		return actualTxnAmount;
	}

	public void setActualTxnAmount(Double actualTxnAmount) {
		this.actualTxnAmount = actualTxnAmount;
	}

	public String getModelCode() {
		return modelCode;
	}

	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}
	
}
