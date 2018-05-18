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
@Table(name = "models")
public class Model extends AuditColumns {

	private static final long serialVersionUID = 18578505163227944L;

	@Id
	@Column(name = "model_code", nullable = true, length = 20)
	private String modelCode;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumns({ @JoinColumn(name = "manufacture_code") })
	private Manufacturer manufacturer;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumns({ @JoinColumn(name = "category_code") })
	private Category category;

	@Column(name = "model_display_name", nullable = true, length = 20)
	private String modelDisplayName;

	public String getModelCode() {
		return modelCode;
	}

	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getModelDisplayName() {
		return modelDisplayName;
	}

	public void setModelDisplayName(String modelDisplayName) {
		this.modelDisplayName = modelDisplayName;
	}

}
