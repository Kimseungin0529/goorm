package com.doong.exp.program0906;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Objects;

/**
 * 1. 스프링 부트 설정
 * 2. 도서 엔티티(Book) 정의
 *     • id (Long) : 기본 키, 자동 증가
 *     • title (String) : 책 제목
 *     • author (String) : 저자
 *     • publishedYear (int) : 출판 연도
 *     • genre (String) : 장르
 * 3. BookRepository 인터페이스 생성
 * 4. API 기능 구현 (BookController)
 *     • 전체 도서 조회: GET /books
 *     • 도서 조회 by ID: GET /books/{id}
 *     • 새로운 도서 추가: POST /books (JSON 요청 바디에 도서 정보 포함)
 *     • 도서 정보 수정: PUT /books/{id} (수정할 도서 정보 포함)
 *     • 도서 삭제: DELETE /books/{id}
 * 5. Postman 사용하여 API 테스트 수행
 */
@Entity @Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Book {
    @Id @GeneratedValue
    private Long id;
    private String title;
    private String author;
    private String publisher;
    private LocalDate publishedDate;


    @Builder
    public Book(String title, String author, String publisher, LocalDate publishedDate) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publishedDate = publishedDate;
    }

    public void updateTitle(String title){
        if(title.isEmpty()){
            return;
        }
        this.title = title;
    }
    public void updateAuthor(String author){
        if(author.isEmpty()){
            return;
        }
        this.author = author;
    }

}
