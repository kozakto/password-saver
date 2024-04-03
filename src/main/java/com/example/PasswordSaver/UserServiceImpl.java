package com.example.PasswordSaver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity findUserByName(String name) {
        List<UserEntity> users = userRepository.findByName(name);

        if (!users.isEmpty()) {
            return users.get(0);
        } else {
            return null; // user not found
        }
    }

    @Override
    public void saveUser(UserEntity user) {
        userRepository.save(user);
    }

}
