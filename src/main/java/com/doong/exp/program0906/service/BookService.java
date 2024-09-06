package com.doong.exp.program0906.service;

import com.doong.exp.program0906.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service @Slf4j
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
}
