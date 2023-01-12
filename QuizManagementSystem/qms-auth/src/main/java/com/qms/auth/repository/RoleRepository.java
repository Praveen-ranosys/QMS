package com.qms.auth.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qms.auth.model.ERole;
import com.qms.auth.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	Optional<Role> findByName(ERole name);

}
