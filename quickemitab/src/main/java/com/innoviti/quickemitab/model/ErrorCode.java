package com.innoviti.quickemitab.model;

import java.util.HashMap;

public class ErrorCode {

  private static HashMap<String, String> mMessages;

  private static ErrorCode mInstance = null;

  public static final String SUCCESS = "00";

  public static final String ERROR_USER_NOT_FOUND = "01";
  
  public static final String ERROR_BANK_NOT_FOUND = "02";
  
  public static final String ERROR_MANUFACUTURER_CODE_NOT_FOUND = "03";
  
  public static final String ERROR_CATEGORY_CODE_NOT_FOUND = "04";
  
  public static final String ERROR_MODEL_CODE_NOT_FOUND = "05";

  public static final String ERROR_BIN_NOT_FOUND = "06";
  
  public static final String ERROR_EMI_TENURE_NOT_FOUND = "07";
  
  public static final String ERROR_FAILED_TO_UPLOAD = "08";
  
  public static final String ERROR_UNABLE_TO_UPLOAD_FILE_IS_EMPTY = "09";


  public ErrorCode() {
    initMessages();
  }

  /**
   * This method get the message based on code
   * 
   * @param code
   * @return String
   */
  public String getMessage(String code) {
    Object obj = mMessages.get(code);
    String msg = null;
    if(obj != null)
      msg = (String) obj;
    else
      msg = "Unknown Message";
    return msg;
  }

  private void initMessages() {
    mMessages = new HashMap<String, String>(125);
    mMessages.put(SUCCESS, "Success");
    mMessages.put(ERROR_USER_NOT_FOUND, "User not found");
    mMessages.put(ERROR_BANK_NOT_FOUND, "Bank not found");
    mMessages.put(ERROR_MANUFACUTURER_CODE_NOT_FOUND, "Manufacturer code not found");
    mMessages.put(ERROR_CATEGORY_CODE_NOT_FOUND, "Category code not found");
    mMessages.put(ERROR_MODEL_CODE_NOT_FOUND, "Model code not found");
    mMessages.put(ERROR_EMI_TENURE_NOT_FOUND, "Emi Tenure not found");
    mMessages.put(ERROR_BIN_NOT_FOUND, "Bin not found");
    mMessages.put(ERROR_FAILED_TO_UPLOAD, "Failed to upload");
    mMessages.put(ERROR_UNABLE_TO_UPLOAD_FILE_IS_EMPTY, "Unable to upload. File is empty");
   
  }

  /**
   * Returns the singleton instance.
   * 
   * @return the singleton instance
   */
  public static final synchronized ErrorCode getInstance() {
    if(mInstance == null) {
      mInstance = new ErrorCode();
    }
    return mInstance;
  }

}
