package com.pyj.booksearch.service;

import com.pyj.booksearch.dto.History;
import com.pyj.booksearch.jpa.HistoryRepository;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pyj.booksearch.dto.BookDTO;
import com.pyj.booksearch.util.APIAccessor;
import java.util.List;

@Service
@Transactional
public class  BookSearchService {
    @Autowired
    HistoryRepository historyRepository;

    private final ObjectMapper objectMapper;
    private final APIAccessor apiAccessor;

    public BookSearchService(ObjectMapper objectMapper, APIAccessor apiAccessor, HistoryRepository historyRepository) {
        this.objectMapper = objectMapper;
        this.apiAccessor = apiAccessor;
        this.historyRepository = historyRepository;
    }

    public BookDTO.Response retrieveBook(String keyword) {
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.add("target", "title");
        queryParams.add("query", keyword);
        String date = new DateTime().toString("yyyy-MM-dd HH:mm:ss");
        historyRepository.save(new History(keyword, date));
        return  this.apiAccessor.exchange( "/v3/search/book", HttpMethod.GET, queryParams,null ,
                new ParameterizedTypeReference<BookDTO.Response>() {});
    }

    public List<History> retrieveHistory(){
        return this.historyRepository.findAll();
    }
}
