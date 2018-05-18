package com.innoviti.quickemitab.repository.config;

import org.springframework.data.jpa.repository.Query;

import com.innoviti.quickemitab.dao.model.IssuerBin;

/**
 * @author Karim
 *
 */
public interface IssuerBinRepository  extends BaseRepository<IssuerBin, Integer> {
	
	@Query(value="SELECT * FROM  issuing_bin where issuer_bin=?1 AND issuer_bank_code=?2 ",nativeQuery=true)
	public IssuerBin validateBin(Integer issuerBinNo,Integer issuerBankCode);

}
