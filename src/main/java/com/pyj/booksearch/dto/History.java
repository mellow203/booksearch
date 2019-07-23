package com.pyj.booksearch.dto;

import lombok.Builder;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Builder(toBuilder = true)
@Table(name = "history")
public class History {

    @Id
    private String title;
    private String date;

    public History(String title, String date){
        this.title = title;
        this.date = date;
    }
    public History() {
    }
}
