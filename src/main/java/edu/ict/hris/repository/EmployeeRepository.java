package edu.ict.hris.repository;

import edu.ict.hris.entity.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<EmployeeEntity,Long> {
    EmployeeEntity findByFirstName(String name);
}
