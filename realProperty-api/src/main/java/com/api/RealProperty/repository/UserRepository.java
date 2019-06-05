package com.api.RealProperty.repository;

import com.api.RealProperty.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByLogin(String login);

    List<User> findUserByFirstName(String firstName);

    List<User> findUserByLastName(String lastName);
}
