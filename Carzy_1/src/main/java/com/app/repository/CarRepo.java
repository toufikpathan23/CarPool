package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Car;

public interface CarRepo extends JpaRepository<Car, Long> {

}
