package springboot.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import springboot.spring.entity.DepartmentEntity;


public interface DepartmentRepository extends CrudRepository<DepartmentEntity, Integer>{

}
