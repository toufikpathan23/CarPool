package com.app.services;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dtos.OwnerDto;
import com.app.entities.Address;
import com.app.entities.CarOwner;
import com.app.repository.AddressRepo;
import com.app.repository.OwnerRepo;

@Service
@Transactional
public class OwnerServiceImpl implements OwnerService{

	@Autowired
	private AddressRepo addressRepo;
	@Autowired
	private OwnerRepo ownerRepo;
	@Override
	public String addOwner(OwnerDto ownerDto) {
		// TODO Auto-generated method stub
		Address address=addressRepo.save(ownerDto.getAddress());
		CarOwner carOwner=new CarOwner();
		BeanUtils.copyProperties(ownerDto, carOwner);
		CarOwner carOwner1=ownerRepo.save(carOwner);
		if(carOwner1==null)
			return null;
		return "Owner registered successfully...";
	}

}
