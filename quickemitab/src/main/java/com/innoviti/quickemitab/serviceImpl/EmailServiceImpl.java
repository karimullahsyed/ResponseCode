package com.innoviti.quickemitab.serviceImpl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.innoviti.quickemitab.constants.QuickEmiTabConstant;
import com.innoviti.quickemitab.dao.model.Users;
import com.innoviti.quickemitab.model.ForgotPasswordRequest;
import com.innoviti.quickemitab.repository.config.UsersRepository;
import com.innoviti.quickemitab.service.EmailService;

@Service
@Transactional("configManager")
public class EmailServiceImpl implements EmailService {

	@Autowired
	private UsersRepository userRepository;

	@Autowired
	private JavaMailSender sender;

	Users user = null;

	@Override
	public String toSendMail(ForgotPasswordRequest forgotPassword) {
		try {

			if (forgotPassword.getUserName() != null) {
				user = userRepository.findByUserName(forgotPassword.getUserName());
			} else {
				user = userRepository.findByEmailId(forgotPassword.getEmailId());
			}
			if (user == null && user.getUserName() == null && user.getEmailId() == null) {
				return QuickEmiTabConstant.INAVLID_USER_OR_EMAIL_ID;
			}

			MimeMessage message = sender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message);
			helper.setTo(user.getEmailId());
			helper.setText("Hi " + user.getUserName() + " Here we sending your credentials please find below "
					+ "username : " + user.getUserName() + "password : " + user.getPassword());
			helper.setSubject(QuickEmiTabConstant.EMAIL_SUBJECT);
			sender.send(message);

		} catch (MessagingException e) {
			return QuickEmiTabConstant.INAVLID_USER_OR_EMAIL_ID;
		}
		return QuickEmiTabConstant.EMIAL_SUCCSESS;
	}

}
