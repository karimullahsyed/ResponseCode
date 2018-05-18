package com.innoviti.quickemitab.service;

import com.innoviti.quickemitab.dao.model.Users;

public interface UserService {
	
  Users findByUsername(String username);
  
  Users findByUserId(Integer userId);
  
}
