package springboot.spring.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.spring.DAO.EmployeeDao;
import springboot.spring.entity.EmployeeEntity;

@Service
public class Employeeservice {

	@Autowired
	private EmployeeDao ed;

	public List<EmployeeEntity> getEmployee() {
		return ed.getEmployee();
	}

	public void addEmployee(EmployeeEntity employee) {
		ed.addEmployee(employee);
		
	}

	public EmployeeEntity getEmployeebyid(int id) {
		return ed.getEmployeebyid(id);
	}

	public void updateEmployee(EmployeeEntity employee) {
		ed.addEmployee(employee);
	}

	public void deleteEmployee(int id) {
		ed.deleteEmployee(id);
		
	}
}
