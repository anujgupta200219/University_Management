package com.example.University_Management.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long deptId;

    private String name;

    private String location;

    @OneToMany(mappedBy = "department")
    private Set<Student> student=new HashSet<>();
}
