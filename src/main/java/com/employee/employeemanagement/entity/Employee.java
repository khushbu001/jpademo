package com.employee.employeemanagement.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity // table A
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long empId;

	private String name;

	private Integer age;

	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnoreProperties("empFamily")
	private Set<EmpFamily> empFamily;
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnoreProperties("empAddress")
	private Set<EmpAddress> empAddress;
	@OneToOne(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnoreProperties("comMedia")
	private EmpCommunicationMedia comMedia;
	@OneToOne(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnoreProperties("empDept")
	private EmpDept empDept;
	@OneToOne(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnoreProperties("empDeptLocation")
	private EmpDeptLocation empDeptLocation;

	public Employee() {
		super();
	}

	public Employee(Long empId, String name, Integer age, Set<EmpFamily> empFamily, Set<EmpAddress> empAddress,
			EmpCommunicationMedia comMedia, EmpDept empDept, EmpDeptLocation empDeptLocation) {
		super();
		this.empId = empId;
		this.name = name;
		this.age = age;
		this.empFamily = empFamily;
		this.empAddress = empAddress;
		this.comMedia = comMedia;
		this.empDept = empDept;
		this.empDeptLocation = empDeptLocation;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Set<EmpFamily> getEmpFamily() {
		return empFamily;
	}

	public void setEmpFamily(Set<EmpFamily> empFamily) {
		this.empFamily = empFamily;
	}

	public Set<EmpAddress> getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(Set<EmpAddress> empAddress) {
		this.empAddress = empAddress;
	}

	public EmpCommunicationMedia getComMedia() {
		return comMedia;
	}

	public void setComMedia(EmpCommunicationMedia comMedia) {
		this.comMedia = comMedia;
	}

	public EmpDept getEmpDept() {
		return empDept;
	}

	public void setEmpDept(EmpDept empDept) {
		this.empDept = empDept;
	}

	public EmpDeptLocation getEmpDeptLocation() {
		return empDeptLocation;
	}

	public void setEmpDeptLocation(EmpDeptLocation empDeptLocation) {
		this.empDeptLocation = empDeptLocation;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", age=" + age + ", empFamily=" + empFamily
				+ ", empAddress=" + empAddress + ", comMedia=" + comMedia + ", empDept=" + empDept
				+ ", empDeptLocation=" + empDeptLocation + "]";
	}
}
