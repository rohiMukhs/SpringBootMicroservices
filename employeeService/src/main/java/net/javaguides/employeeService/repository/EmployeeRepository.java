package net.javaguides.employeeService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.employeeService.entity.Employee;

public interface EmployeeRepository  extends  JpaRepository<Employee, Long>{
	
	

}
