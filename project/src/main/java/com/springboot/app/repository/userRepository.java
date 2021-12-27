package com.springboot.app.repository;

import com.springboot.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(path="users")
public interface userRepository extends JpaRepository<User, String> {
}

