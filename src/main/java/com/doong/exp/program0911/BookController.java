package com.doong.exp.program0911;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public List<BookDto> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public BookDto getBookById(@PathVariable String id) {
        return bookService.getBookById(id);
    }

    @PostMapping
    public void insertBook(@RequestBody BookDto book) {
        bookService.insertBook(book);
    }
}