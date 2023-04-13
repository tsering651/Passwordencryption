package com.example.AuthorizationAndPasswordEncryption.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AuthorizationAndPasswordEncryption.CustomException.AuthenticationFailedException;
import com.example.AuthorizationAndPasswordEncryption.Modal.AuthorizationUserEntity;
import com.example.AuthorizationAndPasswordEncryption.Modal.UserEntity;
import com.example.AuthorizationAndPasswordEncryption.Service.AuthorizationService;

@RestController
@RequestMapping("/")
public class AuthorizationController {

	
	@Autowired
	private AuthorizationService authservice;
	
	
	@PostMapping("/login")
	public ResponseEntity<UserEntity> login(@RequestBody final String username, final String password) throws AuthenticationFailedException{
		return new ResponseEntity<>(authservice.authenticate(username, password),HttpStatus.ACCEPTED);
	}
}
