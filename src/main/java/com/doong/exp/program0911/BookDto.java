package com.doong.exp.program0911;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Data
public class BookDto {
    private String id;
    private String title;
    private String author;
    private String publisher;
    private LocalDate publishedDate;
}
