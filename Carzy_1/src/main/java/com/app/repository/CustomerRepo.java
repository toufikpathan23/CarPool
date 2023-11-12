package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Long>{

}
