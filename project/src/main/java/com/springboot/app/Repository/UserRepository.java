package hua.dit.recommendationLetterSystem.Repository;

import hua.dit.recommendationLetterSystem.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, String> {
}