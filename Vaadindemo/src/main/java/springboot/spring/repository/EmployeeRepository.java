package springboot.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import springboot.spring.entity.EmployeeEntity;


public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Integer> {

}
