package com.example.eventsManagement.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.eventsManagement.model.User;
import com.example.eventsManagement.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{

	User save(UserRegistrationDto registrationDto);
}
