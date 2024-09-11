package com.doong.exp.program0911;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {


    private final BookMapper bookMapper;

    public List<BookDto> getAllBooks() {
        return bookMapper.getAllBooks();
    }

    public BookDto getBookById(String id) {
        return bookMapper.getBookById(id);
    }

    public void insertBook(BookDto book) {
        bookMapper.insertBook(book);
    }
}