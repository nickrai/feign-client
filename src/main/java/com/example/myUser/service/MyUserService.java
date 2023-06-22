package com.example.myUser.service;

import com.example.myUser.entity.MyUser;

import java.util.List;

public interface MyUserService {
    void addUser(MyUser myUser);

    List<MyUser> getAllUser();

    MyUser getById(Long id);

    void updateUser(Long id, MyUser myUser);
}
