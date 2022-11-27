package com.gng5300.individualprojectapis.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Photo {
    @Id
    private String id;

    private String title;
    private String description;
    private String uploadUser;
    private String imgUrl;
    private String imgLocal;

    public Photo(){}
    public Photo(String title, String description, String uploadUser, String imgUrl, String imgLocal) {
        this.title = title;
        this.description = description;
        this.uploadUser = uploadUser;
        this.imgUrl = imgUrl;
        this.imgLocal = imgLocal;
    }
}