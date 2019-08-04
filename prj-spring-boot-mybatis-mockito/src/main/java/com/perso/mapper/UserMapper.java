package com.perso.mapper;

import java.util.List;

import com.perso.domain.User;

public interface UserMapper
{
    void insertUser(User user);
    User findUserById(Integer id);
    List<User> findAllUsers();
}