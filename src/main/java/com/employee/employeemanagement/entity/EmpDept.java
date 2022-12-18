package com.employee.employeemanagement.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
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

	@OneToOne(mappedBy = "empDept1", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnoreProperties("empDeptLocation1")
	private EmpDeptLocation empDeptLocation1;

	/*
	 * @OneToOne(mappedBy = "empDept1", cascade = CascadeType.ALL, fetch =
	 * FetchType.LAZY)
	 * 
	 * @JsonIgnoreProperties("empDeptLocation2") private EmpDeptLocation
	 * empDeptLocation2;
	 */

	@OneToOne(mappedBy = "empDept", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnoreProperties("empproject")
	private EmpProject empproject;

	public EmpDept() {
		super();
	}

	@JsonCreator
	public EmpDept(Long empDeptID, String deptName, String manager, Employee employee, EmpDeptLocation empDeptLocation1,
			 EmpProject empproject) {
		super();
		this.empDeptID = empDeptID;
		this.deptName = deptName;
		this.manager = manager;
		this.employee = employee;
		this.empDeptLocation1 = empDeptLocation1;
		//this.empDeptLocation2 = empDeptLocation2;
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

	public EmpDeptLocation getEmpDeptLocation1() {
		return empDeptLocation1;
	}

	public void setEmpDeptLocation1(EmpDeptLocation empDeptLocation1) {
		this.empDeptLocation1 = empDeptLocation1;
	}

	/*
	 * public EmpDeptLocation getEmpDeptLocation2() { return empDeptLocation2; }
	 * 
	 * public void setEmpDeptLocation2(EmpDeptLocation empDeptLocation2) {
	 * this.empDeptLocation2 = empDeptLocation2; }
	 */

	public EmpProject getEmpproject() {
		return empproject;
	}

	public void setEmpproject(EmpProject empproject) {
		this.empproject = empproject;
	}

	@Override
	public String toString() {
		return "EmpDept [empDeptID=" + empDeptID + ", deptName=" + deptName + ", manager=" + manager + ", employee="
				+ employee + ", empDeptLocation1=" + empDeptLocation1 + ", empDeptLocation2=" 
				+ ", empproject=" + empproject + "]";
	}

}
