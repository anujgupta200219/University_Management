package com.example.University_Management.Service;


import com.example.University_Management.DTO.Request.courseRequestDTO;
import com.example.University_Management.Entity.Course;
import com.example.University_Management.Repository.Course_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Course_Service {

    @Autowired
    private Course_Repository courseRepository;

    public String saveCourse(courseRequestDTO courseRequestDto){
        Course course=new Course();
        course.setTitle(courseRequestDto.getTitle());
        course.setCredit(courseRequestDto.getCredit());
        try{
            courseRepository.save(course);
            return "Saved Successfully";
        }
        catch (Exception e){
            return ""+e;
        }
    }
}
