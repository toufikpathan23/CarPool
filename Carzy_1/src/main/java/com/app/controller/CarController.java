package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.BookCarReqDto;
import com.app.dtos.BookCarRespDto;
import com.app.dtos.CarDto;
import com.app.services.CarService;

@RestController
@RequestMapping("/car")
public class CarController {
	
	@Autowired
	private CarService carService;
	
	@PostMapping("/resgister")//owner can add car
	public String addCar(@RequestBody CarDto carDto)
	{
		return carService.addCar(carDto);
	}
	
	@PostMapping("/bookcar")//customer can book car
	public BookCarRespDto bookCar(@RequestBody BookCarReqDto BookCarReqDto)
	{
		return carService.bookingCar(BookCarReqDto);
		
	}

}
