package edu.ap.facilitytoolspringboot.controllers;

import edu.ap.facilitytoolspringboot.models.Employee;
import edu.ap.facilitytoolspringboot.services.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class EmployeeController {
    private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAll() {
        try {
            List<Employee> employees = employeeService.getAll();
            if (employees.isEmpty()) {
                LOG.info("There are no employees to return");
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            LOG.info("Returned all employees");
            return new ResponseEntity<>(employees, HttpStatus.OK);
        } catch (Exception e) {
            LOG.error("Couldn't return the employees", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/employees/by-id/{id}")
    public ResponseEntity<Employee> getById(@PathVariable("id") String id) {
        try {
            Employee employee = employeeService.getById(id);
            if (employee == null) {
                LOG.info("There is no employee with the id: {}", id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            LOG.info("Returned the employee with id: {}", id);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } catch (Exception e) {
            LOG.error("Couldn't return the employee with id: {}", id, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> postCategory(@RequestBody Employee employee) {
        try {
            Employee emp = employeeService.create(employee);
            LOG.info("Created a new employee");
            return new ResponseEntity<>(emp, HttpStatus.CREATED);
        } catch (Exception e) {
            LOG.info("Couldn't create a new employee", e);
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
