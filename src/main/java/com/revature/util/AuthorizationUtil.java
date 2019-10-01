package com.revature.util;

import com.revature.models.User;

public class AuthorizationUtil {
	
	public String login(User userInDb, User emailAndPass) {
		String token = null;
		if(userInDb.getPassword().contentEquals(emailAndPass.getPassword())) {
			token = generateToken(userInDb);
			return token;
		}
		else {
			token = "failed authorization";
			return token;
		}
	}
	
	public String generateToken(User user) {
		String token = user.getEmail()+":"+user.getPassword();
		token = EncryptionUtil.encrypt(token);
		return token;
	}
	
	public Boolean authorize(User user, String token) {
		String decryptedToken = EncryptionUtil.decrypt(token);
		if(decryptedToken == null) {
			return false;
		}
		String[] splitToken = decryptedToken.split(":");
		if(splitToken[0].contentEquals(user.getEmail()) && splitToken[1].contentEquals(user.getPassword())) {
			return true;
		}
		else {
			return false;
		}
	}
}
