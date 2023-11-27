package net.javaguides.departmentService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.departmentService.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
	
	Department findByDepartmentCode(String code);

}
