package springboot.spring.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springboot.spring.entity.EmployeeEntity;
import springboot.spring.repository.EmployeeRepository;

@Repository
public class EmployeeDao {

	
	@Autowired
	private EmployeeRepository emr;

	public List<EmployeeEntity> getEmployee() {
		List<EmployeeEntity> list=new ArrayList<EmployeeEntity>();
		for(EmployeeEntity et:emr.findAll())
		{
			list.add(et);
		}
		 return list;
	}

	public void addEmployee(EmployeeEntity employee) {
		emr.save(employee);
		
	}

	public EmployeeEntity getEmployeebyid(int id) {
		// TODO Auto-generated method stub
		return emr.findById(id).get();
	}

	public void deleteEmployee(int id) {
		emr.deleteById(id);
		
	}
}
