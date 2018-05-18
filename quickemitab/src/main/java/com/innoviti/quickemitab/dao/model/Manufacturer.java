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
@Table(name = "manufacturers")
public class Manufacturer extends AuditColumns {

	private static final long serialVersionUID = 9215534492376635255L;

	@Id
	@Column(name = "manufacture_code", length = 20)
	private String manufacturerCode;

	@Column(name = "manufacture_display_name", length = 50, nullable = false)
	private String manufacturerDisplayName;

	public String getManufacturerCode() {
		return manufacturerCode;
	}

	public void setManufacturerCode(String manufacturerCode) {
		this.manufacturerCode = manufacturerCode;
	}

	public String getManufacturerDisplayName() {
		return manufacturerDisplayName;
	}

	public void setManufacturerDisplayName(String manufacturerDisplayName) {
		this.manufacturerDisplayName = manufacturerDisplayName;
	}

}
