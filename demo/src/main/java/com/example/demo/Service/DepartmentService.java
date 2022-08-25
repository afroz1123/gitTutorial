package com.example.demo.Service;

import com.example.demo.Entity.Department;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DepartmentService {
    public Department saveDepartment(Department department);

    List<Department> fetchDepartmentsList();

    Department fetchDepartmentByid(Long departmentId);

    void deleteDepartmentByid(Long departmentId);

    Department updateDepartmentById(Long departmentId, Department department);

    Department findByDepartmentName(String departmentname);
}
