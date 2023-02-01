package com.example.JavaSpring.service;

import com.example.JavaSpring.entity.Tutorials;
import com.example.JavaSpring.exception.TutorialAlreadyExistsException;
import com.example.JavaSpring.exception.TutorialNotFoundException;
import com.example.JavaSpring.exception.TutorialNotNullException;
import com.example.JavaSpring.model.Tutorial;
import com.example.JavaSpring.repository.TutorialRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class TutorialService {
    private final TutorialRepository tutorialRepository;


    public List<Tutorials> getAllTutorials() {
        return tutorialRepository.findAll();
    }


    public Tutorials createTutorial(Tutorials tutorial) {
        log.info("TutorialServiceImpl.createTutorial.start");
        if (tutorial.getTitle().isEmpty()) {
            log.error("TutorialServiceImpl.createTutorial.error");
            throw new TutorialNotNullException("Tutorial Title must be not null!");
        }else if (isTutorialExists(tutorial)) {
            log.error("TutorialServiceImpl.createTutorial.error");
            throw new TutorialAlreadyExistsException("This Tutorial Already Exists!");
        }
        log.info("TutorialServiceImpl.createTutorial.end");
        return tutorialRepository.save(tutorial);
    }
    public Tutorials getTutorialById(Long id) {
        Tutorials tutorial = tutorialRepository.findById(id).get();
        log.info("TutorialServiceImpl.getTutorialById.start with id: {}", id);
        if (tutorial == null) {
            log.error("TutorialServiceImpl.getTutorialById.start with id: {}", id);
            throw new TutorialNotFoundException("Tutorial id: " + id);
        }
        log.info("TutorialServiceImpl.findById.end with id: {}", id);
        return tutorial;
    }

    public void deleteTutorialById(Long id) {
        Optional<Tutorials> tutorial = tutorialRepository.findById(id);
        log.info("TutorialServiceImpl.deleteTutorial.start with id: {}", id);
        if (tutorial == null) {
            log.error("TutorialServiceImpl.getTutorialById.start with id: {}", id);
            throw new TutorialNotFoundException("Tutorial id: " + id);
        }
         tutorialRepository.deleteById(id);
        log.info("TutorialServiceImpl.deleteTutorial.end with id: {}", id);
    }

    private boolean isTutorialExists(Tutorials tutoria) {
        return tutorialRepository
                .findAll()
                .stream()
                .anyMatch(tutorial -> Objects.equals(tutorial.getTitle(), tutorial.getTitle()));
    }

}
