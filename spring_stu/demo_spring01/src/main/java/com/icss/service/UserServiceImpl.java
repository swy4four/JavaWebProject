package com.icss.service;

import com.icss.bean.User;
import com.icss.dao.UserDao;
import com.icss.dao.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("usi")
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("udi2")
    /*@Resource(name = "udi2")*/
    private UserDao UserDao ;

    @Override
    public List<User> getAllUsers() {
        return UserDao.getAllUsers();
    }

    @Override
    public User getUser() {
        return UserDao.getUser();
    }


}
