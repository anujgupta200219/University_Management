package com.example.University_Management.DTO.Request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class courseRequestDTO {

    private String title;

    private int credit;
}
