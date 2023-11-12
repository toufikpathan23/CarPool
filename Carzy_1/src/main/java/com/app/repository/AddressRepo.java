package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Address;

public interface AddressRepo extends JpaRepository<Address, Long> {

}
