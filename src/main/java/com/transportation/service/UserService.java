package com.transportation.service;


import com.transportation.entity.User;

import java.util.List;

public interface UserService {
    Long createUser(User user);

    List<User> getAllUsers();

    User getUserById(Long userId);

    User updateUser(Long userId, User user);

    boolean deleteUser(Long userId);
}
