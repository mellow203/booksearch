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
    private Long id;
    private String uid;
    private String password;
    private String name;

    public User(Long id, String uid, String name, String password){
        this.id = id;
        this.uid = uid;
        this.name = name;
        this.password = password;
    }

    public User(){

    }
}
