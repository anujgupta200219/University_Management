package com.example.University_Management.Controller;

import com.example.University_Management.DTO.courseRequestDTO;
import com.example.University_Management.DTO.departmentRequestDTO;
import com.example.University_Management.DTO.studentProfileDTO;
import com.example.University_Management.DTO.studentRequestDTO;
import com.example.University_Management.Service.Course_Service;
import com.example.University_Management.Service.Department_Service;
import com.example.University_Management.Service.Student_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@RestController
@RequestMapping(value = "/admin")
public class Admin {

    @Autowired
    private Department_Service departmentService;

    @Autowired
    private Course_Service courseService;

    @Autowired
    private Student_Service studentService;

    @PostMapping("/savedepartment")
    public ResponseEntity<?> saveDepartment(@RequestBody departmentRequestDTO departmentRequestDto){
        return new ResponseEntity<>(departmentService.saveDepartment(departmentRequestDto), HttpStatus.OK);
    }

    @PostMapping("/savecourse")
    public ResponseEntity<?> saveCourse(@RequestBody courseRequestDTO courseRequestDto){
        return new ResponseEntity<>(courseService.saveCourse(courseRequestDto),HttpStatus.OK);
    }

    @PostMapping("/savestudent")
    public ResponseEntity<?> saveStudent(@RequestBody studentRequestDTO studentRequestDTO){
        try{
            studentService.saveStudent(studentRequestDTO);
            return new ResponseEntity<>("Student "+studentRequestDTO.getName()+" saved",HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/saveprofile")
    public ResponseEntity<?> saveProfile(@RequestBody studentProfileDTO studentProfileDTO){
        try{
            studentService.saveStudentProfile(studentProfileDTO);
            return new ResponseEntity<>("Student Profile Saved",HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateprofile")
    public ResponseEntity<?> updateProfile(@RequestBody studentProfileDTO studentProfileDTO){
        try{
            studentService.saveStudentProfile(studentProfileDTO);
            return new ResponseEntity<>("Student Profile Updated",HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
}
