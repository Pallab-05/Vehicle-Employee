package com.example.Junit_Mockito.service;

import com.example.Junit_Mockito.entity.Employee;
import com.example.Junit_Mockito.exception.EmployeeNotFoundException;
import com.example.Junit_Mockito.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl  {


    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    private static Logger logger= LoggerFactory.getLogger(EmployeeServiceImpl.class);

    public Employee saveEmployee(Employee employee) {

        Optional<Employee> savedEmployee = employeeRepository.findByEmail(employee.getEmail());
        if(savedEmployee.isPresent()){
            throw new RuntimeException("Employee already exist with given email:" + employee.getEmail());
        }
        return employeeRepository.save(employee);
    }


    public List<Employee> getAllEmployees() {
        List<Employee> employee=employeeRepository.findAll();
        return employee;
    }


    public Optional<Employee> getEmployeeById(long id) {
        Employee getSingleEmployee=employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Not found Employee with id = " + id));
        return Optional.ofNullable(getSingleEmployee);
    }


    public Employee updateEmployee(Employee employee,long id) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Not found Employee with id = " + id));

        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());

        employeeRepository.save(existingEmployee);
        return existingEmployee;
    }

    public void deleteEmployee(long id) {
        employeeRepository.deleteById(id);
    }
}
