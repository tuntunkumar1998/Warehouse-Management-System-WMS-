package com.wms.service;

import org.springframework.stereotype.Service;

import com.wms.Entity.User;
import com.wms.repository.UserRepository;

@Service
public class AuthService {

	private final UserRepository repo;

    public AuthService(UserRepository repo) {
        this.repo = repo;
    }

    // Register
    public User register(User user) {
        return repo.save(user);
    }

    // Login
    public boolean login(String username,
                         String password) {

        User dbUser =
                repo.findByUsername(username);

        return dbUser != null &&
               dbUser.getPassword().equals(password);
    }
	
}
