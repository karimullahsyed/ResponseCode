package com.innoviti.quickemitab.model;

/**
 * @author Karim
 *
 */

public class IssuerBinResponse {

	/**
	 * 
	 */

	private Integer issuerBin;

	private String schemeType;

	private String cardType;

	private String isoCountryCode;


	public Integer getIssuerBin() {
		return issuerBin;
	}

	public void setIssuerBin(Integer issuerBin) {
		this.issuerBin = issuerBin;
	}

	public String getSchemeType() {
		return schemeType;
	}

	public void setSchemeType(String schemeType) {
		this.schemeType = schemeType;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getIsoCountryCode() {
		return isoCountryCode;
	}

	public void setIsoCountryCode(String isoCountryCode) {
		this.isoCountryCode = isoCountryCode;
	}


}
