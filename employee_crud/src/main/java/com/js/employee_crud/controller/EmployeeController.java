package com.js.employee_crud.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.js.employee_crud.entity.Employee;
import com.js.employee_crud.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService service;
	
	
	@PostMapping("/employees")
	@Operation(summary="Save an Employee Records")
	
//	@ResponseBody
	public ResponseEntity<Map<String,Object>> saveEmployee(@RequestBody Employee employee)
	{
		Map<String, Object> map=new LinkedHashMap<String,Object>();
		map.put("message", "Data Saved Successfully");
//		map.put("data", employee);
		map.put("content", service.save(employee));
		return ResponseEntity.status(201).body(map);//return map
		
	}
	@GetMapping("/employees")
	@Operation(summary="Fetch the Employee Records")
	public ResponseEntity<Map<String,Object>> fetchAllEmployee(
	
			@RequestParam(defaultValue = "id") String sort,
			@RequestParam(defaultValue = "false") boolean desc,
			@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "10") int size,
			@RequestParam(required=false) String role//means the variable is null in case of string and 0 in case of int
			
			){
				Map<String, Object> map=new LinkedHashMap<String,Object>();
				map.put("message", "Data Found");
//				map.put("data", employee);
//				map.put("content", service.findAll());
				map.put("content", service.fetchRecords(sort,desc,page,size,role));
				return ResponseEntity.status(200).body(map);//return map
			}
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String,Object>> deleteRecords(@PathVariable long id){
				service.delete(id);
				Map<String, Object> map=new LinkedHashMap<String,Object>();
				map.put("message", "Data Deleted");
				return ResponseEntity.status(200).body(map);//return map
			}
	@PutMapping("/employees")
	public ResponseEntity<Map<String,Object>> updateEmployee(@RequestBody Employee employee){
				
				Map<String, Object> map=new LinkedHashMap<String,Object>();
				map.put("message", "Data Update Successfull");
				map.put("content", service.save(employee));
				return ResponseEntity.status(200).body(map);//return map
			}
		
	@PatchMapping("/employees/{id}")
	public ResponseEntity<Map<String,Object>> updateEmployee(@RequestBody Employee employee,@PathVariable Long id){
				
				Map<String, Object> map=new LinkedHashMap<String,Object>();
				map.put("message", "Data Update Successfull");
				map.put("content", service.update(employee,id));
				return ResponseEntity.status(200).body(map);//return map
			}
			
	}
	
		
		
	    
		   
