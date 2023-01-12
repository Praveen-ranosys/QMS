package com.qms.auth.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.qms.auth.repository.authRepo;
import com.qms.auth.service.authSevice;


public class authServiceImpl implements authSevice  {
	
	@Autowired
	private authRepo aRepo;
	
	@Override
	public void signIn() {
		
	
		
	}

}
