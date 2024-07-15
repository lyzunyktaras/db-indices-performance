package com.codeseek.dbindices.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Borrower {
    private Long id;

    private String name;

    private String email;

    private String phone;

    private String address;

    private List<BorrowedBook> borrowedBooks;
}
