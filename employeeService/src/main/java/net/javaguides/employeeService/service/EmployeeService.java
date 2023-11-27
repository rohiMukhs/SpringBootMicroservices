package net.javaguides.employeeService.service;

import net.javaguides.employeeService.dto.ApiResponseDto;
import net.javaguides.employeeService.dto.EmployeeDto;


public interface EmployeeService {
	
	EmployeeDto saveEmployee(EmployeeDto employeeDto);
	
	ApiResponseDto getEmployeeById(Long id);
	
	void deleteEmployee(Long userId);

}
