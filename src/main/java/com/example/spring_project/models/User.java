package com.example.spring_project.models;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
        @Id
        @Column
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column
        private String username;

        @Column
        private String emailAddress;

        @Column
        private String password;

        public User() {
        }

        public User(Long id, String username, String emailAddress, String password) {
            this.id = id;
            this.username = username;
            this.emailAddress = emailAddress;
            this.password = password;
        }
}
