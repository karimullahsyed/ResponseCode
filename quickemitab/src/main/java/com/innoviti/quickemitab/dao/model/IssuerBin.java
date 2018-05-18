package com.innoviti.quickemitab.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Karim
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "issuing_bin")
public class IssuerBin extends AuditColumns {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "issuer_bin", length = 20)
	private Integer issuerBin;

	@Column(name = "scheme_type", length = 12, nullable = false)
	private String schemeType;

	@Column(name = "card_type", length = 12, nullable = false)
	private String cardType;

	@Column(name = "iso_country_code", length = 12, nullable = false)
	private String isoCountryCode;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumns({ @JoinColumn(name = "issuer_bank_code") })
	private IssuerBank issuerBank;

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

	public IssuerBank getIssuerBank() {
		return issuerBank;
	}

	public void setIssuerBank(IssuerBank issuerBank) {
		this.issuerBank = issuerBank;
	}

}
