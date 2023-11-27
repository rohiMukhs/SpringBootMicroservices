package net.javaguides.employeeService.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import net.javaguides.employeeService.dto.ApiResponseDto;
import net.javaguides.employeeService.dto.EmployeeDto;
import net.javaguides.employeeService.service.EmployeeService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	@PostMapping
	public ResponseEntity<EmployeeDto> saveDepartment(@RequestBody EmployeeDto employeeDto){
		
		EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
		
		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ApiResponseDto> getEmployeeById(@PathVariable("id")
																Long id){
		
		ApiResponseDto apiResponseDto = employeeService.getEmployeeById(id);
		
		return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);

	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Long employeeId){
		
		employeeService.deleteEmployee(employeeId);
		return new ResponseEntity<>("Employee successfully deleted!", HttpStatus.OK);
	}

}
