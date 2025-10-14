package com.js.employee_crud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.js.employee_crud.entity.Employee;
import com.js.employee_crud.exception.DataNotFoundException;
import com.js.employee_crud.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository repository;
	
	public Employee save(Employee employee)
	{
		return repository.save(employee);
	}

//	public List<Employee> findAll()  {
//		List<Employee> employee = repository.findAll();
//		if(employee.isEmpty())
//			throw new DataNotFoundException();
//		else
//			return employee;
//		// TODO Auto-generated method stub
//		
//	}

	public  List<Employee> fetchRecords(String sort,boolean desc,int page,int size,String role) {
		Sort sorting=desc?Sort.by(sort).descending():Sort.by(sort).ascending();
		
		PageRequest pagination=PageRequest.of(page-1, size,sorting);
		
		List<Employee> employee=new ArrayList<Employee>();
		if(role==null) {
			 employee = repository.findAll(pagination).getContent();
		}
		else
			
			employee = repository.findByRoleContaining(role,pagination);
		
		if(employee.isEmpty())
			throw new DataNotFoundException();
		else
			return employee;	
		
		}
				public void delete(Long id)
			{
				repository.deleteById(id);	
			}
		
			
		 public Employee update(Employee employee,Long id)
		 
		 {
			 Employee oldEmployee = repository.findById(id).orElseThrow(()->new DataNotFoundException());
			  if(employee.getAge() !=null)
				  oldEmployee.setAge(employee.getAge());
			  if(employee.getMobile() !=null)
				  oldEmployee.setMobile(employee.getMobile());
			  if(employee.getName() !=null)
				  oldEmployee.setName(employee.getName());
			  if(employee.getRole() !=null)
				  oldEmployee.setRole(employee.getRole());
			  if(employee.getSalary() !=null)
				  oldEmployee.setSalary(employee.getSalary());
			  return repository.save(oldEmployee);
			 
		 }
	
	
	
	
	
	
	//http://localhost/swagger-ui/index.html#/employee-controller/deleteRecords
}
