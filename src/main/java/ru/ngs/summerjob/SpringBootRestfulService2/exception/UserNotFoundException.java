package ru.ngs.summerjob.SpringBootRestfulService2.exception;

public class UserNotFoundException extends Exception {
    private final String login;

    public UserNotFoundException(String login) {
        this.login = login;
    }

    public String getMessage() {
        return String.format("The entered login: \"%s\" is incorrect", login);
    }
}
