package com.springboot.app.Service;


import java.util.List;
import java.util.Set;

import com.springboot.app.Entity.Role;
import com.springboot.app.Entity.User;
import com.springboot.app.Repository.RoleRepository;
import com.springboot.app.Repository.UserRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    private UserRepository repoUser;

    @Autowired
    private RoleRepository repoRole;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> listAll() {
        return (List<User>) repoUser.findAll();
    }

    public List<Role> listRoles() {
        return repoRole.findAll();
    }

    @Override
    public void save(User user) throws Exception {
        if (repoUser.countUsersWithUsername(user.getUsername(),user.getId()) >= 1) {
            throw new Exception();
        } else {
            String encodedPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
            repoUser.save(user);
        }
    }

    @Override
    public User get(Long id) {
        return repoUser.findById(id).get();
    }

    public User getUserByUsername(String username) {
        return repoUser.getUserByUsername(username);
    }

    public List<User> getAllTeachers() {
        List<User> userList = (List<User>) repoUser.findAll();
        Role role = repoRole.findByName("TEACHER");
        for (int i = userList.size(); i>0; i--) {
            if (!userList.get(i-1).getRoles().contains(role)) {
                userList.remove(userList.get(i-1));
            }
        }
        return userList;
    }

    @Override
    public void delete(Long id) {
        repoUser.deleteById(id);
    }
}
