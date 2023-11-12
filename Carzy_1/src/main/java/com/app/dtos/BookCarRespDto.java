package com.app.dtos;

import com.app.entities.Address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookCarRespDto {

	private String carName;
	private String carNo;
	private Address address;
	private float rate;
	private String name;
	private String mobNo;
	
}
