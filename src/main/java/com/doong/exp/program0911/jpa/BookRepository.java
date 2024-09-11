package com.doong.exp.program0911.jpa;

import com.doong.exp.program0906.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
