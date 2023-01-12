package com.qms.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qms.auth.model.User;

public interface authRepo extends JpaRepository<User, Integer> {

}
