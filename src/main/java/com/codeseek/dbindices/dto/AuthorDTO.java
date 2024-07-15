package com.codeseek.dbindices.dto;

import com.codeseek.dbindices.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDTO {
    private Long id;

    private String name;

    private int birthYear;

    private List<AuthorBookDTO> books;
}
