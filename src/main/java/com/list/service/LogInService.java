package com.list.service;

import org.springframework.stereotype.Service;

@Service
public class LogInService 
{
	//hardcoded validateUser, to be replaced 
	public boolean validateUser(String name, String password)
	{
		return (name == "user") && (password == "password");
	}
}
