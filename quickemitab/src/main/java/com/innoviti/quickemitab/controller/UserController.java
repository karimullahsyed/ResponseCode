package com.innoviti.quickemitab.controller;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.innoviti.quickemitab.dao.model.Users;
import com.innoviti.quickemitab.model.ForgotPasswordRequest;
import com.innoviti.quickemitab.service.EmailService;
import com.innoviti.quickemitab.service.UserService;
import com.innoviti.quickemitab.serviceImpl.UserAuthenticationServiceImpl;

/**
 * @author Karim
 *
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {

	private static Logger logger = LoggerFactory.getLogger(UserAuthenticationServiceImpl.class);

	@Autowired
	private UserService userService;

	@Autowired
	private EmailService emailService;


	@GetMapping("/authenticate")
	public ResponseEntity<Principal> user(Principal user) {
		logger.info("user ");
		return ResponseEntity.<Principal>ok(user);
	}

	@GetMapping(value = "/getUserByUserName")
	public ResponseEntity<Users> getUserByUsername(Principal principal) {
		logger.info("Entering :: UserController :: getUserByUsername method");
		Users user = userService.findByUsername(principal.getName());
		logger.info("Exiting :: UserController :: getUserByUsername method");
		return ResponseEntity.<Users>ok(user);
	}

	@PostMapping(value = "/forgotPassword")
	public ResponseEntity<String> forgotPassword(@RequestBody ForgotPasswordRequest forgotPassword) {
		logger.info("Entering :: UserController :: forgotPassword method");
		String response = emailService.toSendMail(forgotPassword);
		logger.info("Exiting :: UserController :: forgotPassword method");
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
}
