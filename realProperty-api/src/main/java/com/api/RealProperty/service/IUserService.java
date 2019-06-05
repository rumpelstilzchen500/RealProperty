package com.api.RealProperty.service;

import com.api.RealProperty.entity.User;

import java.util.List;

public interface IUserService {

    User addUser(User user);

    User getUser(Long userId);

    User userUpdate(User user);

    User deleteUser(Long userId);

    List<User> getAllUser();

    User getUserByLogin(String login);

    List<User> getUserByFirstName(String firstName);

    List<User> getUserByLastName(String lastName);
}
