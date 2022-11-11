package com.example.CustomerService.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "customers")
@Getter@Setter
public class Customer implements Serializable {
	@Id
	@Column(name = "customerId", columnDefinition = "varchar(9)")
	private String id;
	private String name;
	private String address;
}