package com.example.AuthorizationAndPasswordEncryption.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AuthorizationAndPasswordEncryption.Modal.UserEntity;
import com.example.AuthorizationAndPasswordEncryption.Provider.PasswordCryptographyProvider;
import com.example.AuthorizationAndPasswordEncryption.Repository.UserRepository;

@Service
public class UserService {

	
	@Autowired
	private UserRepository userrepository;
	
	@Autowired 
	private PasswordCryptographyProvider cryptographyProvider;
	
	
	public void userSignUp(UserEntity userentity) {
		String[] encryptedText = cryptographyProvider.encrypt(userentity.getPassword());
	       userentity.setSalt(encryptedText[0]);
	       userentity.setPassword(encryptedText[1]);
	       
	        userrepository.save(userentity);
	}
}
