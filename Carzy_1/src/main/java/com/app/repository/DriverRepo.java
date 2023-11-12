package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Driver;

public interface DriverRepo extends JpaRepository<Driver, Long> {

}
