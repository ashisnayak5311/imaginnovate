package com.imaginnovate.springboot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.imaginnovate.springboot.dto.EmployeeDetails;
import com.imaginnovate.springboot.entity.Employee;
import com.imaginnovate.springboot.service.EmployeeService;
import com.imaginnovate.springboot.util.EmployeeConstants;


@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	/**
     * method name: getSalaryDetails
     * @param empId
     * @return
     */
    @RequestMapping(value = "/getSalaryDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> getSalaryDetailsEmployeeWise(
            @RequestParam(EmployeeConstants.empid) Long empId
    ) {
        Long employeeTaxDetails = null;
        try {
        	employeeTaxDetails = employeeService.getTaxDetails(empId);
            return new ResponseEntity<>(employeeTaxDetails, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(employeeTaxDetails, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
	
    /**
     * method name: saveSalaryDetails
     * @param EmployeeDetails
     * @return
     */
	@RequestMapping(value = "/saveSalaryDetails", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> saveEmployeeRoles(@Valid @RequestBody EmployeeDetails employee) {

		Employee returnEmployee = null;
        try {
        	returnEmployee = employeeService.saveEmployee(employee);
        } catch (Exception e) {
            return new ResponseEntity<>(returnEmployee, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(returnEmployee, HttpStatus.OK);
    }
	
}
