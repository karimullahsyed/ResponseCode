package com.innoviti.quickemitab.repository.config;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.innoviti.quickemitab.dao.model.Model;

/**
 * @author Karim
 *
 */
public interface ModelRepository  extends BaseRepository<Model, Integer> {
	
	@Query(value="SELECT D.model_code,D.model_display_name FROM  issuer_scheme_model_user AS A "
			+ "INNER JOIN issuer_scheme_model AS B ON A.issuer_scheme_model_code = B.issuer_scheme_model_code "
			+ "INNER JOIN issuer_schemes AS C ON B.issuer_scheme_code = C.issuer_scheme_code "
			+ "INNER JOIN models AS D ON B.model_code = D.model_code "
			+ "INNER JOIN manufacturers AS E ON D.manufacture_code = E.manufacture_code "
			+ "INNER JOIN categories AS F ON D.category_code = F.category_code "
			+ "AND A.user_id=?1 AND C.issuer_bank_code=?2  AND E.manufacture_code=?3  AND D.category_code=?4 ",nativeQuery=true)
	public List<Object[]> fetchModelListBasedOnUserIdBankIdManufactorerCodeCategoryCode(Integer userId,Integer issuerBankCode,String manufactureCode,String categoryCode);
}
