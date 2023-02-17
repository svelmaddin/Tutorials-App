package com.example.JavaSpring.service;

import com.example.JavaSpring.entity.Tutorials;
import com.example.JavaSpring.model.Tutorial;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TutorialService {

    public List<Tutorials> getAllTutorials();
}
