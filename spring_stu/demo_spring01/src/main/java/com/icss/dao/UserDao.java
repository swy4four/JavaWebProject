package com.icss.dao;

import com.icss.bean.User;

import java.util.List;

public interface UserDao {

    public List<User> getAllUsers();

    public User getUser();
}
