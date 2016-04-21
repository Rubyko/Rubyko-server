package com.rubyko.shared.boss.login;

import com.rubyko.shared.boss.login.exception.DataFormatException;
import com.rubyko.shared.boss.login.exception.DataLimitException;
import com.rubyko.shared.boss.login.exception.UserDoesntExistException;
import com.rubyko.shared.common.login.model.AccessCard;

import java.io.Serializable;

/**
 * Created by alex on 23.02.16.
 */
public interface LoginUserService extends Serializable {

    String objectName1 = "LOGIN_USER_SERVICE";

    AccessCard login(AccessCard pAccessCard) throws UserDoesntExistException, DataFormatException, DataLimitException;

}
