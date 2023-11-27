package net.javaguides.departmentService.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import net.javaguides.departmentService.dto.DepartmentDto;
import net.javaguides.departmentService.service.DepartmentService;

@RestController
@AllArgsConstructor
@RequestMapping("/api/departments")
public class DepartmentController {
	
	private DepartmentService departmentService;
	
	@PostMapping
	public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
		
		DepartmentDto savedDepartment = departmentService.saveDepartment(departmentDto);
		
		return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
	}
	
	@GetMapping("{department_code}")
	public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable("department_code")
																String departmentCode){
		
		DepartmentDto departmentDto = departmentService.getDepartmentByCode(departmentCode);
		
		return new ResponseEntity<>(departmentDto, HttpStatus.OK);

	}

}
