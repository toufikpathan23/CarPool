package com.app.services;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dtos.CustomerDto;
import com.app.entities.Customer;
import com.app.repository.CustomerRepo;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepo customerRepo;

	@Override
	public String regCustomer(CustomerDto customerDto) {
		Customer customer=new Customer();
		BeanUtils.copyProperties(customerDto,customer);
		if(customerRepo.save(customer)==null)
			return null;
		return "customr added successfully..added..";
	}

}
