package ru.ngs.summerjob.SpringBootRestfulService2.service;

import ru.ngs.summerjob.SpringBootRestfulService2.dto.UserDto;
import ru.ngs.summerjob.SpringBootRestfulService2.exception.ValidationException;

import java.util.List;

public interface UserService {

    UserDto saveUser(UserDto userDto) throws ValidationException;
    void deleteUser(Integer userId);
    UserDto findByLogin(String login);
    List<UserDto> findAll();
}
