package doan.flamebackend.service;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomPasswordEncoder implements PasswordEncoder {
	@Override
	public String encode(CharSequence plainTextPassword) {
		return BCrypt.hashpw(plainTextPassword.toString(), BCrypt.gensalt(8));
	}

	@Override
	public boolean matches(CharSequence plainTextPassword, String passwordInDatabase) {
		return BCrypt.checkpw(plainTextPassword.toString(), passwordInDatabase);
	}

}
