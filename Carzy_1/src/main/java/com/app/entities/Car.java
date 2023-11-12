package com.app.entities;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.app.enums.StatusCheck;
import com.app.enums.Approval;

import ch.qos.logback.core.subst.Token.Type;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="car")
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	//@Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime registeredAt;
	private String carName;
	private String carModel;
	private String carNo;
	private String description;
	
	@Enumerated(EnumType.STRING)
	private StatusCheck status=StatusCheck.AVAILABLE;
	@Enumerated(EnumType.STRING)
	private Approval approval=Approval.NOTAPPROVED;
	@OneToOne
	@JoinColumn(name = "address_id",nullable = false)
	private Address address;
	
	private float rate;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "owner_id",nullable = false)
	private CarOwner owner;
	

}
