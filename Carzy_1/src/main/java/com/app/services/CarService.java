package com.app.services;

import com.app.dtos.BookCarReqDto;
import com.app.dtos.BookCarRespDto;
import com.app.dtos.CarDto;

public interface CarService {
	
	String addCar(CarDto carDto);
	BookCarRespDto bookingCar(BookCarReqDto bookCarReqDto);

}
