package com.wms.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wms.Entity.User;
import com.wms.config.JwtUtil;
import com.wms.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	
	private final AuthService service;
    private final JwtUtil jwtUtil;

    public AuthController(AuthService service,
                          JwtUtil jwtUtil) {

        this.service = service;
        this.jwtUtil = jwtUtil;
    }

    // Register API
    @PostMapping("/register")
    public User register(@RequestBody User user) {

        return service.register(user);
    }

    // Login API
    @PostMapping("/login")
    public String login(@RequestBody User user) {

        boolean valid =
                service.login(
                        user.getUsername(),
                        user.getPassword());

        if(valid) {
            return jwtUtil.generateToken(
                    user.getUsername());
        }

        return "Invalid Credentials";
    }
	
}
