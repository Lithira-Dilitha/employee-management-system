package edu.ict.hris.controller.employee;

import edu.ict.hris.dto.Employee;
import edu.ict.hris.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp-controller")
@RequiredArgsConstructor
public class EmployeeController {

    final EmployeeService employeeService;

    @PostMapping("/employee")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody Employee employee){
       employeeService.addEmployee(employee);
    }

    @GetMapping("/employees")
    public List<Employee> getAll(){
        return employeeService.getAll();
    }

    @DeleteMapping("/employee/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployeeById(id);
        return "Deleted !";
    }

    @PatchMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee employee){
       return employeeService.updateEmployee(employee);
    }

    @GetMapping("/get-employee-by-id/{id}")
    public Employee findById(@PathVariable Long id){
        return employeeService.findById(id);
    }

    @GetMapping("/get-employee-by-name/{name}")
    public Employee findByFirstName(@PathVariable String name){
        return employeeService.findByFirstName(name);
    }
}
