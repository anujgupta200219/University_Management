package com.example.University_Management.Service;


import com.example.University_Management.DTO.departmentRequestDTO;
import com.example.University_Management.Entity.Department;
import com.example.University_Management.Repository.Department_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Department_Service {

    @Autowired
    private Department_Repository departmentRepository;

    public String saveDepartment(departmentRequestDTO departmentRequestDto){
        Department department=new Department();
        department.setName(departmentRequestDto.getName());
        department.setLocation(departmentRequestDto.getLocation());
        try{
            departmentRepository.save(department);
            return "Saved Successfully!!";
        }
        catch (Exception e){
            return " "+e.getMessage();
        }
    }
}
