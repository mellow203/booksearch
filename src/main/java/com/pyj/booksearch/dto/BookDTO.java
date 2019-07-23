package com.pyj.booksearch.dto;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class BookDTO {

    @lombok.Data
    public static class Response {
        private List<Data> documents;
        private Meta meta;
    }

    @lombok.Data
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    public static class Data {
        private String title;
        private String contents;
        private String url;
        private String isbn;
        private String datetime;
        private List<String> authors;
        private String publisher;
        private List<String> translators;
        private String price;
        private String sale_price;
        private String thumbnail;
        private String status;

    }

    @lombok.Data
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    public static class Meta {
        private Boolean isEnd;
        private int pageable_count;
        private int total_count;
    }


}
