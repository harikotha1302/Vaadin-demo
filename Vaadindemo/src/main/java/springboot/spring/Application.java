package springboot.spring;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

import springboot.spring.entity.DepartmentEntity;
import springboot.spring.entity.EmployeeEntity;
import springboot.spring.repository.DepartmentRepository;
import springboot.spring.repository.EmployeeRepository;

@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}
	
	@Bean
	public DepartmentRepository Departmentrep()
	{
		return new DepartmentRepository() {
			
			@Override
			public <S extends DepartmentEntity> Iterable<S> saveAll(Iterable<S> arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public <S extends DepartmentEntity> S save(S arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Optional<DepartmentEntity> findById(Integer arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Iterable<DepartmentEntity> findAllById(Iterable<Integer> arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Iterable<DepartmentEntity> findAll() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean existsById(Integer arg0) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void deleteById(Integer arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void deleteAll(Iterable<? extends DepartmentEntity> arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void deleteAll() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void delete(DepartmentEntity arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public long count() {
				// TODO Auto-generated method stub
				return 0;
			}
		};
		
		
	}
	
	@Bean
	public EmployeeRepository employeerep()
	{
		return new EmployeeRepository() {
			
			@Override
			public <S extends EmployeeEntity> Iterable<S> saveAll(Iterable<S> arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public <S extends EmployeeEntity> S save(S arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Optional<EmployeeEntity> findById(Integer arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Iterable<EmployeeEntity> findAllById(Iterable<Integer> arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Iterable<EmployeeEntity> findAll() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean existsById(Integer arg0) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void deleteById(Integer arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void deleteAll(Iterable<? extends EmployeeEntity> arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void deleteAll() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void delete(EmployeeEntity arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public long count() {
				// TODO Auto-generated method stub
				return 0;
			}
		};
	}

}
