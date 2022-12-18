package com.employee.employeemanagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
//table B
public class EmpDept {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long empDeptID;
	private String deptName;
	private String manager;
	// foreign key of table A->Employee
	@OneToOne
	@JoinColumn(name = "EMP_ID")
	private Employee employee;

	@OneToOne(mappedBy = "empDept", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnoreProperties("empDeptLocation")
	private EmpDeptLocation empDeptLocation;

	@OneToOne(mappedBy = "empDept", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnoreProperties("empproject")
	private EmpProject empproject;

	public EmpDept() {
		super();
	}

	public EmpDept(Long empDeptID, String deptName, String manager, Employee employee, EmpDeptLocation empDeptLocation,
			EmpProject empproject) {
		super();
		this.empDeptID = empDeptID;
		this.deptName = deptName;
		this.manager = manager;
		this.employee = employee;
		this.empDeptLocation = empDeptLocation;
		this.empproject = empproject;
	}

	public Long getEmpDeptID() {
		return empDeptID;
	}

	public void setEmpDeptID(Long empDeptID) {
		this.empDeptID = empDeptID;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public EmpDeptLocation getEmpDeptLocation() {
		return empDeptLocation;
	}

	public void setEmpDeptLocation(EmpDeptLocation empDeptLocation) {
		this.empDeptLocation = empDeptLocation;
	}

	public EmpProject getEmpproject() {
		return empproject;
	}

	public void setEmpproject(EmpProject empproject) {
		this.empproject = empproject;
	}

	@Override
	public String toString() {
		return "EmpDept [empDeptID=" + empDeptID + ", deptName=" + deptName + ", manager=" + manager + ", employee="
				+ employee + ", empDeptLocation=" + empDeptLocation + ", empproject=" + empproject + "]";
	}

}
