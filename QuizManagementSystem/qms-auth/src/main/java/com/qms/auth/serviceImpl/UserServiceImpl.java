package com.qms.auth.serviceImpl;


import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.qms.auth.dto.MessageResponse;
import com.qms.auth.dto.SignInRequest;
import com.qms.auth.dto.SignUpRequest;
import com.qms.auth.model.ERole;
import com.qms.auth.model.Role;
import com.qms.auth.model.User;
import com.qms.auth.repository.RoleRepository;
import com.qms.auth.repository.UserRepository;
import com.qms.auth.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	 PasswordEncoder encoder;

	@Override
	public ResponseEntity<?> register(SignUpRequest signUpRequest) {
		

	if (userRepository.existsByEmail(signUpRequest.getEmail())) {
		   return ResponseEntity
		       .badRequest()
		       .body(new MessageResponse("Error: Email is already in use!"));
	    }	
		
		   
	// Create new user's account
	User user = userRequestToModel(signUpRequest);
	Set<Role> roles = new HashSet<>();
	
	Role userRole = roleRepository.findByName(ERole.ROLE_USER)
			.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
	roles.add(userRole);
	
	user.setRoles(roles);
	userRepository.save(user);

	return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}

	private User userRequestToModel(SignUpRequest signUpRequest) {
		User user = new User();
		user.setFirstName(signUpRequest.getFirstname());
		user.setLastName(signUpRequest.getLastname());
		user.setEmail(signUpRequest.getEmail());
	    user.setPassword(encoder.encode(signUpRequest.getPassword()));		
		user.setMobileNumber(signUpRequest.getMobileNumber());
		user.setCreatedOn(LocalDateTime.now());
		user.setUpdatedOn(LocalDateTime.now());
		return user;
	}

	@Override
	public ResponseEntity<?> signIn(SignInRequest signInRequest) {
//		if(signInRequest.getEmailId() == )
		return null;
	}

}
