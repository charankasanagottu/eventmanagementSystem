package com.example.eventsManagement.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.eventsManagement.service.UserService;
import com.example.eventsManagement.web.dto.UserRegistrationDto;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
	private UserService userservice;

	public UserRegistrationController(UserService userservice) {
		super();
		this.userservice = userservice;
	}
	
//	This step is as like model.addAttribute("")
	@ModelAttribute("user")
	public UserRegistrationDto userRegistrationDto() {
		return new UserRegistrationDto(); 
	}
	
	@GetMapping
	public String showregistrationform() {
		return "registration";
	}
	
	@PostMapping
	public String registerAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) {
		userservice.save(registrationDto);
		return "redirect:/registration?success";
	}
}
