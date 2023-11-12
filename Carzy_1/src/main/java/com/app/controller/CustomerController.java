package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.CustomerDto;
import com.app.services.CustomerService;

@RestController

@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	@PostMapping("/registerCustomer")
	public String addCustomer(@RequestBody CustomerDto customerDto)
	{
		return customerService.regCustomer(customerDto);
	}
}
