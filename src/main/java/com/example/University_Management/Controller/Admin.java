package com.example.University_Management.Controller;

import com.example.University_Management.DTO.Course_Request_DTO;
import com.example.University_Management.DTO.Department_Request_DTO;
import com.example.University_Management.Service.Department_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
@RequestMapping(value = "/admin")
public class Admin {

    @Autowired
    private Department_Service departmentService;

    @PostMapping("/savedepartment")
    public ResponseEntity<?> saveDepartment(@RequestBody Department_Request_DTO departmentRequestDto){
        return new ResponseEntity<>(departmentService.saveDepartment(departmentRequestDto), HttpStatus.OK);
    }

    @PostMapping
    public void saveCourse(@RequestBody Course_Request_DTO courseRequestDto){

    }
}
