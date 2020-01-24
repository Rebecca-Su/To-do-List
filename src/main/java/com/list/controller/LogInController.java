package com.list.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.list.service.LogInService;


@Controller
public class LogInController 
{
	@Autowired LogInService logInService;
	
	@RequestMapping("/")
	public String showLogInPage()
	{
		return "logIn";
	}
	
	@PostMapping("/login")
	@ResponseBody
	public String showWelcomePage(@RequestParam("name")String name,
								  @RequestParam("password")String password)
	{
		boolean validity = logInService.validateUser(name, password);
		
		if(validity)
			return "success";
		else
			return "Invalid Credentials" + validity;
	}
	
	@RequestMapping("/welcome")
	public String welcomePage(ModelMap model, 
							  @RequestParam("name")String name)
	{
		model.addAttribute("name", name);
		
		return "welcome";
	}
}
