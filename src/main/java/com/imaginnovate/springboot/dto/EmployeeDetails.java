package com.imaginnovate.springboot.dto;

import java.util.List;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class EmployeeDetails {
	
	private Long employeeId;
	@NotEmpty(message = "Firstname cannot be empty")
    private String firstName;
	@NotEmpty(message = "Lastname cannot be empty")
    private String lastName;
	@NotEmpty(message = "Email cannot be empty")
    @Email(message = "Invalid email format")
    private String email;
    private List<String> phoneNumbers;
    @NotEmpty(message = "DOJ cannot be empty")
    private String dateOfJoining;
    @NotEmpty(message = "Salary cannot be empty")
    private double salary;
    
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<String> getPhoneNumbers() {
		return phoneNumbers;
	}
	public void setPhoneNumbers(List<String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	public String getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	@Override
	public String toString() {
		return "EmployeeDetails [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", phoneNumbers=" + phoneNumbers + ", dateOfJoining=" + dateOfJoining
				+ ", salary=" + salary + "]";
	}
    
    

}
