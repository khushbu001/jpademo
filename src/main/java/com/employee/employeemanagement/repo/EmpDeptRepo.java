package com.employee.employeemanagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.employeemanagement.entity.EmpDept;

@Repository
public interface EmpDeptRepo extends JpaRepository<EmpDept, Long> {

}
