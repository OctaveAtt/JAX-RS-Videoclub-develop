package com.videoclub.dao;


import com.videoclub.dao.base.UserDao;
import com.videoclub.dao.entity.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MemoryUserDao implements UserDao {

    private static Long idSequence = 0L;
    private static List<User> users = new ArrayList<>();

    @Override
    public Long save(User user) {
        user.setId(++idSequence);
        users.add(user);
        return user.getId();
    }

    @Override
    public List<User> findAll() {
        return Collections.unmodifiableList(users);
    }

    @Override
    public Optional<User> findById(Long id) {
        return this.users.stream()
                .filter(u -> u.getId() == id)
                .findFirst();
    }

    @Override
    public boolean update(User userToUpdate) {
        boolean isUpdate = false;
        List<User> tempList = new ArrayList<>();
        for (User u : users) {
            if (u.getId() == userToUpdate.getId()) {
                u = userToUpdate;
                isUpdate = true;
            }
            tempList.add(u);
        }
        users = tempList;
        return isUpdate;
    }

    @Override
    public void delete(Long id) {
        this.users = this.users
                .stream()
                .filter(movie -> movie.getId() != id)
                .collect(Collectors.toList());
    }

    public void delete(User user){
        users.remove(user);
    }
}
