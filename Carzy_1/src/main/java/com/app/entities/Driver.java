package com.app.entities;

import java.io.ObjectInputFilter.Status;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
@Table(name="driver")
public class Driver {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	private String email;
	private String password;
	private String mobNo;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "addr_id",nullable = false)
	private Address address;
	private int age;
	private int experience;
	private String licence;
	private float rate;
	@Enumerated(EnumType.STRING)
	private StatusCheck status=StatusCheck.AVAILABLE;
	private String description;
	
}
