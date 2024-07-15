package com.codeseek.dbindices.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorBookDTO {
    private Long id;

    private String title;

    private String genre;

    private int publishedYear;

    private String isbn;

    private int copies;
}
