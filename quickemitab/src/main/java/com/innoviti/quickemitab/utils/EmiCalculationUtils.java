package com.innoviti.quickemitab.utils;

import java.text.DecimalFormat;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.innoviti.quickemitab.constants.QuickEmiTabConstant;
import com.innoviti.quickemitab.model.EmiTenureRequest;
import com.innoviti.quickemitab.model.EmiTenureResponse;

public class EmiCalculationUtils {
	
	private static Logger logger = LoggerFactory.getLogger(EmiCalculationUtils.class);

	public static boolean calculateEmiProcessingFee(EmiTenureRequest emiTenureRequest,EmiTenureResponse emiTenureResponse) {
		logger.info("Entering :: EmiCalculationUtils :: calculateEmiProcessingFee method");
		boolean isProcessingFeeCalculationCompleted = false;
		double emiSaleTxnAmount = emiTenureRequest.getActualTxnAmount();
		try {
			String displayCalculatedProcessingAmt = "0.00";
			
			String issuerSchemeProcessingFees = emiTenureRequest.getIssuerSchemeProcessingFees().trim();
			
			double calculateProcessingFeeAmount = 0.00;
			
			logger.info("Calculate Processing Fee - getProcessingFeeDetail: " + issuerSchemeProcessingFees);

			if (StringUtils.isNotBlank(issuerSchemeProcessingFees) && !issuerSchemeProcessingFees.isEmpty()) {
				if (StringUtils.isNotBlank(issuerSchemeProcessingFees) && issuerSchemeProcessingFees.contains(QuickEmiTabConstant.EMI_PERCENTAGE)) {
					Double processingFeePercentage = Double.parseDouble((issuerSchemeProcessingFees.replaceAll(QuickEmiTabConstant.EMI_PERCENTAGE, "")).trim());
					if (processingFeePercentage > 0) {
						calculateProcessingFeeAmount = (emiSaleTxnAmount) * (processingFeePercentage) / 10000;
					}
				} else if (issuerSchemeProcessingFees.contains(QuickEmiTabConstant.EMI_FLAT)) {
					Double processingFeeFlat = Double.parseDouble((issuerSchemeProcessingFees.replaceAll(QuickEmiTabConstant.EMI_FLAT, "")).trim());
					if (processingFeeFlat > 0) {
						calculateProcessingFeeAmount = processingFeeFlat;
					}
				}
				displayCalculatedProcessingAmt = getAmtWithTwoDecimal(calculateProcessingFeeAmount);
			}
			double calculatingProductDisplayAmount = emiSaleTxnAmount/100;
			emiTenureResponse.setProductPrice(String.valueOf(getAmtWithTwoDecimal(calculatingProductDisplayAmount)));
			emiTenureResponse.setIssuerSchemeProcessingFee(displayCalculatedProcessingAmt);
			logger.info("Calculated Processing Fee: " + displayCalculatedProcessingAmt);
			isProcessingFeeCalculationCompleted = true;
		} catch (Exception ex) {
			isProcessingFeeCalculationCompleted = false;
			logger.error("     " + ex);
		}
		logger.info("Exiting :: EmiCalculationUtils :: calculateEmiProcessingFee method");
		return isProcessingFeeCalculationCompleted;
	}

	public static boolean calculateEmiCashbackAmount(EmiTenureRequest emiTenureRequest,EmiTenureResponse emiTenureResponse) {
		logger.info("Entering :: EmiCalculationUtils :: calculateEmiCashbackAmount method");
		boolean isCashbackCalculationCompleted = false;
		double emiSaleTxnAmount = emiTenureRequest.getActualTxnAmount();
		try {
			String displayCaluculatedCashbackAmount = "0.00";
			String issuerDefaultCashbackFlag = emiTenureRequest.getIssuerDefaultCashbackFlag();
			double calculateCashbackAmount = 0.00;
			
			double calculateCashbackPerc = 0.00;
			String configCashback = emiTenureRequest.getCashBack();//or 10.00F
			
			/*
			 * CASHBACK FLAG info: Cashback flag "0" or "PRE" Cashback: If bank
			 * wants to calculate interest rate on discounted amount (base
			 * transaction amount - cashback amount). Cashback flag "1" or
			 * "POST" Cashback: If bank wants to calculate interest rate on base
			 * transaction amount.
			 */
			if (StringUtils.isNotBlank(issuerDefaultCashbackFlag) && (configCashback.contains(QuickEmiTabConstant.EMI_FLAT) || (configCashback.contains(QuickEmiTabConstant.EMI_PERCENTAGE)))){
				logger.info("Calculate Cashback - getCashBackFlagDetail: " + issuerDefaultCashbackFlag);
				
				if (configCashback.contains(QuickEmiTabConstant.EMI_FLAT)) {
					calculateCashbackAmount = Double.parseDouble(configCashback.replace(QuickEmiTabConstant.EMI_FLAT, ""));
				} else if (configCashback.contains(QuickEmiTabConstant.EMI_PERCENTAGE)) {
					calculateCashbackPerc = Double.parseDouble(configCashback.replace(QuickEmiTabConstant.EMI_PERCENTAGE, ""));
					calculateCashbackAmount = (Math.round(calculateCashbackPerc * emiSaleTxnAmount) / 100);
					calculateCashbackAmount = (calculateCashbackAmount) / 100;
					//displayCashbackOnReceipt = Double.toString(calculateCashbackPerc);
					logger.info("Calculated Cashback Perc: " + calculateCashbackPerc);
				}
				
				if (calculateCashbackAmount > 0 && 
						(QuickEmiTabConstant.EMI_CASHBACK_FLAG_ZERO.equalsIgnoreCase(issuerDefaultCashbackFlag) || QuickEmiTabConstant.EMI_CASHBACK_FLAG_PRE.equalsIgnoreCase(issuerDefaultCashbackFlag))) {
					emiSaleTxnAmount = emiSaleTxnAmount - calculateCashbackAmount * 100;
				}
                   
				/*if ((configCashback.contains(EmiSolutionConstant.EMI_FLAT) && calculateCashbackAmount == 0) ||  configCashback.contains(EmiSolutionConstant.EMI_PERCENTAGE)) {
					//displayCashbackOnReceipt
				}*/
				
				displayCaluculatedCashbackAmount = getAmtWithTwoDecimal(calculateCashbackAmount);
			}
			emiTenureRequest.setEmiCalculatedTxnAmount(emiSaleTxnAmount);
			emiTenureResponse.setCashBackAmount(displayCaluculatedCashbackAmount);
			logger.info("Calculated Cashback Amount: " + displayCaluculatedCashbackAmount+ ", Check Txn Amount after Cashback: saleTxnAmount: "+ getAmtWithTwoDecimal(emiSaleTxnAmount / 100));
			isCashbackCalculationCompleted = true;
		} catch (Exception ex) {
			isCashbackCalculationCompleted = false;
			logger.error(""+ex);
		}
		logger.info("Exiting :: EmiCalculationUtils :: calculateEmiCashbackAmount method");
		return isCashbackCalculationCompleted;
	}

	public static boolean calculateEmiAmountAndInterestAmount(EmiTenureRequest emiTenureRequest,EmiTenureResponse emiTenureResponse) {
		logger.info("Entering :: EmiCalculationUtils :: calculateEmiAmountAndInterestAmount method");
		boolean isEmiCalculationCompleted = false;
		double emiSaleTxnAmount = emiTenureRequest.getEmiCalculatedTxnAmount();
		try {
			String displayInterestRate = "0.00";
			String displayInterestAmount = "0.00";
			String displayEmiAmount = "0.00";
			String displayAdvanceEmiOnReceipt = "0";
			String displayAdvanceEmiAmountOnReceipt = "0.00";
			double calculateAdvanceEmiAmount = 0.00;
			double calculateEmiAmount = 0.00;
			double getAnnualInterestRateDetail = Double.parseDouble(emiTenureRequest.getIssuerRateOfInterest().trim());
			double calculateInterestAmount = 0.00;
			int advanceEmiDetail = 0;
			int getTenureMonth = Integer.parseInt(emiTenureRequest.getEmiTenureMonth().trim());
			String getTenureDisplayName = emiTenureRequest.getEmiTenureDisplayName().trim();
			
			logger.info("Calculate EmiAmount and InterestAmount:getAnnualInterestRateDetail: " + getAnnualInterestRateDetail+ ", getTenureMonth: " + getTenureMonth);
			
			if (StringUtils.isNotBlank(String.valueOf(getAnnualInterestRateDetail)) && getAnnualInterestRateDetail > 0) {
				// EMI= (P * R/12) * [ (1+R/12)^N] / [ (1+R/12)^N-1] Formula
				calculateEmiAmount = ((emiSaleTxnAmount * getAnnualInterestRateDetail/(12*100)) * (((Math.pow((1+getAnnualInterestRateDetail/(12*100)),getTenureMonth)))/ ((Math.pow((1+getAnnualInterestRateDetail/(12*100)),getTenureMonth))-1)));
				calculateEmiAmount = calculateEmiAmount / 100;
				displayInterestRate = String.valueOf(getAmtWithTwoDecimal(getAnnualInterestRateDetail));
				displayEmiAmount = String.valueOf(getAmtWithTwoDecimal(calculateEmiAmount));
				calculateInterestAmount = calculateEmiAmount * getTenureMonth - emiSaleTxnAmount / 100;
				displayInterestAmount = String.valueOf(getAmtWithTwoDecimal(calculateInterestAmount));
				
				if (StringUtils.isNotBlank(String.valueOf(calculateEmiAmount)) && calculateEmiAmount > 0) {
					advanceEmiDetail = Integer.parseInt(emiTenureRequest.getAdvancedEmi());
					calculateAdvanceEmiAmount = advanceEmiDetail * calculateEmiAmount;
					displayAdvanceEmiAmountOnReceipt = getAmtWithTwoDecimal(calculateAdvanceEmiAmount);
				}
			} else {
				logger.error("Emi Configuration (annualInterestRate) is missing:isEmiCalculationCompleted: "+ isEmiCalculationCompleted);
				return isEmiCalculationCompleted;
			}
			logger.info("Tenure name: " + getTenureDisplayName + ", Emi Amount: " + displayEmiAmount+ ", Interest Amount: " + displayInterestAmount + ", Advance Emi: "
							+ displayAdvanceEmiOnReceipt + ", Advance Emi Amount: " + displayAdvanceEmiAmountOnReceipt);
			
			emiTenureResponse.setEmiTenureCode(emiTenureRequest.getEmiTenureCode());
			emiTenureResponse.setEmiTenureMonth(emiTenureRequest.getEmiTenureMonth());
			emiTenureResponse.setEmiTenureDisplayName(getTenureDisplayName);
			emiTenureResponse.setIssuerRateOfInterest(displayInterestRate +"%");
			emiTenureResponse.setMontlyInstallments(displayEmiAmount);
			emiTenureResponse.setTotalInterestAmount(displayInterestAmount);
			isEmiCalculationCompleted = true;
		} catch (Exception ex) {
			isEmiCalculationCompleted = false;
			logger.error("", ex);
		}
		logger.info("Exiting :: EmiCalculationUtils :: calculateEmiAmountAndInterestAmount method");
		return isEmiCalculationCompleted;
	}

	public static boolean calculateLoanAmount(EmiTenureRequest emiTenureRequest,EmiTenureResponse emiTenureResponse) {
		logger.info("Entering :: EmiCalculationUtils :: calculateLoanAmount method");
		boolean isLoanAmountCalculationCompleted = false;
		double emiSaleTxnAmount = emiTenureRequest.getActualTxnAmount();
		try {
			String displayLoanAmount = "0.00";
			double calculateLoanAmount = 0.00;
			calculateLoanAmount = emiSaleTxnAmount / 100;
			displayLoanAmount = getAmtWithTwoDecimal(calculateLoanAmount);
			logger.info("displayLoanAmountOnReceipt: " + displayLoanAmount);
			
			String displayTotalAmt = "0.00";
			String displayInterestAmount = emiTenureResponse.getTotalInterestAmount(); 
			double calculateProcAmount = Double.parseDouble(emiTenureResponse.getIssuerSchemeProcessingFee());
			double calculateInterestAmount = Double.parseDouble(displayInterestAmount);
			if (StringUtils.isNotBlank(displayInterestAmount) && !(displayInterestAmount.isEmpty())&& Double.parseDouble(displayInterestAmount) > 0) {
				Double subTotalAmt = calculateLoanAmount + calculateProcAmount + calculateInterestAmount;
				displayTotalAmt = getAmtWithTwoDecimal(subTotalAmt);
				logger.info("displayTotalAmtOnEmiReceipt1: " + displayTotalAmt);
			} else if (calculateProcAmount > 0) {
				Double subTotalAmt = calculateLoanAmount + calculateProcAmount;
				displayTotalAmt = getAmtWithTwoDecimal(subTotalAmt);
				logger.info("displayTotalAmtOnEmiReceipt2: " + displayTotalAmt);
			} else {
				displayTotalAmt = getAmtWithTwoDecimal(calculateLoanAmount);
				logger.info("displayTotalAmtOnEmiReceipt3: " + displayTotalAmt);
			}
            emiTenureResponse.setFinalPayout(displayTotalAmt);
			isLoanAmountCalculationCompleted = true;
		} catch (Exception ex) {
			isLoanAmountCalculationCompleted = false;
			logger.error(""+ex);
		}
		logger.info("Exiting :: EmiCalculationUtils :: calculateLoanAmount method");
		return isLoanAmountCalculationCompleted;
	}

	/*public static boolean preparedEmiChargeSlip(TransactionProcess transactionProcess) {
		boolean isEmiChargePrepared = false;
		try {
			if (transactionProcess.isBrandEmi()) {
				transactionProcess.getEmiChargeSlipModel().setEmiReceiptManufacturerName(
						transactionProcess.getManufacturers().getManufacturerDisplayName());
				transactionProcess.getEmiChargeSlipModel()
						.setEmiReceiptCategoryName(transactionProcess.getCategories().getCategoryDisplayName());
				transactionProcess.getEmiChargeSlipModel()
						.setEmiReceiptModelName(transactionProcess.getModels().getModelDisplayNumber());
				logger.info(transactionProcess.getPrimId(),
						"Manufacturer : " + transactionProcess.getManufacturers().getManufacturerDisplayName()
								+ "Category : " + transactionProcess.getCategories().getCategoryDisplayName()
								+ "Model : " + transactionProcess.getModels().getModelDisplayNumber());
			}

			transactionProcess.setEmiChargeSlipModel(transactionProcess.getEmiChargeSlipModel());
			String emiConsentReceiptData = EmiChargeSlipUtils.generateAllBankEmiSaleChargeSlip(transactionProcess);
			if (StringUtils.isBlank(emiConsentReceiptData)) {
				logger.error(transactionProcess.getPrimId(),
						"Unable to generate Emi Charge slip: isEmiChargePrepared: " + isEmiChargePrepared);
				return isEmiChargePrepared;
			}
			transactionProcess.setEmiChargeSlip(emiConsentReceiptData);
			logger.info(transactionProcess.getPrimId(), "Generated Emi Charge slip format: " + emiConsentReceiptData);
			isEmiChargePrepared = true;
		} catch (Exception ex) {
			isEmiChargePrepared = false;
			transactionProcess.setBiResCode(ResponseCodesEnums.TECHNICAL_ERROR);
			logger.printExceptionStackTrace(transactionProcess.getPrimId(), ex);
		}
		return isEmiChargePrepared;
	}
*/
	
	public static String getAmtWithTwoDecimal(double value) {
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(value).trim();
	}
	
	  public static String getFormated12DigitsAmount(String amount) {
			int i = 12-amount.length();
			String formatedAmount = amount;
			for(int c=0; c<i; c++){
				formatedAmount = "0"+formatedAmount; //$NON-NLS-1$
			}
			return formatedAmount;
		}

}
