package com.innoviti.quickemitab.model;

/**
 * @author Karim
 *
 */

public class IssuerBankResponse {

	private Integer issuerBankCode;

	private String issuerBankDisplayName;

	private String issuerMinEmiAmount;

	public String getIssuerBankDisplayName() {
		return issuerBankDisplayName;
	}

	public void setIssuerBankDisplayName(String issuerBankDisplayName) {
		this.issuerBankDisplayName = issuerBankDisplayName;
	}

	public Integer getIssuerBankCode() {
		return issuerBankCode;
	}

	public void setIssuerBankCode(Integer issuerBankCode) {
		this.issuerBankCode = issuerBankCode;
	}

	public String getIssuerMinEmiAmount() {
		return issuerMinEmiAmount;
	}

	public void setIssuerMinEmiAmount(String issuerMinEmiAmount) {
		this.issuerMinEmiAmount = issuerMinEmiAmount;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("|");
		builder.append(issuerBankDisplayName);
		builder.append("|");
		builder.append(issuerMinEmiAmount);
		return builder.toString();
	}

}
