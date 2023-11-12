package com.app.services;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dtos.BookCarReqDto;
import com.app.dtos.BookCarRespDto;
import com.app.dtos.CarDto;
import com.app.entities.Address;
import com.app.entities.BookCar;
import com.app.entities.Car;
import com.app.entities.CarOwner;
import com.app.entities.Customer;
import com.app.entities.Driver;
import com.app.enums.StatusCheck;
import com.app.repository.AddressRepo;
import com.app.repository.BookCarRepo;
import com.app.repository.CarRepo;
import com.app.repository.CustomerRepo;
import com.app.repository.DriverRepo;
import com.app.repository.OwnerRepo;

@Service
@Transactional
public class CarServiceImpl implements CarService{

	@Autowired
	private CarRepo carRepo;
	
	@Autowired
	private OwnerRepo ownerRepo;
	
	@Autowired
	private AddressRepo addressRepo;
	
	@Autowired
	private DriverRepo driverRepo;
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private BookCarRepo bookCarRepo;
	
	@Override
	public String addCar(CarDto carDto) {
		
		Address address=addressRepo.save(carDto.getAddress());
		
		CarOwner carOwner=ownerRepo.findById(carDto.getOwnerID()).orElseThrow();
		Car car=new Car();
		BeanUtils.copyProperties(carDto, car);
		car.setRegisteredAt(LocalDateTime.now());
		car.setOwner(carOwner);
		car.setAddress(address);
		if(carRepo.save(car)==null)
			return null;
		return "car added successfully...";
	}

	@Override
	public BookCarRespDto bookingCar(BookCarReqDto bookCarReqDto) {
		Car car=carRepo.findById(bookCarReqDto.getCarId()).orElseThrow();
		Driver driver=new Driver();
		if(bookCarReqDto.getDriverId()!=0)
		driver=driverRepo.findById(bookCarReqDto.getDriverId()).orElseThrow();
		Customer customer=customerRepo.findById(bookCarReqDto.getCustomerId()).orElseThrow();
		
		BookCar bookCar=new BookCar();
		car.setStatus(StatusCheck.UNAVAILABLE);
		bookCar.setCar(car);
		carRepo.save(car);
		
		if(driver!=null)
		bookCar.setDriver(driver);
		
		bookCar.setCustomer(customer);
		bookCar.setBookedAt(LocalDateTime.now());
		bookCarRepo.save(bookCar);
		
		//setting car info to carbookrespdto
		BookCarRespDto bookCarRespDto=new BookCarRespDto();
		bookCarRespDto.setCarName(car.getCarName());
		bookCarRespDto.setCarNo(car.getCarNo());
		bookCarRespDto.setAddress(car.getAddress());
		bookCarRespDto.setRate(car.getRate());
		bookCarRespDto.setName(driver.getName());
		bookCarRespDto.setMobNo(driver.getMobNo());
		
		return bookCarRespDto;
	}

}
