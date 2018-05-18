package com.innoviti.quickemitab.repository.config;

import java.util.List;

import com.innoviti.quickemitab.dao.model.IssuerSchemeModelUser;
import com.innoviti.quickemitab.dao.model.IssuerSchemeModelUserComposite;

/**
 * @author Karim
 *
 */
public interface IssuerSchemeModelUserRepository  extends BaseRepository<IssuerSchemeModelUser, IssuerSchemeModelUserComposite>{
	
	public List<IssuerSchemeModelUser> findByIssuerSchemeModelUserCompositeUserId(Integer userId);


}
