package com.doong.exp.program0911;

import com.doong.exp.program0906.service.BookService;
import com.doong.exp.program0911.mybatis.BookServiceMyBatis;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

/*
@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    //private final BookServiceMyBatis bookService;
    private final BookService bookService;
    @PutMapping("/{id}")
    public ResponseEntity<?> updateBook(@PathVariable String id) {
        bookService.updateBookcById(id);
        return ResponseEntity.ok("정상적으로 변경됐습니다.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBookById(@PathVariable String id) {
        bookService.getBookById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<?> insertBook(@RequestBody BookDto book) {
        Long createdBookId = bookService.insertBook(book);
        URI uri = URI.create(String.format("/books/%d", createdBookId));
        return ResponseEntity.created(uri).build();
    }
}*/
