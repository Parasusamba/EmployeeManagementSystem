package com.cognizant.EmployeeManagementSystem.service;

import java.util.List;


import com.cognizant.EmployeeManagementSystem.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.EmployeeManagementSystem.exception.EmployeeNotFoundException;
import com.cognizant.EmployeeManagementSystem.model.Employee;

@Service
public class EmployeeService {
    @Autowired
	private EmployeeRepo employeeRepo;

	public List<Employee> findAll() {
		return employeeRepo.findAll();
	}
	
	public Employee findById(Long id) {
		return employeeRepo.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Requested Employee Not Found with id= "+id));
	}
	
	public Employee addEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}
	
	public Employee updateEmployee(Long id,Employee updatedEmployee) {
		Employee emp = employeeRepo.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Requested Employee Not Found with id= "+id));
		
		emp.setFirstName(updatedEmployee.getFirstName());
		emp.setLastName(updatedEmployee.getLastName());
		emp.setEmail(updatedEmployee.getEmail());
		emp.setJobTitle(updatedEmployee.getJobTitle());
		emp.setDepartment(updatedEmployee.getDepartment());
		emp.setSalary(updatedEmployee.getSalary());
		emp.setDateOfJoining(updatedEmployee.getDateOfJoining());
		
		return employeeRepo.save(emp);
	}
	
	public void deleteEmployee(Long id) {
		Employee emp = employeeRepo.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Requested Employee Not Found with id= "+id));
		employeeRepo.deleteById(emp.getId());
	}
	
}
