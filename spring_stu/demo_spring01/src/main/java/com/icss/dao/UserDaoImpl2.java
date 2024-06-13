package com.icss.dao;

import com.icss.bean.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository("udi2")
public class UserDaoImpl2 implements UserDao{


    @Override
    public List<User> getAllUsers() {
       List<User> list = new ArrayList<User>();
       list.add(new User(4,"张三"));
       list.add(new User(5,"李四"));
        list.add(new User(6,"王五"));
        return list;
    }

    public User getUser() {
        return new User(10,"钱七");
    }
}
