package net.javaguides.employeeService.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import net.javaguides.employeeService.dto.DepartmentDto;

@FeignClient(url= "http://localhost:8080", value= "DEPARTMENT-SERVICE")
public interface ApiClient {
	
	@GetMapping("api/departments/{department_code}")
	public DepartmentDto getDepartmentByCode(@PathVariable("department_code")
																String departmentCode);
		
	

}
