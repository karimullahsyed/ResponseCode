package com.innoviti.quickemitab.repository.config;

import com.innoviti.quickemitab.dao.model.Users;

/**
 * @author Karim
 *
 */
public interface UsersRepository extends BaseRepository<Users, Integer> {
	
  Users findByUserName(String username);
  Users findByEmailId(String emailId);
 
  
}
