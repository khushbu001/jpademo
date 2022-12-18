package com.employee.employeemanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.employeemanagement.entity.EmpDept;
import com.employee.employeemanagement.entity.Employee;
import com.employee.employeemanagement.repo.EmpCommunicationRepo;
import com.employee.employeemanagement.repo.EmpDeptRepo;
import com.employee.employeemanagement.repo.EmpFamilyRepo;
import com.employee.employeemanagement.repo.EmpRepo;
import com.employee.employeemanagement.repo.EmpaddressRepo;

@Service
public class EmployeeService {
	Logger LOG = LoggerFactory.getLogger(EmployeeService.class);

	@Autowired
	private EmpRepo empRepo;

	@Autowired
	private EmpFamilyRepo empFamilyRepo;

	@Autowired
	private EmpCommunicationRepo commRepo;

	@Autowired
	private EmpaddressRepo addresssRepo;
	@Autowired
	private EmpDeptRepo empDeptRepo;

	public Employee createEmployee(Employee employee) {

		LOG.info("EmployeeService::createEmployee::Start");
		Employee emp = empRepo.save(employee);
		LOG.info("EmployeeService::createEmployee::End");

		return emp;
	}

	public Employee updateEmployee(Long empId, Employee employee) {

		LOG.info("EmployeeService::updateEmployee::Start");
		LOG.debug("empId: {}, employee: {}", empId, employee);

		Optional<Employee> updateEmployee = empRepo.findById(empId);
		LOG.debug("employee: {}", employee);
		Employee emp = new Employee();
		if (updateEmployee.isPresent()) {
			emp = updateEmployee.get();
		}
		emp.setEmpId(empId);
		emp.setName(employee.getName());
		emp.setAge(employee.getAge());
		emp.setComMedia(employee.getComMedia());
		emp.setEmpAddress(employee.getEmpAddress());
		emp.setEmpFamily(employee.getEmpFamily());

		LOG.info("EmployeeService::updateEmployee::End");
		return emp;

	}

	public void deleteEmpById(Long empId) {
		LOG.info("EmployeeService::deleteEmpById::Start");
		LOG.debug("empId: {}", empId);

		empRepo.deleteById(empId);

		LOG.info("EmployeeService::deleteEmpById::End");
	}

	public Employee getOneEmployee(Long empId) {

		LOG.info("EmployeeService::getOneEmployee::Start");

		LOG.debug("empId: {}", empId);
		Optional<Employee> emp = empRepo.findById(empId);
		Employee employee = new Employee();
		if (emp.isPresent()) {
			employee = emp.get();
		}
		LOG.info("EmployeeService::getOneEmployee::End");

		return employee;
	}

	public List<Employee> getAllEmployee() {

		LOG.debug("EmployeeService::getAllEmployee::Start");

		List<Employee> allEmployee = new ArrayList<>();
		empRepo.findAll().forEach(allEmployee::add);

		LOG.debug("EmployeeService::getAllEmployee::End");

		return allEmployee;
	}

	public List<Employee> getAllEmployeeByAgeAndName(Integer age, String city) {

		/*
		 * LOG.info("EmployeeService::getOneEmployee::Start");
		 * 
		 * LOG.debug("age: {}", age); Optional<Employee> emp =
		 * empRepo.findByAgeAndName(age, city); List<Employee> listEmp = new
		 * ArrayList<>();
		 * 
		 * if (emp.isPresent()) { Employee employee = emp.get(); listEmp.add(employee);
		 * } LOG.info("EmployeeService::getOneEmployee::End");
		 * 
		 * return listEmp;
		 */
		return null;
	}

	public EmpDept createDept(EmpDept empdept) {
		LOG.info("EmployeeService::createDept::Start");
		EmpDept empd = empDeptRepo.save(empdept);
		LOG.info("EmployeeService::createDept::End");

		return empd;
	}

}
