package com.rubyko.server.login;

import java.sql.SQLException;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;

import com.rubyko.db.Database;
import com.rubyko.db.login.Registration;
import com.rubyko.shared.boss.login.RegisterUserService;
import com.rubyko.shared.boss.login.exception.DataFormatException;
import com.rubyko.shared.boss.login.exception.DataLimitException;
import com.rubyko.shared.boss.login.exception.EmailDoesntExistException;
import com.rubyko.shared.boss.login.exception.UserAlreadyExistsException;
import com.rubyko.shared.common.login.model.AccessCard;
import com.rubyko.shared.common.login.model.User;

@SuppressWarnings("serial")
public class RegisterUserServiceImpl implements RegisterUserService {

	@Override
	public AccessCard register(AccessCard pUser)
			throws DataFormatException, DataLimitException, UserAlreadyExistsException, EmailDoesntExistException {
		try {
			final String token = new SessionIdentifierGenerator().nextSessionId();
			final String email = validateEmail(pUser.getEmail());
			final String pass = validatePassword(pUser.getPassword());
			final String userName = validateUserName(pUser.getUserName());
			final Integer id = Registration.addUser(token, email, pass, userName);	
			final AccessCard newUser = new AccessCard(pass, email, id.toString(), token, userName);
			return newUser;
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e.getCause());
		}
	}

	private String validateEmail(String email) throws DataFormatException {
		if (!EmailValidator.getInstance().isValid(email)) {
			throw new DataFormatException("Your email format is invalid.");
		}
		try {
			InternetAddress emailAddr = new InternetAddress(email);
			emailAddr.validate();
			return email;
		} catch (AddressException e) {
			throw new DataFormatException("Your email is not found.");
		}
	}

	private String validatePassword(String pass) throws DataLimitException, DataFormatException {
		if (!StringUtils.isAlphanumeric(pass)) {
			throw new DataFormatException("Your password contains icompatible symbols.");
		}
		if (pass.length() < 6 || pass.length() > 20) {
			throw new DataLimitException("Your password is out of bounds");
		}
		return pass;
	}

	private String validateUserName(String userName) {
		return userName;
	}

}
