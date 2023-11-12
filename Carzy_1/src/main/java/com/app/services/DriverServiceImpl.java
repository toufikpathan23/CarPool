package com.app.services;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dtos.DriverDto;
import com.app.entities.Address;
import com.app.entities.Driver;
import com.app.repository.AddressRepo;
import com.app.repository.DriverRepo;

@Service
@Transactional
public class DriverServiceImpl implements DriverService {
	
	@Autowired
	private DriverRepo driverRepo;
	
	@Autowired
	private AddressRepo addressRepo;

	@Override
	public String regDriver(DriverDto driverDto) {
		
		Address address=new Address();
		BeanUtils.copyProperties(driverDto.getAddress(), address);
		addressRepo.save(address);
		
		Driver driver=new Driver();
		BeanUtils.copyProperties(driverDto, driver);
		driver.setAddress(address);
		if(driverRepo.save(driver)==null)
			return null;
		return "driver addded successfully";
	}

}
