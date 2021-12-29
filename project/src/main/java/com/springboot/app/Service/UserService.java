package com.springboot.app.Service;


import java.util.List;

import com.springboot.app.Entity.Role;
import com.springboot.app.Entity.User;
import com.springboot.app.Repository.RoleRepository;
import com.springboot.app.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    private UserRepository repoUser;

    @Autowired RoleRepository repoRole;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public List<User> listAll() {
        return (List<User>) repoUser.findAll();
    }

    public List<Role> listRoles() {
        return repoRole.findAll();
    }

    @Override
    public void save(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        repoUser.save(user);
    }

    @Override
    public User get(Long id) {
        return repoUser.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        repoUser.deleteById(id);
    }
}
