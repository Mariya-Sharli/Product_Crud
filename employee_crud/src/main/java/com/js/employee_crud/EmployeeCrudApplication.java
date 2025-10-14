package com.js.employee_crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info= @Info(title="REST*API for Employee",version="0.0.1",description="Basic rest api for performing "
		+ "crud operation with Employee records",contact =@Contact(email="mariyasharli02@gmail.com",name="Mariya Sharli ",
		url="https://github.com/Mariya-Sharli")))

public class EmployeeCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeCrudApplication.class, args);
	}

}
