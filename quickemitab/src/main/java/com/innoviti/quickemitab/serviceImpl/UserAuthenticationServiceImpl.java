package com.innoviti.quickemitab.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.innoviti.quickemitab.dao.model.UserRoles;
import com.innoviti.quickemitab.dao.model.Users;
import com.innoviti.quickemitab.service.UserAuthenticationService;
import com.innoviti.quickemitab.service.UserService;

@Service
@Transactional("configManager")
public class UserAuthenticationServiceImpl implements UserAuthenticationService {

	private static Logger logger = LoggerFactory.getLogger(UserAuthenticationServiceImpl.class);

	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		logger.info("Entering :: UserAuthenticationServiceImpl :: loadUserByUsername method");
		Users user = userService.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		String password = user.getPassword();
		Set<UserRoles> roles = user.getUserRoles();
		List<GrantedAuthority> userGrants = new ArrayList<>();
		for (UserRoles role : roles) {
			GrantedAuthority userGrant = new SimpleGrantedAuthority(role.getRoleName());
			userGrants.add(userGrant);
		}
		logger.info("user roles : {}", roles);
		logger.info("Exiting :: UserAuthenticationServiceImpl :: loadUserByUsername method");
		return new User(username, password, userGrants);
	}

}
