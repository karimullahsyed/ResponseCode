package com.innoviti.quickemitab.repository.txn;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "emi_transaction_process")
public class EmiTxnProcess implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "prim_id", nullable = false, unique = true, length = 50)
	private String primId;

	@Column(name = "user_Id", nullable = false, unique = true, length = 20)
	private Integer userId;
	
	@Column(name = "issuer_bank_code", nullable = false, unique = true)
	private Integer issuerBankCode;
	
	@Column(name = "issuer_scheme_code", nullable = false, unique = true)
	private String issuerSchemeCode;
	
	@Column(name = "txn_amount", nullable = false, unique = true)
	private String txnAmount;
	
	@Column(name = "txn_date_time", nullable = false, unique = true)
	private Timestamp  txnDateTime;
	
	@Column(name = "card_holder_name", nullable = false, unique = true)
	private String cardHolderName;
	
	@Column(name = "mobile_no", nullable = false, unique = true)
	private String mobileNo;
		
	@Column(name = "mask_card_number", nullable = false, unique = true)
	private String maskCardNumber;
	
	@Column(name = "encrypted_card_number", nullable = false, unique = true, length = 20)
	private String encryptedCardNumber;
	
	@Column(name = "invoice_number", nullable = false, unique = true)
	private String invoiceNumber;
	
	@Column(name = "approval_code", nullable = false, unique = true)
	private String approvalCode;
	
	@Column(name = "rrn_number", nullable = false, unique = true)
	private String rrnNumber;

	@Column(name = "model_code", nullable = false, unique = true)
	private String modelCode;
	
	@Lob
    @Column(name="signature", nullable=false, columnDefinition="mediumblob")
    private byte[] signature;
	
	@Column(name = "emi_details", nullable = false, unique = true)
	private String emiDetails;

	public String getPrimId() {
		return primId;
	}

	public void setPrimId(String primId) {
		this.primId = primId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getIssuerBankCode() {
		return issuerBankCode;
	}

	public void setIssuerBankCode(Integer issuerBankCode) {
		this.issuerBankCode = issuerBankCode;
	}

	
	public String getIssuerSchemeCode() {
		return issuerSchemeCode;
	}

	public void setIssuerSchemeCode(String issuerSchemeCode) {
		this.issuerSchemeCode = issuerSchemeCode;
	}

	public String getTxnAmount() {
		return txnAmount;
	}

	public void setTxnAmount(String txnAmount) {
		this.txnAmount = txnAmount;
	}


	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getMaskCardNumber() {
		return maskCardNumber;
	}

	public void setMaskCardNumber(String maskCardNumber) {
		this.maskCardNumber = maskCardNumber;
	}

	public String getEncryptedCardNumber() {
		return encryptedCardNumber;
	}

	public void setEncryptedCardNumber(String encryptedCardNumber) {
		this.encryptedCardNumber = encryptedCardNumber;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public String getApprovalCode() {
		return approvalCode;
	}

	public void setApprovalCode(String approvalCode) {
		this.approvalCode = approvalCode;
	}
	
	public Timestamp getTxnDateTime() {
		return txnDateTime;
	}

	public void setTxnDateTime(Timestamp txnDateTime) {
		this.txnDateTime = txnDateTime;
	}

	public String getRrnNumber() {
		return rrnNumber;
	}

	public void setRrnNumber(String rrnNumber) {
		this.rrnNumber = rrnNumber;
	}


	public String getEmiDetails() {
		return emiDetails;
	}

	public void setEmiDetails(String emiDetails) {
		this.emiDetails = emiDetails;
	}

	public byte[] getSignature() {
		return signature;
	}

	public void setSignature(byte[] signature) {
		this.signature = signature;
	}

	public String getModelCode() {
		return modelCode;
	}

	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}
	
}
