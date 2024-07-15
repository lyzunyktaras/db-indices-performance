package com.codeseek.dbindices.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    private Long id;

    private String name;

    private int birthYear;

    private List<Book> books;
}
