package com.employee.employeemanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
//table c
public class EmpDeptLocation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long deptLocationId;
	private String locationName;
	@OneToOne // b (empDept1)is foriegn key of table B
	@JoinColumn(name = "EMP_Dept1")
	private EmpDept empDept;
	@OneToOne // a (Employee)is foriegn key of table A
	@JoinColumn(name = "EMP_ID")
	@JsonIgnoreProperties("employee")
	private Employee employee;

	public EmpDeptLocation() {
		super();
	}

	public EmpDeptLocation(Long deptLocationId, String locationName, EmpDept empDept, Employee employee) {
		super();
		this.deptLocationId = deptLocationId;
		this.locationName = locationName;
		this.empDept = empDept;
		this.employee = employee;
	}

	public Long getDeptLocationId() {
		return deptLocationId;
	}

	public void setDeptLocationId(Long deptLocationId) {
		this.deptLocationId = deptLocationId;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public EmpDept getEmpDept() {
		return empDept;
	}

	public void setEmpDept(EmpDept empDept) {
		this.empDept = empDept;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "EmpDeptLocation [deptLocationId=" + deptLocationId + ", locationName=" + locationName + ", empDept="
				+ empDept + ", employee=" + employee + "]";
	}

	
}
