package com.innoviti.quickemitab.dao.model;

import javax.persistence.CascadeType;
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
@Table(name = "issuer_scheme_model")
public class IssuerSchemeModel extends AuditColumns {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "issuer_scheme_model_code", length = 50)
	private String issuerSchemeModelCode;

	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = { CascadeType.MERGE, CascadeType.PERSIST,CascadeType.REFRESH })
	@JoinColumns({ @JoinColumn(name = "issuer_scheme_code") })
	private IssuerScheme issuerScheme;

	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumns({ @JoinColumn(name = "model_code") })
	private Model model;

	public String getIssuerSchemeModelCode() {
		return issuerSchemeModelCode;
	}

	public void setIssuerSchemeModelCode(String issuerSchemeModelCode) {
		this.issuerSchemeModelCode = issuerSchemeModelCode;
	}

	public IssuerScheme getIssuerScheme() {
		return issuerScheme;
	}

	public void setIssuerScheme(IssuerScheme issuerScheme) {
		this.issuerScheme = issuerScheme;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

}
