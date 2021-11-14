package com.aptech.springmvc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aptech.springmvc.entity.RegisterUser;
import com.aptech.springmvc.entity.User;
import com.aptech.springmvc.service.UserService;

@Controller
@RequestMapping("/register")
public class RegistrationController {
	
	@Autowired
	private UserService userService; 
	
	@GetMapping("/showRegistrationForm")
	public String showRegistrationForm(Model theModel) {
		theModel.addAttribute("registeredUser", new RegisterUser());
		return "registration-form";
	}
	
	@PostMapping("/processRegistrationForm")
	public String processRegistrationForm(@Valid @ModelAttribute("registeredUser") RegisterUser theRegisterUser,
											BindingResult theBindingResult, Model theModel) {
		String username = theRegisterUser.getUsername();
		
		// form validation
		if (theBindingResult.hasErrors())
			return "registration-form";
		
		// Check if user already exists
		User existing = userService.findByUserName(username);
		if (existing != null) {
			theModel.addAttribute("registeredUser", new RegisterUser());
			theModel.addAttribute("registrationError", "Username already exists.");
			return "registration-form";
		}
		
		userService.save(theRegisterUser);
		
		return "user-login";
	}
}
