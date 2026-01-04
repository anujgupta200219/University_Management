package com.example.University_Management.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class studentProfileDTO {

    private long studentId;

    private long phone;

    private String address;
}
