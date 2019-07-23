package com.pyj.booksearch.dto;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Builder(toBuilder = true)
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    private String uid;
    private String password;
    private String name;
}
