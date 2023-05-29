package com.blume.busbackend.service;

import com.blume.busbackend.models.User;

import java.util.List;

public interface UserService {
    User findrole(String email, String password, String role);
    User findone(String email, String password);
    User create(User user);
    List<User> getAll();
    User edit(User user);
    void delete(String email);
    User find(String email);
}
