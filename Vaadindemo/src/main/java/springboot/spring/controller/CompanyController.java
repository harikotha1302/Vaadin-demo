package springboot.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import springboot.spring.entity.DepartmentEntity;
import springboot.spring.entity.EmployeeEntity;
import springboot.spring.services.Departmentservice;
import springboot.spring.services.Employeeservice;

@RestController
public class CompanyController {

	@Autowired
	private Employeeservice es;
	
	@Autowired
	private Departmentservice ds;
	
	@RequestMapping(method=RequestMethod.GET,value="/employee")
	public List<EmployeeEntity> getEmployee()
	{
		return es.getEmployee();
		
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/employee/{id}")
	public EmployeeEntity getEmployeebyid(@PathVariable int id)
	{
		return es.getEmployeebyid(id);
		
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/employee")
	public void addEmployee(@RequestBody EmployeeEntity employee)
	{
		es.addEmployee(employee);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/employee")
	public void updateEmployee(@RequestBody EmployeeEntity employee)
	{
		es.updateEmployee(employee);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/employee/{id}")
	public void deleteEmployee(@PathVariable int id)
	{
		es.deleteEmployee(id);
	}
	
	/*------------Department CRUD operations-------------*/
	@RequestMapping(method=RequestMethod.GET,value="/department")
	public List<DepartmentEntity> getDepartment()
	{
		return ds.getDepartment();
		
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/employee/{id}/department")
	public List<DepartmentEntity> getDepartmentbyid(@PathVariable int id)
	{
		return ds.getDepartmentbyid(id);
		
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/department")
	public void addDepartment(@RequestBody DepartmentEntity dep)
	{
		ds.addDepartment(dep);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/department")
	public void updateDepartment(@RequestBody DepartmentEntity dep)
	{
		ds.updateDepartment(dep);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/department/{id}")
	public void deleteDepartment(@PathVariable int id)
	{
		ds.deleteDepartment(id);
	}
}
