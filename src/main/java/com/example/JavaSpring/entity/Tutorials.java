package com.example.JavaSpring.entity;

import lombok.Data;
import nonapi.io.github.classgraph.json.Id;

import javax.persistence.*;

@Entity
@Table(name = "tutorials")
@Data
public class Tutorials {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String title;

    private String description;

    private Boolean published;

}
