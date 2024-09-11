package com.doong.exp.program0911.jpa;

import com.doong.exp.program0906.Book;
import com.doong.exp.program0911.BookDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceJpa {
    private final BookRepository bookRepository;

    public Long createBook(Long id, BookDto bookDto){
        Book book = Book.builder()
                .title(bookDto.getTitle())
                .author(bookDto.getAuthor())
                .publishedDate(LocalDate.now())
                .publisher(bookDto.getPublisher())
                .build();
        Book savedBook = bookRepository.save(book);
        return savedBook.getId();
    }

    public void updateBookById(String id, BookDto bookDto) {
        Book book = bookRepository.findById(Long.parseLong(id)).orElseThrow(() -> new IllegalArgumentException("없는 책입니다."));
        book.setTitle(book.getTitle());
        book.setAuthor(book.getAuthor());
        book.setPublisher(book.getPublisher());
    }

    public void deleteBookById(String id){
        Book findBook = bookRepository.findById(Long.parseLong(id)).orElseThrow(() -> new IllegalArgumentException("없는 책입니다."));
        bookRepository.delete(findBook);
    }

    public List<Book> findAllBooks(){
        return bookRepository.findAll();

    }

}
