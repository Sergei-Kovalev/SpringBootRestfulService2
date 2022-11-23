package ru.ngs.summerjob.SpringBootRestfulService2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ngs.summerjob.SpringBootRestfulService2.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByLogin(String login);
}
