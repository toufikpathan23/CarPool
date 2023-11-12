package com.app.dtos;

import java.time.LocalDateTime;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.app.entities.Car;
import com.app.entities.Customer;
import com.app.entities.Driver;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class BookCarReqDto{
	
	private long carId;
	private long driverId;
	private long customerId;
}