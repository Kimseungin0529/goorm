package com.doong.exp.program0906.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    private String title;
    private String author;
    private int publishedYear;
    private String genre;
    // 출판 연도, 장르는 걍 뻄;

}
