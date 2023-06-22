package com.example.myUser.service;

import com.example.myUser.entity.MyUser;
import com.example.myUser.repository.MyUserRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class MyUserServiceImpl implements MyUserService {
    @Autowired
    private MyUserRepo myUserRepo;
    @Override
    public void addUser(MyUser myUser) {

        myUserRepo.save(myUser);
    }

    @Override
    public List<MyUser> getAllUser() {
        return myUserRepo.findAll();
    }

    @Override
    public MyUser getById(Long id) {
     return myUserRepo.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid user id"+ id));
    }

    @Override
    public void updateUser(Long id, MyUser myUser) {
        myUserRepo.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Invalid User Id"+ id));
        myUser.setId(id);
        myUserRepo.save(myUser);
    }
}
