package com.pyj.booksearch.service;


import com.pyj.booksearch.jpa.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryService {
    @Autowired
    HistoryRepository historyRepository;
}
