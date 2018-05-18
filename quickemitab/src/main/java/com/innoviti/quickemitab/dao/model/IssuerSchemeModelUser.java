package com.innoviti.quickemitab.dao.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Karim
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "issuer_scheme_model_user")
public class IssuerSchemeModelUser extends AuditColumns {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private IssuerSchemeModelUserComposite issuerSchemeModelUserComposite;


	public IssuerSchemeModelUserComposite getIssuerSchemeModelUserComposite() {
		return issuerSchemeModelUserComposite;
	}

	public void setIssuerSchemeModelUserComposite(IssuerSchemeModelUserComposite issuerSchemeModelUserComposite) {
		this.issuerSchemeModelUserComposite = issuerSchemeModelUserComposite;
	}

}
