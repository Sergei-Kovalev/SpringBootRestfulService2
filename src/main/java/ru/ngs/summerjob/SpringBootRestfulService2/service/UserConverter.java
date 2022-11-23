package ru.ngs.summerjob.SpringBootRestfulService2.service;

import org.springframework.stereotype.Component;
import ru.ngs.summerjob.SpringBootRestfulService2.dto.UserDto;
import ru.ngs.summerjob.SpringBootRestfulService2.entity.User;

@Component
public class UserConverter {
    public User fromUserDtoToUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setLogin(userDto.getLogin());
        user.setEmail(userDto.getEmail());
        return user;
    }

    public UserDto fromUserToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setLogin(user.getLogin());
        userDto.setEmail(user.getEmail());
        return userDto;
    }
}
