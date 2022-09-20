package com.example.service;

import com.example.model.User;

import java.util.List;

public interface IUserService {
    List<User> findByAll();

    void save(User user);
}
