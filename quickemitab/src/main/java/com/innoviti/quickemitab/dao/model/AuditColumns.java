package com.innoviti.quickemitab.dao.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AuditColumns implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "is_active", nullable = true)
	private String isActive;

	@Column(name = "crtupd_user", columnDefinition = "varchar(32)", nullable = true)
	private String crtupdUser;

	@Column(name = "crtupd_dt", nullable = true)
	private Date crtupdDate;


	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getCrtupdUser() {
		return crtupdUser;
	}

	public void setCrtupdUser(String crtupdUser) {
		this.crtupdUser = crtupdUser;
	}

	public Date getCrtupdDate() {
		return crtupdDate;
	}

	public void setCrtupdDate(Date crtupdDate) {
		this.crtupdDate = crtupdDate;
	}

}
