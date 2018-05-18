package com.innoviti.quickemitab.dao.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

/**
 * @author Karim
 *
 */
@Embeddable
public class IssuerSchemeModelUserComposite implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "user_id", columnDefinition = "int(10) NOT NULL ")
	private Integer userId;

	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumns({ @JoinColumn(name = "issuer_scheme_model_code") })
	private IssuerSchemeModel issuerSchemeModel;


	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public IssuerSchemeModel getIssuerSchemeModel() {
		return issuerSchemeModel;
	}

	public void setIssuerSchemeModel(IssuerSchemeModel issuerSchemeModel) {
		this.issuerSchemeModel = issuerSchemeModel;
	}

}
