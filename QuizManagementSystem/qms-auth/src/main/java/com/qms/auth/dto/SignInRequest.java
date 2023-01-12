package com.qms.auth.dto;

import lombok.Data;

@Data
public class SignInRequest {
	private String emailId;
	private String password;
}
