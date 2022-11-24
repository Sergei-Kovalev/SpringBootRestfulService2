package ru.ngs.summerjob.SpringBootRestfulService2.service;

import org.springframework.stereotype.Service;
import ru.ngs.summerjob.SpringBootRestfulService2.dto.UserDto;
import ru.ngs.summerjob.SpringBootRestfulService2.entity.User;
import ru.ngs.summerjob.SpringBootRestfulService2.exception.UserNotFoundException;
import ru.ngs.summerjob.SpringBootRestfulService2.exception.ValidationException;
import ru.ngs.summerjob.SpringBootRestfulService2.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultUserService implements UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;

    public DefaultUserService(UserRepository userRepository, UserConverter userConverter) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
    }

    @Override
    public UserDto saveUser(UserDto userDto) throws ValidationException {
        validateUserDto(userDto);
        User savedUser = userRepository.save(userConverter.fromUserDtoToUser(userDto));
        return userConverter.fromUserToUserDto(savedUser);
    }

    @Override
    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public UserDto findByLogin(String login) throws UserNotFoundException {
        User user = userRepository.findByLogin(login);
        if (user != null) {
            return userConverter.fromUserToUserDto(user);
        } else {
            throw new UserNotFoundException(login);                                    // лучше не возвращать - переделать под Exception или попробовать Optional
        }
    }

    @Override
    public List<UserDto> findAll() {
        List<User> userList = userRepository.findAll();
        return userList.stream().map(userConverter::fromUserToUserDto).collect(Collectors.toList());
    }

    private void validateUserDto(UserDto userDto) throws ValidationException {
        if (userDto == null) {
            throw new ValidationException("Object user is null");
        }
        if (userDto.getLogin() == null || userDto.getLogin().isEmpty()) {
            throw new ValidationException("Login is empty");
        }
    }
}
