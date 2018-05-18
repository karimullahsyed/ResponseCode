package com.innoviti.quickemitab.model;

/**
 * @author Karim
 *
 */
public class CategoryResponse {

  private String categoryCode;

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
