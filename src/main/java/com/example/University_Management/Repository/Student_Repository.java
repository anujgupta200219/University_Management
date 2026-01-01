package com.example.University_Management.Repository;

import com.example.University_Management.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Student_Repository extends JpaRepository<Student,Long> {
}
