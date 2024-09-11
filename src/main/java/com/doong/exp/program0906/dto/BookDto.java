package com.doong.exp.program0906.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    private String id;
    private String title;
    private String author;
    private String publisher;
    private LocalDate publishedDate;
    // 출판 연도, 장르는 걍 뻄;

}
