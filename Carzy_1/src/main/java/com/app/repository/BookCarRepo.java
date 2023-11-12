package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.BookCar;

public interface BookCarRepo extends JpaRepository<BookCar, Long> {

}
