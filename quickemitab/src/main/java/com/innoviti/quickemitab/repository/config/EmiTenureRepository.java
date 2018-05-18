package com.innoviti.quickemitab.repository.config;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.innoviti.quickemitab.dao.model.EmiTenure;

/**
 * @author Karim
 *
 */
public interface EmiTenureRepository  extends BaseRepository<EmiTenure, Integer> {
	

	@Query(value="SELECT G.emi_tenure_code,G.emi_tenure_display_name,G.emi_tenure_months,C.cashback,"
			+ "C.issuer_scheme_processing_fees,C.issuer_rate_of_interest,C.advance_emi,H.issuer_default_cashback_flag,"
			+ "C.issuer_scheme_code,C.issuer_bank_code,H.issuer_min_emi_amount,D.model_code"
			+ " FROM  issuer_scheme_model_user AS A "
			+ "INNER JOIN issuer_scheme_model AS B ON A.issuer_scheme_model_code = B.issuer_scheme_model_code "
			+ "INNER JOIN issuer_schemes AS C ON B.issuer_scheme_code = C.issuer_scheme_code "
			+ "INNER JOIN models AS D ON B.model_code = D.model_code "
			+ "INNER JOIN manufacturers AS E ON D.manufacture_code = E.manufacture_code "
			+ "INNER JOIN categories AS F ON D.category_code = F.category_code "
			+ "INNER JOIN emi_tenures AS G ON G.emi_tenure_code = C.emi_tenure_code "
			+ "INNER JOIN issuer_banks AS H ON H.issuer_bank_code = C.issuer_bank_code "
			+ "AND A.user_id=?1 AND C.issuer_bank_code=?2  AND E.manufacture_code=?3  AND D.category_code=?4 AND D.model_code=?5 ",nativeQuery=true)
	public List<Object[]> fetchEmiTenureListBasedOnUserIdBankIdManufactorerCodeCategoryCodeAndModelCode(Integer userId,Integer issuerBankCode,String manufactureCode,String categoryCode,String modelCode);

	

}
