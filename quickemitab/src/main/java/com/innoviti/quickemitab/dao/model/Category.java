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
@Table(name = "categories")
public class Category extends AuditColumns {

 private static final long serialVersionUID = 7189109860461544074L;

  @Id
  @Column(name = "category_code", length = 10)
  private String categoryCode;

  @Column(name = "category_display_name", length = 50, nullable = false)
  private String categoryDisplayName;



  public String getCategoryDisplayName() {
    return categoryDisplayName;
  }

  public void setCategoryDisplayName(String categoryDisplayName) {
    this.categoryDisplayName = categoryDisplayName;
  }
  
  public String getCategoryCode() {
	return categoryCode;
  }

  public void setCategoryCode(String categoryCode) {
	this.categoryCode = categoryCode;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append(categoryCode);
    builder.append("|");
    builder.append(categoryDisplayName);
    return builder.toString();
  }
}
