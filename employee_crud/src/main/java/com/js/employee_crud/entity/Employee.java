package com.js.employee_crud.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private Double salary;
	@Column(nullable=false)
	private Integer age;
	@Column(nullable=false,unique=true)
	private Long mobile;
	@Column(nullable=false)
	private String role;
}
