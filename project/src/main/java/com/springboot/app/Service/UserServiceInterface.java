package com.springboot.app.Service;

import com.springboot.app.entity.User;

import java.util.List;

public interface UserServiceInterface {
    public List<User> listAll() ;

    public void save(User user);

    public User get(Long id) ;

    public void delete(Long id) ;
}
