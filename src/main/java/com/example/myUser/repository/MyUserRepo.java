package com.example.myUser.repository;

import com.example.myUser.entity.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MyUserRepo extends JpaRepository<MyUser,Long> {
    List<MyUser> findByName(Long id);
    List<MyUser> findByAddress(String address);
    List<MyUser> findByContact(Long contact);

}
