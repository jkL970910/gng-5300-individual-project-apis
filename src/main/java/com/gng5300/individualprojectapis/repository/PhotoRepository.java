package com.gng5300.individualprojectapis.repository;

import com.gng5300.individualprojectapis.model.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoRepository extends MongoRepository<Photo, String> {
    @Query("{ 'id' :  ?0}")
    List<Photo> findByPhotoId(String id);

    @Query("{ 'title' :  ?0}")
    List<Photo> findByPhotoTitle(String title);

    @Query("{ 'uploadUser' :  ?0}")
    List<Photo> findByUploadUser(String uploadUser);
}
