package com.doong.exp.program0911;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Mapper
public interface BookMapper {
    List<BookDto> getAllBooks();
    BookDto getBookById(String id);
    void insertBook(BookDto book);
}
