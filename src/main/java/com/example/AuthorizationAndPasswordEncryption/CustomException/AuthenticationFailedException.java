package com.example.AuthorizationAndPasswordEncryption.CustomException;

import java.io.PrintStream;
import java.io.PrintWriter;

public class AuthenticationFailedException extends Exception {

	
	private final String status;
	private final String errorMessage;
	
	public AuthenticationFailedException( String status,String errorMessage) {
		this.status=status;
		this.errorMessage=errorMessage;
	}

	public String getStatus() {
		return status;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
	 @Override
	    public void printStackTrace() {
	        super.printStackTrace();
	    }

	    @Override
	    public void printStackTrace(PrintStream s) {
	        super.printStackTrace(s);
	    }

	    @Override
	    public void printStackTrace(PrintWriter s) {
	        super.printStackTrace(s);
	    }

}
