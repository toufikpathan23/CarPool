package com.app.entities;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.app.enums.StatusCheck;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="bookCar")
public class BookCar {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private LocalDateTime bookedAt;
	
	@OneToOne
	@JoinColumn(name = "car_id",nullable = false)
	private Car car;
	
	@OneToOne(fetch = FetchType.LAZY)
	//@MapsId
	@JoinColumn(name = "driver_id")/*,nullable = false)*/
	private Driver driver;
	
	@OneToOne
	//@MapsId
	@JoinColumn(name = "customer_id",nullable = false)
	private Customer customer;
}