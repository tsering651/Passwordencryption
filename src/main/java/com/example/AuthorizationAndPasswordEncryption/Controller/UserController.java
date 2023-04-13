package com.example.AuthorizationAndPasswordEncryption.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AuthorizationAndPasswordEncryption.Modal.UserEntity;
import com.example.AuthorizationAndPasswordEncryption.Service.UserService;

@RestController
@RequestMapping("/v1/api")

public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@PostMapping("/signUp")
	public ResponseEntity<Object> signUp(@RequestBody UserEntity userentity){
		userservice.userSignUp(userentity);
		 return new ResponseEntity<>(HttpStatus.OK);
	}
	

}
