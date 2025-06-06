package com.cognizant.EmployeeManagementSystem.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.EmployeeManagementSystem.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
