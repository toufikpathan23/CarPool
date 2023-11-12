package com.app.dtos;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.app.entities.Address;
import com.app.enums.StatusCheck;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DriverDto {

	private String name;
	private String email;
	private String password;
	private String mobNo;
	private Address address;
	private int age;
	private int experience;
	private String licence;
	private float rate;
	private String description;
	
}
