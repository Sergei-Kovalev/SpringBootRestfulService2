package ru.ngs.summerjob.SpringBootRestfulService2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ngs.summerjob.SpringBootRestfulService2.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByLogin(String login);
}
