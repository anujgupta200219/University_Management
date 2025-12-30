package com.example.University_Management.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long profileId;

    private long phone;

    private String address;

    @OneToOne
    @JoinColumn(name = "Many_Students", unique = true)
    private Student student;

}
