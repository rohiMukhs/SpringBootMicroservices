package net.javaguides.departmentService.service.impl;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import net.javaguides.departmentService.dto.DepartmentDto;
import net.javaguides.departmentService.entity.Department;
import net.javaguides.departmentService.repository.DepartmentRepository;
import net.javaguides.departmentService.service.DepartmentService;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
	
	private DepartmentRepository departmentRepository;

	@Override
	public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
		
		
		Department department = new Department(
				
				departmentDto.getId(),
				departmentDto.getDepartmentName(),
				departmentDto.getDepartmentDescription(),
				departmentDto.getDepartmentCode()
				);
		
		Department savedDepartment = departmentRepository.save(department);
		
		DepartmentDto savedDepartmentDto = new DepartmentDto(
				savedDepartment.getId(),
				savedDepartment.getDepartmentName(),
				savedDepartment.getDepartmentDescription(),
				savedDepartment.getDepartmentCode()
				
				);
		
		
				
		return savedDepartmentDto;
	}

	@Override
	public DepartmentDto getDepartmentByCode(String departmentCode) {
		
		Department department = departmentRepository.findByDepartmentCode(departmentCode);
		
		DepartmentDto departmentDto = new DepartmentDto(
				department.getId(),
				department.getDepartmentName(),
				department.getDepartmentDescription(),
				department.getDepartmentCode()
				);
		
		return departmentDto;
	}
	
	

}
