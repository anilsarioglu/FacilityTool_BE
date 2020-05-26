package edu.ap.facilitytoolspringboot.services;

import edu.ap.facilitytoolspringboot.models.Employee;
import edu.ap.facilitytoolspringboot.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAll() {
       return employeeRepository.findAll();
    }

    public Employee getById(String id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.orElse(null);
    }

    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }
}
