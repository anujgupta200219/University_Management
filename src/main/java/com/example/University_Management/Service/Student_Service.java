package com.example.University_Management.Service;

import com.example.University_Management.DTO.Request.studentProfileDTO;
import com.example.University_Management.DTO.Request.studentRequestDTO;
import com.example.University_Management.DTO.Response.studentResponseDTO;
import com.example.University_Management.Entity.Course;
import com.example.University_Management.Entity.Department;
import com.example.University_Management.Entity.Student;
import com.example.University_Management.Entity.StudentProfile;
import com.example.University_Management.Exceptions.courseNotFoundException;
import com.example.University_Management.Exceptions.departmentNotFoundException;
import com.example.University_Management.Exceptions.studentNotFoundException;
import com.example.University_Management.Repository.Course_Repository;
import com.example.University_Management.Repository.Department_Repository;
import com.example.University_Management.Repository.StudentProfile_Repository;
import com.example.University_Management.Repository.Student_Repository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class Student_Service {

    @Autowired
    private Student_Repository studentRepository;

    @Autowired
    private Department_Repository departmentRepository;

    @Autowired
    private Course_Repository courseRepository;

    @Autowired
    private StudentProfile_Repository studentProfileRepository;

    @Transactional
    public Student saveStudent(studentRequestDTO studentRequestDTO){
        Optional<Department> department= departmentRepository.findById(studentRequestDTO.getDepartmentId());
        if(department.isEmpty()){
            throw new departmentNotFoundException("Department does not found");
        }

        List<Course> allById = courseRepository.findAllById(studentRequestDTO.getCourseIds());

        if(allById.size()!=studentRequestDTO.getCourseIds().size()){
            throw new courseNotFoundException("Some courses does not found");
        }

        Student student=new Student();
        student.setName(studentRequestDTO.getName());
        student.setEmail(studentRequestDTO.getEmail());
        student.setDepartment(department.get());
        student.setCourse(allById);

        return studentRepository.save(student);
    }

    @Transactional
    public StudentProfile saveStudentProfile(studentProfileDTO student){
        Optional<Student> byId = studentRepository.findById(student.getStudentId());
        if(byId.isEmpty()){
            throw new studentNotFoundException("Student not found");
        }
        StudentProfile profile = studentProfileRepository.findById(byId.get().getStudentProfile().getProfileId()).orElse(new StudentProfile());
        profile.setAddress(student.getAddress());
        profile.setPhone(student.getPhone());
        profile.setStudent(byId.get());
        return studentProfileRepository.save(profile);
    }

    public studentResponseDTO getStudentbyId(long id){
        Optional<Student> byId = studentRepository.findById(id);
        if (byId.isEmpty())
            throw new studentNotFoundException("Student with ID "+id+" not found");
        Student student=byId.get();
        return new studentResponseDTO(
                student.getName(),
                student.getEmail(),
                student.getStudentProfile().getPhone(),
                student.getStudentProfile().getAddress(),
                student.getDepartment().getName(),
                student.getCourse().stream().map(Course::getTitle).collect(Collectors.toList())
        );
    }
}
