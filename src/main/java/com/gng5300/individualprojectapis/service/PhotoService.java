package com.gng5300.individualprojectapis.service;

import com.gng5300.individualprojectapis.model.Photo;
import com.gng5300.individualprojectapis.model.User;
import com.gng5300.individualprojectapis.repository.PhotoRepository;
import com.gng5300.individualprojectapis.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class PhotoService {
    private final UserRepository userRepository;

    private final PhotoRepository photoRepository;


    public PhotoService(UserRepository userRepository, PhotoRepository photoRepository) {
        this.userRepository = userRepository;
        this.photoRepository = photoRepository;
    }

    public Photo uploadPhoto(String username, String photoTitle, String description, String imgUrl, String imgLocal) {
        try {
            Photo newPhoto = new Photo(photoTitle, description, username, imgUrl, imgLocal);
            photoRepository.save(newPhoto);
            User user = userRepository.findByUsername(username).get(0);
            HashSet<String> currentPhotos = user.getMyPhotos();
            currentPhotos.add(photoTitle);
            user.setMyPhotos(currentPhotos);
            userRepository.save(user);
            return newPhoto;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Photo findPhotoByID(String id) {
        List<Photo> resultList = photoRepository.findByPhotoId(id);
        return resultList.size() == 0 ? null : resultList.get(0);
    }

    public Photo findPhotoByTitle(String title) {
        List<Photo> resultList = photoRepository.findByPhotoTitle(title);
        return resultList.size() == 0 ? null : resultList.get(0);
    }

    public List<Photo> findPhotoByUploadUser(String username) {
        List<Photo> resultList = photoRepository.findByUploadUser(username);
        return resultList.size() == 0 ? null : resultList;
    }

    public List<Photo> findAllPhotos() {
        return photoRepository.findAll();
    }
}
