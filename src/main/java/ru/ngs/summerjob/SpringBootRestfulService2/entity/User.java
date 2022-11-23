package ru.ngs.summerjob.SpringBootRestfulService2.entity;


import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        Integer id;
        @Column
        String name;
        @Column
        String login;
        @Column
        String email;

        public User() {
        }

        public User(Integer id, String name, String login, String email) {
                this.id = id;
                this.name = name;
                this.login = login;
                this.email = email;
        }

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getLogin() {
                return login;
        }

        public void setLogin(String login) {
                this.login = login;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        @Override
        public String toString() {
                return "User{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        ", login='" + login + '\'' +
                        ", email='" + email + '\'' +
                        '}';
        }
}
