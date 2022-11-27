package com.gng5300.individualprojectapis.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;

@Document
@Getter
@Setter
@ToString
public class User {
    @Id
    private String id;

    private String username;

    private String password;

    private HashSet<String> myPhotos;

    private HashSet<String> likedList;


    public User() {}

    public User(String username, String password, HashSet<String> photos, HashSet<String> likedPhotos) {
        this.username = username;
        this.password = password;
        this.myPhotos = photos;
        this.likedList = likedPhotos;
    }

}