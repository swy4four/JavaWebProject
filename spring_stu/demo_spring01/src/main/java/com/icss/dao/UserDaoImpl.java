package com.icss.dao;

import com.icss.bean.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository("udi1")
public class UserDaoImpl implements UserDao{


    @Override
    public List<User> getAllUsers() {
       List<User> list = new ArrayList<User>();
       list.add(new User(1,"张三"));
       list.add(new User(2,"李四"));
        list.add(new User(3,"王五"));
        return list;
    }

    @Override
    public User getUser() {
        return new User(4,"赵六");
    }
}
