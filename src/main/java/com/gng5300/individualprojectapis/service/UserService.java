package com.gng5300.individualprojectapis.service;

import com.gng5300.individualprojectapis.model.User;
import com.gng5300.individualprojectapis.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createNewUser(String username, String password) {
        try {
            if (userRepository.findByUsername(username).size() != 0) {
                return new User("UserAlreadyExisted", password, new HashSet<>(), new HashSet<>());
            }
            User user = new User(username, password, new HashSet<>(), new HashSet<>());
            userRepository.save(user);
            return user;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public User findUserByUsername(String username) {
        List<User> userList = userRepository.findByUsername(username);
        return userList.size() == 0 ? null : userList.get(0);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User addLikedPhoto(String username, String photoId) {
        try {
            User user = userRepository.findByUsername(username).get(0);
            HashSet<String> curLikedPhotoList = user.getLikedList();
            curLikedPhotoList.add(photoId);
            user.setLikedList(curLikedPhotoList);
            userRepository.save(user);
            return user;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public User removeLikedPhoto(String username, String photoId) {
        try {
            User user = userRepository.findByUsername(username).get(0);
            HashSet<String> curLikedPhotoList = user.getLikedList();
            curLikedPhotoList.remove(photoId);
            user.setLikedList(curLikedPhotoList);
            userRepository.save(user);
            return user;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public User userLogin(String username, String password) {
        try {
            User user = userRepository.findByUsername(username).get(0);
            if (user.getPassword().equals(password)) return user;
            return new User("UsernameOrPasswordNotMatched", password, new HashSet<>(), new HashSet<>());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
