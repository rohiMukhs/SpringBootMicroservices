package net.javaguides.employeeService.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.AllArgsConstructor;
import net.javaguides.employeeService.dto.ApiResponseDto;
import net.javaguides.employeeService.dto.DepartmentDto;
import net.javaguides.employeeService.dto.EmployeeDto;
import net.javaguides.employeeService.entity.Employee;
import net.javaguides.employeeService.repository.EmployeeRepository;
import net.javaguides.employeeService.service.ApiClient;
import net.javaguides.employeeService.service.EmployeeService;



@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
	
	//private RestTemplate restTemplate;
	
	//private WebClient webClient;
	
	private ApiClient apiClient;
	
	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		
		Employee employee = new Employee(
				
				employeeDto.getId(),
				employeeDto.getFirstName(),
				employeeDto.getLastName(),
				employeeDto.getEmail(),
				employeeDto.getDepartmentCode()
				
				);
		
		Employee savedEmployee = employeeRepository.save(employee);
		
		EmployeeDto savedEmployeeDto = new EmployeeDto(
				
				savedEmployee.getId(),
				savedEmployee.getFirstName(),
				savedEmployee.getLastName(),
				savedEmployee.getEmail(),
				savedEmployee.getDepartmentCode()
				
						);
		return savedEmployeeDto;
	}

	@Override
	public ApiResponseDto getEmployeeById(Long id) {
		
		Employee employee = employeeRepository.findById(id).get();
		
//		ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/" + employee.getDepartmentCode(),
//				DepartmentDto.class);
//		
//		DepartmentDto departmentDto = responseEntity.getBody();
		
//		DepartmentDto departmentDto = webClient.get()
//				 .uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode())
//				 .retrieve()
//				 .bodyToMono(DepartmentDto.class)
//				 .block();
		
		DepartmentDto departmentDto = apiClient.getDepartmentByCode(employee.getDepartmentCode());
		
		
		EmployeeDto employeeDto = new EmployeeDto(
				employee.getId(),
				employee.getFirstName(),
				employee.getLastName(),
				employee.getEmail(),
				employee.getDepartmentCode()
				);
		
		ApiResponseDto apiResponseDto = new ApiResponseDto();
		apiResponseDto.setEmployee(employeeDto);
		apiResponseDto.setDepartment(departmentDto);
		
				
		return apiResponseDto;
	}

	@Override
	public void deleteEmployee(Long employeeId) {
		
		Employee existingEmployee = employeeRepository.findById(employeeId).get();
		
		employeeRepository.deleteById(employeeId);
		
		
	}


	

}
