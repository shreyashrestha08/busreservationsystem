package com.blume.busbackend.service;

import com.blume.busbackend.models.User;
import com.blume.busbackend.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;

    @Override
    public User findrole(String email, String password, String role) {
        return userRepository.findByEmailAndPasswordAndRole(email, password, role);
    }

    @Override
    public User findone(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User edit(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(String email) {
        userRepository.deleteByEmail(email);

    }

    @Override
    public User find(String email) {
        return userRepository.findByEmail(email);
    }
}
