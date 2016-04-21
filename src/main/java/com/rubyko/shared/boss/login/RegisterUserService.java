package com.rubyko.shared.boss.login;


import com.rubyko.shared.boss.login.exception.DataFormatException;
import com.rubyko.shared.boss.login.exception.DataLimitException;
import com.rubyko.shared.boss.login.exception.EmailDoesntExistException;
import com.rubyko.shared.boss.login.exception.UserAlreadyExistsException;
import com.rubyko.shared.common.login.model.AccessCard;

import java.io.Serializable;

/**
 * Created by alex on 23.02.16.
 */
public interface RegisterUserService extends Serializable {

    String objectName1 = "REGISTER_USER_SERVICE";

    AccessCard register(AccessCard pAccessCard) throws DataFormatException, DataLimitException, UserAlreadyExistsException, EmailDoesntExistException;

}
