package com.example.University_Management.DTO.Response;

import com.example.University_Management.Entity.Course;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class studentResponseDTO {

    private String name;

    private String email;

    private long phone;

    private String address;

    private String Department;

    private List<String> course;
}
