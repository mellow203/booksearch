package com.pyj.booksearch.domain;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@Builder(toBuilder = true)
@Table(name = "history")
public class History {
    private String title;
    private String date;

    public History(String title, String date){
        this.title = title;
        this.date = date;
    }
    public History() {
    }
}
