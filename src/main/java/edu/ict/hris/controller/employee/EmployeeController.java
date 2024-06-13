package edu.ict.hris.controller.employee;

import edu.ict.hris.dto.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp-controller")
public class EmployeeController {
    List<Employee> employeeList;

    @PostMapping("employee")
    public void add(@RequestBody Employee employee){
       employeeList.add(employee);
    }

    @GetMapping("/Emplyees")
    public List<Employee> getAll(){
        return employeeList;
    }
}
