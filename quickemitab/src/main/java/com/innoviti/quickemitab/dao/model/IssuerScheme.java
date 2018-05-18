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
@Table(name = "issuer_schemes")
public class IssuerScheme extends AuditColumns {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "issuer_scheme_code", length = 10)
	private String IssuerSchemeCode;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumns({ @JoinColumn(name = "issuer_bank_code") })
	private IssuerBank issuerBank;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumns({ @JoinColumn(name = "emi_tenure_code") })
	private EmiTenure emiTenure;

	@Column(name = "issuer_scheme_display_name", length = 50, nullable = false)
	private String schemeDisplayName;

	@Column(name = "issuer_scheme_processing_fees", length = 10)
	private String processingFees;

	@Column(name = "advance_emi", length = 6)
	private String advanceEmi;

	@Column(name = "issuer_rate_of_interest", length = 10)
	private String issuerRateOfInterest;

	@Column(name = "cashback", length = 10)
	private String cashback;

	public String getIssuerSchemeCode() {
		return IssuerSchemeCode;
	}

	public void setIssuerSchemeCode(String issuerSchemeCode) {
		IssuerSchemeCode = issuerSchemeCode;
	}

	public IssuerBank getIssuerBank() {
		return issuerBank;
	}

	public void setIssuerBank(IssuerBank issuerBank) {
		this.issuerBank = issuerBank;
	}

	public EmiTenure getEmiTenure() {
		return emiTenure;
	}

	public void setEmiTenure(EmiTenure emiTenure) {
		this.emiTenure = emiTenure;
	}

	public String getSchemeDisplayName() {
		return schemeDisplayName;
	}

	public void setSchemeDisplayName(String schemeDisplayName) {
		this.schemeDisplayName = schemeDisplayName;
	}

	public String getProcessingFees() {
		return processingFees;
	}

	public void setProcessingFees(String processingFees) {
		this.processingFees = processingFees;
	}

	public String getAdvanceEmi() {
		return advanceEmi;
	}

	public void setAdvanceEmi(String advanceEmi) {
		this.advanceEmi = advanceEmi;
	}

	public String getIssuerRateOfInterest() {
		return issuerRateOfInterest;
	}

	public void setIssuerRateOfInterest(String issuerRateOfInterest) {
		this.issuerRateOfInterest = issuerRateOfInterest;
	}

	public String getCashback() {
		return cashback;
	}

	public void setCashback(String cashback) {
		this.cashback = cashback;
	}

}
