package com.js.employee_crud.repository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import com.js.employee_crud.entity.Employee;
public interface EmployeeRepository extends JpaRepository<Employee,Long>
{
	
	List<Employee> findByRoleContaining(String role,PageRequest pagination);
}
