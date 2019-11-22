package springboot.spring.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springboot.spring.entity.DepartmentEntity;
import springboot.spring.repository.DepartmentRepository;

@Repository
public class DepartmentDAO {

	@Autowired
	private DepartmentRepository dr;

	public List<DepartmentEntity> getDepartment() {
		List<DepartmentEntity> list=new ArrayList<DepartmentEntity>();
		for(DepartmentEntity dt:dr.findAll())
		{
			list.add(dt);
		}
		return list;
	}

	public List<DepartmentEntity> getDepartmentbyid(int id) {
		List<DepartmentEntity> list=new ArrayList<DepartmentEntity>();
		for(DepartmentEntity dt:dr.findAll())
		{
			if(dt.getEmployee().getEmployeeid()==id)
			{
				list.add(dt);
			}
		}
		return list;
	}

	public void addDepartment(DepartmentEntity dep) {
		dr.save(dep);
		
	}

	public void deleteDepartment(int id) {
		dr.deleteById(id);
		
	}
	
	
}
