package com.imaginnovate.springboot.service;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.imaginnovate.springboot.dto.EmployeeDetails;
import com.imaginnovate.springboot.dto.EmployeeTaxDetails;
import com.imaginnovate.springboot.entity.Employee;
import com.imaginnovate.springboot.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee saveEmployee(EmployeeDetails employee) {
		// TODO Auto-generated method stub
		Employee emp = new Employee();
		emp.setEmployeeId(employee.getEmployeeId());
		emp.setFirstName(employee.getFirstName());
		emp.setLastName(employee.getLastName());
		emp.setEmail(employee.getEmail());
		emp.setDateOfJoining(employee.getDateOfJoining());
		emp.setPhoneNumbers(employee.getPhoneNumbers().stream().collect(Collectors.joining(", ")));
		emp.setSalary(employee.getSalary());
		
		return employeeRepository.save(emp);
	}

	@Override
	public Long getTaxDetails(Long empid) {
		// TODO Auto-generated method stub
		Employee employeeDetails = employeeRepository.findOne(empid);
		
		return calculateTax(employeeDetails);
	}

	private Long calculateTax(Employee employeeDetails) {
		Double taxPercentFive = 0.0;
		Double taxPercentTen = 0.0;
		Double taxPercentTwenty = 0.0;
		Double taxPercentCessTwo = 0.0;
		
		Double totalSalary = employeeDetails.getSalary();
		
		if(totalSalary > 25000000) {
			taxPercentCessTwo = (2 / 100) * (totalSalary - 25000000);
		}
		else if(totalSalary > 1000000) {
			taxPercentTwenty = (20 / 100) * (totalSalary - 1000000);
			
		} else if(totalSalary > 500000) {
			taxPercentTen = (10 / 100) * (totalSalary - 500000);
			
		} else if(totalSalary > 250000) {
			taxPercentFive = (5 / 100) * (totalSalary - 250000);
		} 
		
		Double totalTax = taxPercentCessTwo + taxPercentTwenty + taxPercentTen + taxPercentFive;
		
		return (long) totalTax.doubleValue();
	}

}
