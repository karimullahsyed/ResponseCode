package com.innoviti.quickemitab.model;

/**
 * @author Karim
 *
 */

public class EmiTenureResponse {

	private String emiTenureCode;

	private String emiTenureDisplayName;

	private String emiTenureMonth;

	private String productPrice;

	private String issuerRateOfInterest;
	
	private String montlyInstallments;
	
	private String issuerSchemeProcessingFee;
	
	private String TotalInterestAmount;

	private String cashBackAmount;

	private String finalPayout;	
	
	private String issuerSchemeCode;
	
	private Integer issuerBankCode;
	
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

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
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

	public String getIssuerSchemeProcessingFee() {
		return issuerSchemeProcessingFee;
	}

	public void setIssuerSchemeProcessingFee(String issuerSchemeProcessingFee) {
		this.issuerSchemeProcessingFee = issuerSchemeProcessingFee;
	}

	public String getIssuerRateOfInterest() {
		return issuerRateOfInterest;
	}

	public void setIssuerRateOfInterest(String issuerRateOfInterest) {
		this.issuerRateOfInterest = issuerRateOfInterest;
	}

	public String getCashBackAmount() {
		return cashBackAmount;
	}

	public void setCashBackAmount(String cashBackAmount) {
		this.cashBackAmount = cashBackAmount;
	}


	public String getMontlyInstallments() {
		return montlyInstallments;
	}

	public void setMontlyInstallments(String montlyInstallments) {
		this.montlyInstallments = montlyInstallments;
	}

	public String getTotalInterestAmount() {
		return TotalInterestAmount;
	}

	public void setTotalInterestAmount(String totalInterestAmount) {
		TotalInterestAmount = totalInterestAmount;
	}

	public String getFinalPayout() {
		return finalPayout;
	}
	
	public void setFinalPayout(String finalPayout) {
		this.finalPayout = finalPayout;
	}

	public String getModelCode() {
		return modelCode;
	}

	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}
	
}
