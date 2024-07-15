package com.codeseek.dbindices.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private Long id;

    private String title;

    private Author author;

    private String genre;

    private int publishedYear;

    private String isbn;

    private int copies;
}
