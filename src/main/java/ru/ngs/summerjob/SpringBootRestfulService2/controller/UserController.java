package ru.ngs.summerjob.SpringBootRestfulService2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ngs.summerjob.SpringBootRestfulService2.dto.UserDto;
import ru.ngs.summerjob.SpringBootRestfulService2.exception.UserNotFoundException;
import ru.ngs.summerjob.SpringBootRestfulService2.exception.ValidationException;
import ru.ngs.summerjob.SpringBootRestfulService2.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    public static final Logger logger = LoggerFactory.getLogger(UserController.class);

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public String test() {
        return "test";
    }

    @PostMapping("/save")
    public UserDto saveUser(@RequestBody UserDto userDto) throws ValidationException {
        logger.info("Save user:" + userDto);
        return userService.saveUser(userDto);
    }

    @GetMapping("/findAll")
    public List<UserDto> findAll() {
        logger.info("Find all users in a database");
        return userService.findAll();
    }

    @GetMapping("/findByLogin")
    public UserDto findByLogin(@RequestParam String login) throws UserNotFoundException {
        logger.info("Find user with a login: " + login);
        return userService.findByLogin(login);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        logger.info("Deleting user with id: " + id);
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

}
