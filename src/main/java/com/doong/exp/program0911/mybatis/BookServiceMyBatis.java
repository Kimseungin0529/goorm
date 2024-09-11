package com.doong.exp.program0911.mybatis;

import com.doong.exp.program0906.Book;
import com.doong.exp.program0911.BookDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
@RequiredArgsConstructor
public class BookServiceMyBatis {

    private final BookMapper bookMapper;

    // 도서 등록
    public Long createBook(BookDto bookDto) {
        Book book = Book.builder()
                .title(bookDto.getTitle())
                .author(bookDto.getAuthor())
                .publishedDate(LocalDate.now())
                .publisher(bookDto.getPublisher())
                .build();
        bookMapper.insertBook(book);
        return book.getId();
    }

    // 도서 수정
    public void updateBook(Long bookId, BookDto bookDto) {
        Book book = bookMapper.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("없는 책입니다."));

        book.setTitle(bookDto.getTitle());
        book.setAuthor(bookDto.getAuthor());
        book.setPublisher(bookDto.getPublisher());

        bookMapper.updateBook(book);  // 수정된 도서 정보 저장
    }

    // 도서 삭제
    public void deleteBook(Long bookId) {
        Book book = bookMapper.findById(bookId)
                .orElseThrow(() -> new IllegalArgumentException("없는 책입니다."));
        bookMapper.deleteBookById(bookId);  // 도서 삭제
    }

    // 전체 도서 조회
    public List<Book> findAllBooks() {
        return bookMapper.findAllBooks();
    }
}
