package com.employee.employeemanagement.entity;

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
	@OneToOne // a (empDept1)is foriegn key of table b
	@JoinColumn(name = "EMP_Dept1")
	private EmpDept empDept1;
	// @OneToOne // b(empDept2) is foreign key of table b
	// multiple representation of same entity will raise exception
	/*
	 * @JoinColumn(name = "EMP_Dept2") private EmpDept empDept2;
	 */

	public EmpDeptLocation() {
		super();
	}

	public EmpDeptLocation(Long deptLocationId, String locationName, EmpDept empDept1) {
		super();
		this.deptLocationId = deptLocationId;
		this.locationName = locationName;
		this.empDept1 = empDept1;
		// this.empDept2 = empDept2;
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

	public EmpDept getEmpDept1() {
		return empDept1;
	}

	public void setEmpDept1(EmpDept empDept1) {
		this.empDept1 = empDept1;
	}

	/*
	 * public EmpDept getEmpDept2() { return empDept2; }
	 * 
	 * public void setEmpDept2(EmpDept empDept2) { this.empDept2 = empDept2; }
	 */

	@Override
	public String toString() {
		return "EmpDeptLocation [deptLocationId=" + deptLocationId + ", locationName=" + locationName + ", empDept1="
				+ empDept1 + "]";
	}

}
