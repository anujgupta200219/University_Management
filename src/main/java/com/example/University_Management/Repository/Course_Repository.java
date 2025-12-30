package com.example.University_Management.Repository;

import com.example.University_Management.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Course_Repository extends JpaRepository<Course,Long> {
}
