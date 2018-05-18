package com.innoviti.quickemitab.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.innoviti.quickemitab.dao.model.Users;
import com.innoviti.quickemitab.exception.NotFoundException;
import com.innoviti.quickemitab.repository.config.UsersRepository;
import com.innoviti.quickemitab.service.UserService;

@Service
@Transactional("configManager")
public class UserServiceImpl implements UserService {
	
	private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UsersRepository userRepository;

	@Override
	public Users findByUsername(String username) {
		logger.info("Entering :: UserServiceImpl :: findByUsername method");
		Users user = userRepository.findByUserName(username);
		if (user == null) {
			throw new NotFoundException("User not found : " + username);
		}
		logger.info("Exiting :: UserServiceImpl :: findByUsername method");
		return user;
	}

	
	 @Override 
	 public Users findByUserId(Integer userId) {
		 Users user = userRepository.getOne(userId); 
		 if(user == null){ 
		  throw new NotFoundException("User not found : "+userId); 
		 }
		 return user; 
	 }
}
