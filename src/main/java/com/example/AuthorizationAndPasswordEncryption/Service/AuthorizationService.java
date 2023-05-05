package com.example.AuthorizationAndPasswordEncryption.Service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AuthorizationAndPasswordEncryption.CustomException.AuthenticationFailedException;
import com.example.AuthorizationAndPasswordEncryption.Modal.UserEntity;
import com.example.AuthorizationAndPasswordEncryption.Provider.PasswordCryptographyProvider;
import com.example.AuthorizationAndPasswordEncryption.Repository.UserRepository;


@Service

public class AuthorizationService {
	
	@Autowired
	private UserRepository userrepo;
	
	@Autowired
	private PasswordCryptographyProvider passwordCryptography;
    
	public String authenticate(final String username, final String password) throws AuthenticationFailedException {
		UserEntity userentity=userrepo.findByUserName(username);
		if(userentity==null) {
			throw new AuthenticationFailedException("USR-001", "User not found");
		}
		
		final String encryptedPassword = passwordCryptography.encrypt(password, userentity.getSalt());
		
		if(userentity.getPassword().equals(encryptedPassword)) {
			return "Succesfully Logged In";
		}
		else {
			throw new AuthenticationFailedException("USR-002", "Invalid password");
		}
	}
}
