package com.api.RealProperty.service;

import com.api.RealProperty.entity.User;
import com.api.RealProperty.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Objects.isNull;

@Service
public class UserService implements IUserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public User getUser(Long userId) {
        User user = userRepository.getOne(userId);
        if (isNull(user)) {
            return null;
        }
        return user;
    }

    @Override
    public User userUpdate(User user) {
        return userRepository.save(user);
    }

    @Override
    public User deleteUser(Long userId) {
        User user = userRepository.getOne(userId);
        if (isNull(user)) {
            return null;
        }

        return user;
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByLogin(String login) {
        if (isNull(login)) {
            return null;
        }
        return userRepository.findUserByLogin(login);
    }

    @Override
    public List<User> getUserByFirstName(String firstName) {
        if (isNull(firstName)) {
            return null;
        }
        return userRepository.findUserByFirstName(firstName);
    }

    @Override
    public List<User> getUserByLastName(String lastName) {
        if (isNull(lastName)) {
            return null;
        }
        return userRepository.findUserByLastName(lastName);
    }
}
