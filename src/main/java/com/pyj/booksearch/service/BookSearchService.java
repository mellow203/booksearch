package com.pyj.booksearch.service;

import java.io.IOException;
import java.util.*;

import javax.crypto.interfaces.PBEKey;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pyj.booksearch.dto.BookDTO;
import com.pyj.booksearch.util.APIAccessor;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional(readOnly = true)
public class  BookSearchService {

    private final ObjectMapper objectMapper;
    private final APIAccessor apiAccessor;

    public BookSearchService(ObjectMapper objectMapper, APIAccessor apiAccessor) {
        this.objectMapper = objectMapper;
        this.apiAccessor = apiAccessor;
    }



    public BookDTO.Response retrieveBook(String keyword) throws IOException {
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.add("target", "title");
        queryParams.add("query", keyword);

     /*   Map<String, Object> queryParams = new LinkedHashMap<>();
        queryParams.put("query", keyword);
        queryParams.put("target", "title");
*/
  /*
        Map<String, ApiResult> result =  this.apiAccessor.request(HttpMethod.GET, "/v3/search/book?target=title&query={query}", param);
        List<BookDTO> resultList = this.objectMapper.readValue(result.get("documents").toString(), new TypeReference<Map<String, Object>>() {});*/


        return  this.apiAccessor.exchange( "/v3/search/book", HttpMethod.GET, queryParams,null ,
                new ParameterizedTypeReference<BookDTO.Response>() {});
    }
}
