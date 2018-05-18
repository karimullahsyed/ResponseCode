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
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "emi_tenures")
public class EmiTenure extends AuditColumns {

	private static final long serialVersionUID = -8941727360454380576L;

	@Id
	@Column(name = "emi_tenure_code", length = 5)
	private String emiTenureCode;

	@Column(name = "emi_tenure_display_name", length = 50, nullable = false)
	private String tenureDisplayName;
	
	@Column(name = "emi_tenure_months", length = 5)
	private String tenureMonth;


	public String getEmiTenureCode() {
		return emiTenureCode;
	}

	public void setEmiTenureCode(String emiTenureCode) {
		this.emiTenureCode = emiTenureCode;
	}

	public String getTenureMonth() {
		return tenureMonth;
	}

	public void setTenureMonth(String tenureMonth) {
		this.tenureMonth = tenureMonth;
	}

	public String getTenureDisplayName() {
		return tenureDisplayName;
	}

	public void setTenureDisplayName(String tenureDisplayName) {
		this.tenureDisplayName = tenureDisplayName;
	}

}
