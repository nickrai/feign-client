package com.example.myUser.controller;

import com.example.myUser.MyUserApplication;
import com.example.myUser.entity.MyUser;
import com.example.myUser.service.MyUserService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/myUser")
@AllArgsConstructor
public class MyUserController {

    @Autowired
    private MyUserService myUserService;

    @PostMapping
    public String addUser(@RequestBody MyUser myUser) {
        myUserService.addUser(myUser);
        return "Added Successfully";
    }

    @GetMapping
    public List<MyUser> getAllUser(){
       return myUserService.getAllUser();
    }

    @GetMapping("/get")
    public MyUser getById(@RequestParam Long id)
    {
       return myUserService.getById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable Long id,@RequestBody MyUser myUser)
    {
        myUserService.updateUser(id, myUser);
        return ResponseEntity.noContent().build();
    }

}
