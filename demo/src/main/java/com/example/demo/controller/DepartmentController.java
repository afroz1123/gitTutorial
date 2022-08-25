package com.example.demo.controller;

import com.example.demo.Entity.Department;
import com.example.demo.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/departments")
    public ResponseEntity<Department> saveDepartment(@RequestBody Department department)
    {
        //return ResponseEntity.status(HttpStatus.ACCEPTED).body(departmentService.saveDepartment(department));
        return ResponseEntity.ok().body(departmentService.saveDepartment(department));
    }
    @GetMapping("/departments")
    public List<Department> fetchDepartmentsList()
    {
        return departmentService.fetchDepartmentsList();
    }

    @GetMapping("/departments/{id}")
    public ResponseEntity<?> fetchDepartmentByid(@PathVariable Long id/*departmentId*/)
    {
        Department department=departmentService.fetchDepartmentByid(id);
        if(department==null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ID does not exists");
        }
        else{
            return ResponseEntity.ok().body(department);
        }
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentByid(@PathVariable("id")Long departmentId)
    {
        departmentService.deleteDepartmentByid(departmentId);
        return "Successfully deleted";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartmentById(@PathVariable("id") Long departmentId,@RequestBody Department department)
    {
        return departmentService.updateDepartmentById(departmentId,department);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchByDepartmentName(@PathVariable("name") String departmentname)
    {
        return departmentService.findByDepartmentName(departmentname);
    }

    @GetMapping(value = {"/dept","/dept/{id}"})
    public String returnvalue(@PathVariable(required = false)String id)
    {
        if(id==null)
        {
            return "Empty string";
        }
        else{
            return "Not empty";
        }
    }
}
