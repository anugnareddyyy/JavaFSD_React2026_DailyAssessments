package com.wipro.appverse.entity;

/*
 * This class represents User in the system.
 * It supports roles like ADMIN, USER, DEVELOPER.
 */
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String role;
}
