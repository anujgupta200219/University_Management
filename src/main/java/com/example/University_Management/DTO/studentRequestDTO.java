package com.example.University_Management.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class studentRequestDTO {
    private String name;
    private String email;
    private Long departmentId;
    private List<Long> courseIds;
}
