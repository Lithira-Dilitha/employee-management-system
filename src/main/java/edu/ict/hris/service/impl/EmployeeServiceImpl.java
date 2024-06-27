package edu.ict.hris.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.ict.hris.dto.Employee;
import edu.ict.hris.entity.EmployeeEntity;
import edu.ict.hris.repository.EmployeeRepository;
import edu.ict.hris.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    final EmployeeRepository repository;

    final ObjectMapper mapper;

    @Override
    public void addEmployee(Employee employee) {
        repository.save(mapper.convertValue(employee, EmployeeEntity.class));
    }

    @Override
    public List<Employee> getAll() {
        Iterable<EmployeeEntity> employeeEntities = repository.findAll();
        List<Employee> employeeList = new ArrayList<>();
        employeeEntities.forEach(employeeEntity ->{
            employeeList.add(mapper.convertValue(employeeEntity,Employee.class));
        });
        return employeeList;
    }

    @Override
    public void deleteEmployeeById(Long id) {
        if(repository.findById(id).isPresent()){
            repository.deleteById(id);
        }
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        if(repository.findById(employee.getId()).isPresent()){
            EmployeeEntity save = repository.save(mapper.convertValue(employee, EmployeeEntity.class));
           return mapper.convertValue(save, Employee.class);
        }
        return new Employee();
    }

    @Override
    public Employee findById(Long id) {
        if(repository.findById(id).isPresent()){
            return mapper.convertValue(repository.findById(id).get(),Employee.class);
        }
        return new Employee();
    }

    @Override
    public Employee findByFirstName(String name) {
        return mapper.convertValue(repository.findByFirstName(name),Employee.class);
    }
}
