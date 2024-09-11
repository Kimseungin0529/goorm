package com.doong.exp.program0911;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Book1 {
    @Id @GeneratedValue
    private Long id;
    private String title;
    private String author;
    private String publisher;
    private LocalDate date;

    @Builder
    public Book1(String title, String author, String publisher, LocalDate date) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.date = date;
    }


}
