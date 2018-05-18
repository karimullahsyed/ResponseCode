package com.innoviti.quickemitab.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Karim
 *
 */
@Entity
@Table(name = "issuer_banks")
@JsonIgnoreProperties(ignoreUnknown = true)
public class IssuerBank extends AuditColumns {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "issuer_bank_code", columnDefinition = "INT(5)", nullable = false)
	private Integer issuerBankCode;

	@Column(name = "issuer_bank_display_name", nullable = false, length = 50)
	private String issuerBankDisplayName;

	@Column(name = "issuer_min_emi_amount", precision = 10, scale = 2)
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
