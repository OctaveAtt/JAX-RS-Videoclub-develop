package com.videoclub.service;

import com.videoclub.controller.model.responses.UserResponse;
import com.videoclub.dao.DaoFactory;
import com.videoclub.dao.base.UserDao;
import com.videoclub.dao.entity.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserService {

    public List<UserResponse> fetchAll() {
        UserDao userDao = DaoFactory.getUserDao();

        return userDao
                .findAll()
                .stream()
                .map(User::toDto)
                .collect(Collectors.toList());
    }

    public boolean update(Long id, User user) {
        UserDao userDao = DaoFactory.getUserDao();
        return userDao.update(user);
    }
}
