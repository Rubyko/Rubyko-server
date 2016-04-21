package com.rubyko.server.login;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.GenericValidator;
import org.apache.commons.validator.Validator;
import org.apache.commons.validator.routines.EmailValidator;

import com.rubyko.shared.boss.login.LoginUserService;
import com.rubyko.shared.boss.login.exception.DataFormatException;
import com.rubyko.shared.boss.login.exception.DataLimitException;
import com.rubyko.shared.boss.login.exception.UserDoesntExistException;
import com.rubyko.shared.common.login.model.AccessCard;
import com.rubyko.shared.common.login.model.User;


public class LoginUserServiceImpl implements LoginUserService {

	@Override
	public AccessCard login(AccessCard pUser)
			throws UserDoesntExistException, DataFormatException, DataLimitException {
		System.out.println("here");
		//final String email = validateEmail(pUser.getEmail());
	//	final String password = validatePassword(pUser.getPassword());
		final String str = new SessionIdentifierGenerator().nextSessionId();
		return new AccessCard(null, null, str, str, "Rubyko User");
	}

	
	private String validateEmail(String email) throws DataFormatException {
		if(!EmailValidator.getInstance().isValid(email)){
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
		if(!StringUtils.isAlphanumeric(pass)){
			throw new DataFormatException("Your password contains icompatible symbols.");
		}
		if(pass.length() < 6 || pass.length() > 20){
			throw new DataLimitException("Your password is out of bounds");
		}
		return pass;
	}



}
