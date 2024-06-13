package com.icss.service;

import com.icss.bean.User;
import org.springframework.stereotype.Component;

import java.util.List;


public interface   UserService {

    public List<User> getAllUsers();
    public User getUser();
}
