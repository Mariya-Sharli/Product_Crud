package com.js.employee_crud.exception;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
public class GlobleExceptionHandler {

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<Map<String,Object>> handler400()
	{
		Map<String, Object> map=new LinkedHashMap<String,Object>();
		map.put("error", "Data Already Exists");
		
		return ResponseEntity.status(400).body(map);//return map
	}
	
	@ExceptionHandler(NoResourceFoundException.class)
	public ResponseEntity<Map<String,Object>> handler404()
	{
		Map<String, Object> map=new LinkedHashMap<String,Object>();
		map.put("error", "Path does not exist");
		
		return ResponseEntity.status(404).body(map);//return map
	}
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<Map<String,Object>> handler405()
	{
		Map<String, Object> map=new LinkedHashMap<String,Object>();
		map.put("error", "Http method not allowed");
		
		return ResponseEntity.status(405).body(map);//return map
	}
	
	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<Map<String,Object>> handlerFound()
	{
		Map<String, Object> map=new LinkedHashMap<String,Object>();
		map.put("error", "Data not found");
		
		return ResponseEntity.status(404).body(map);//return map
	}
}
