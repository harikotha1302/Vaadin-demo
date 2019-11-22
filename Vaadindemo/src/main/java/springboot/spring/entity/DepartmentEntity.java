package springboot.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@Entity(name="department")
@Table(name="department")
public class DepartmentEntity {

	@Id
	@Column(name="departmentid")
	private int departmentid;
	
	@ManyToOne(targetEntity=EmployeeEntity.class)
	@JoinColumn(name="employeeid")
	private EmployeeEntity employee;
	
	@Column(name="departmentname")
	private String departmentname;

	public DepartmentEntity() {
		super();
	}

	public DepartmentEntity(int departmentid, EmployeeEntity employee, String departmentname) {
		super();
		this.departmentid = departmentid;
		this.employee = employee;
		this.departmentname = departmentname;
	}

	public int getDepartmentid() {
		return departmentid;
	}

	public void setDepartmentid(int departmentid) {
		this.departmentid = departmentid;
	}

	public EmployeeEntity getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeEntity employee) {
		this.employee = employee;
	}

	public String getDepartmentname() {
		return departmentname;
	}

	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}
	
	
	
}
