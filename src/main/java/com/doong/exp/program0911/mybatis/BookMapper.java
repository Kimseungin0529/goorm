package com.doong.exp.program0911.mybatis;

import com.doong.exp.program0906.Book;
import com.doong.exp.program0911.BookDto;
import jakarta.validation.constraints.AssertFalse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface BookMapper {

    // 도서 등록
    void insertBook(Book book);

    // 도서 조회 by ID
    Optional<Book> findById(Long id);

    // 도서 수정
    void updateBook(Book book);

    // 도서 삭제
    void deleteBookById(Long id);

    // 전체 도서 조회
    List<Book> findAllBooks();
}