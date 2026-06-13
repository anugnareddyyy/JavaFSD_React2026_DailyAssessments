package com.wipro.appverse.entity;

/*
 * Represents reviews given by users for applications.
 */
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;
    private int rating;
    private String sentiment;

    @ManyToOne
    private App app;

    @ManyToOne
    private User user;
}