package com.gng5300.individualprojectapis.controller;

import com.gng5300.individualprojectapis.model.Photo;
import com.gng5300.individualprojectapis.service.PhotoService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PhotoController {

    private final PhotoService photoService;

    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @QueryMapping
    public List<Photo> getAllPhotos() {
        return photoService.findAllPhotos();
    }

    @QueryMapping
    public List<Photo> getLikePhotoList(@Argument String username) {
        return photoService.getLikePhotoList(username);
    }

    @MutationMapping
    public Photo uploadPhoto(@Argument String username, @Argument String photoTitle, @Argument String description, @Argument String imgUrl, @Argument String imgLocal) {
        return photoService.uploadPhoto(username, photoTitle, description, imgUrl, imgLocal);
    }

    @MutationMapping
    public Photo deletePhoto(@Argument String id) {
        return photoService.deletePhotoByID(id);
    }

    @MutationMapping
    public Photo updatePhoto(@Argument String photoId, @Argument String photoTitle,  @Argument String description,  @Argument String imgUrl,  @Argument String imgBase64) {
        return photoService.updatePhoto(photoId, photoTitle, description, imgUrl, imgBase64);
    }

    @MutationMapping
    public Photo findPhotoByID(@Argument String id) {
        return photoService.findPhotoByID(id);
    }

    @MutationMapping
    public Photo findPhotoByTitle(@Argument String title) {
        return photoService.findPhotoByTitle(title);
    }

    @MutationMapping
    public List<Photo> findPhotoByUploadUser(@Argument String username) {
        return photoService.findPhotoByUploadUser(username);
    }
}