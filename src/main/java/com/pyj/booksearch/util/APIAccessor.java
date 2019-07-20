package com.pyj.booksearch.util;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pyj.booksearch.dto.BookDTO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional(readOnly = true)
public class APIAccessor {
    private final ObjectMapper objectMapper;
    private final RestTemplate restTemplate;


    private static String HOST = "dapi.kakao.com";
    private String API_KEY="5a2ad314b1840ce01862821551592609"; //REST API
    private String ADMIN_KEY="2cecb450087737ae91aaace7256a4fb2"; //Admin API

    public APIAccessor(ObjectMapper objectMapper, RestTemplate restTemplate) {
        this.objectMapper = objectMapper;
        this.restTemplate = restTemplate;
    }


/*    public Map<String, BookDTO.Response> request(HttpMethod method,  String path,  Map<String, String> param) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "KakaoAK "+API_KEY);
        headers.setContentType(new MediaType("application","json",Charset.forName("UTF-8")));

        HttpEntity<Map<String, String>> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<String> responseEntity = this.restTemplate.exchange(HOST + path, HttpMethod.GET, httpEntity, String.class, param);

        Map<String, BookDTO.Response> response = this.objectMapper.readValue(responseEntity.getBody(), new TypeReference<Map<String, BookDTO.Response>>() {});
        return  response;
    }*/

    public <T> T exchange(String path, HttpMethod method, MultiValueMap<String, String> queryParams,
            Map<String, Object> body,
            ParameterizedTypeReference<T> responseType) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        headers.add("Authorization", "KakaoAK "+API_KEY);

        HttpEntity request = new HttpEntity(body, headers);

        if (queryParams == null) {
            queryParams = new LinkedMultiValueMap<>();
        }

        String uri = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host(HOST)
                .path(path)
                .queryParams(queryParams)
                .build()
                .toUriString();

        ResponseEntity<T> response = null;
        try {
            response = this.restTemplate.exchange(uri, method, request, responseType);
        } catch (Exception e) {
            throw new IllegalStateException("호출을 확인해 주십시오.");
        }
        return response.getBody();
    }

}
