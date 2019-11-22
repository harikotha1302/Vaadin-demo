package springboot.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.spring.DAO.DepartmentDAO;
import springboot.spring.entity.DepartmentEntity;
import springboot.spring.entity.EmployeeEntity;

@Service
public class Departmentservice {

	@Autowired
	private DepartmentDAO dd;

	public List<DepartmentEntity> getDepartment() {
		// TODO Auto-generated method stub
		return dd.getDepartment();
	}

	public List<DepartmentEntity> getDepartmentbyid(int id) {
		// TODO Auto-generated method stub
		return dd.getDepartmentbyid(id);
	}

	public void addDepartment(DepartmentEntity dep) {
		// TODO Auto-generated method stub
		dd.addDepartment(dep);
	}

	public void updateDepartment(DepartmentEntity dep) {
		// TODO Auto-generated method stub
		dd.addDepartment(dep);
		
	}

	public void deleteDepartment(int id) {
		// TODO Auto-generated method stub
		dd.deleteDepartment(id);
	}
}
