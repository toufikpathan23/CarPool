package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.DriverDto;
import com.app.services.DriverService;

@RestController
@RequestMapping("/driver")
public class DriverController {
	@Autowired
	private DriverService driverService;

	@PostMapping("/regDriver")
	public String regDriver(@RequestBody DriverDto driverDto)
	{
		return driverService.regDriver(driverDto);
	}
}
