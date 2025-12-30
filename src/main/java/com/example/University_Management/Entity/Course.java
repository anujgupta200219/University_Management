package com.example.University_Management.Entity;

import jakarta.persistence.*;
import jdk.jfr.Name;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long courseId;

    private String title;

    private int credit;

    @ManyToMany
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(referencedColumnName = "courseId"),
            inverseJoinColumns = @JoinColumn(referencedColumnName = "studentId")
    )
    private List<Student> student;
}
