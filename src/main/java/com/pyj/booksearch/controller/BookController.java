package com.pyj.booksearch.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pyj.booksearch.dto.BookDTO;
import com.pyj.booksearch.service.BookSearchService;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookSearchService bookSearchService;

    public BookController(BookSearchService bookSearchService) {this.bookSearchService = bookSearchService;}

    @GetMapping("/search/{keyword}")
    public BookDTO.Response  retrieveBook(@PathVariable String  keyword) throws IOException {
        //userid는 시큐어리티로 넘겨받아야함
        return this.bookSearchService.retrieveBook(keyword);
    }
}
