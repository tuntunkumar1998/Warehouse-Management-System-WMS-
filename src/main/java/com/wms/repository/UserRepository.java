package com.wms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wms.Entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername(String username);

}
