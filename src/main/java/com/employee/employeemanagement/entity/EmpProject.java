package com.employee.employeemanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity // table d
public class EmpProject {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long projectId;
	private String projectName;

	@OneToOne // b is foreign key of table B
	private EmpDept empDept;

	public EmpProject() {
		super();
	}

	public EmpProject(Long projectId, String projectName, EmpDept empDept) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.empDept = empDept;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public EmpDept getEmpDept() {
		return empDept;
	}

	public void setEmpDept(EmpDept empDept) {
		this.empDept = empDept;
	}

	@Override
	public String toString() {
		return "EmpProject [projectId=" + projectId + ", projectName=" + projectName + ", empDept=" + empDept + "]";
	}

}
