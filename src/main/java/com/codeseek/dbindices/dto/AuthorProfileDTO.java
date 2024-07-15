package com.codeseek.dbindices.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorProfileDTO {
    private Long id;

    private String name;

    private int birthYear;
}
