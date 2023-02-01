package com.example.JavaSpring.entity;

import lombok.Data;
import nonapi.io.github.classgraph.json.Id;

import javax.persistence.*;

@Entity
@Table(name = "tutorials")
@Data
public class Tutorials {
//    @javax.persistence.Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    @Column(name = "id", nullable = false)
//    private Long id;
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String title;

    private String description;

    private Boolean published;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
