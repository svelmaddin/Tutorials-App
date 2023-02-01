package com.example.JavaSpring.repository;

import com.example.JavaSpring.entity.Tutorials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorialRepository extends JpaRepository<Tutorials, Long > {

}
