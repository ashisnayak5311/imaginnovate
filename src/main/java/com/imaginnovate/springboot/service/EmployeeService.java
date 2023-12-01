package com.imaginnovate.springboot.service;

import com.imaginnovate.springboot.dto.EmployeeDetails;
import com.imaginnovate.springboot.dto.EmployeeTaxDetails;
import com.imaginnovate.springboot.entity.Employee;

public interface EmployeeService {

	Employee saveEmployee(EmployeeDetails employee);

	Long getTaxDetails(Long empid);

}
