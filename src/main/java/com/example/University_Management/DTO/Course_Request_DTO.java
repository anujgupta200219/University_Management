package com.example.University_Management.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Course_Request_DTO {

    private String title;

    private int credit;
}
