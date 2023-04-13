package com.example.AuthorizationAndPasswordEncryption.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.example.AuthorizationAndPasswordEncryption.CustomException.AuthenticationFailedException;



public class AuthorizationExceptionHandler {
	  @ExceptionHandler(AuthenticationFailedException.class)
	    public ResponseEntity<String> authenticationFailed(AuthenticationFailedException exc,WebRequest request){
	    	  return new ResponseEntity<String>(exc.getErrorMessage(),HttpStatus.UNAUTHORIZED);
	    }
}
