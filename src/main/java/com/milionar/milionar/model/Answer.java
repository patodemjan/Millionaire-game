package com.milionar.milionar.model;

import jakarta.persistence.*;

@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String optionLetter; // napr. A, B, C, D

    private String text;

    private boolean correct;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    // Getters and setters
}