package com.example.PasswordSaver;

public interface UserService {
    void saveUser(UserEntity user);
    UserEntity findUserByName(String name);

}
