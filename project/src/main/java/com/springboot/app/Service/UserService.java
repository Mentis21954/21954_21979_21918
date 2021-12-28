package com.springboot.app.Service;


import java.util.List;
import com.springboot.app.entity.User;
import com.springboot.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    private UserRepository repo;

    @Override
    public List<User> listAll() {
        return (List<User>) repo.findAll();
    }

    @Override
    public void save(User user) {
        repo.save(user);
    }

    @Override
    public User get(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
