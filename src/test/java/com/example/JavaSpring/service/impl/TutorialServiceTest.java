package com.example.JavaSpring.service.impl;


import com.example.JavaSpring.entity.Tutorials;
import com.example.JavaSpring.exception.TutorialAlreadyExistsException;
import com.example.JavaSpring.repository.TutorialRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {TutorialServiceImpl.class})
class TutorialServiceTest {

    @Autowired
    private TutorialServiceImpl tutorialService;
    @MockBean
    private TutorialRepository tutorialRepository;

//sariyev1234git
    @Test
    void givenWhenGetAllTutorialsThenReturnTutorialsList() {
        List<Tutorials> tutorials = new ArrayList<>();
        when(tutorialRepository.findAll()).thenReturn(tutorials);

        List<Tutorials> tutorialsList = tutorialService.getAllTutorials();
        assertSame(tutorialsList, tutorials);
        verify(tutorialRepository).findAll();
    }

    @Test
    void givenWhenCreateTutorialThanSaveTutorial() {
        Tutorials tutorials1 = new Tutorials();
        tutorials1.setId(1L);
        tutorials1.setDescription("hello1");
        tutorials1.setTitle("good1");
        tutorials1.setPublished(true);
        tutorialService.createTutorial(tutorials1);

        ArgumentCaptor<Tutorials> tutorialsArgumentCaptor =
                ArgumentCaptor.forClass(Tutorials.class);

        verify(tutorialRepository).save(tutorialsArgumentCaptor.capture());

        Tutorials captured = tutorialsArgumentCaptor.getValue();

        assertThat(captured).isEqualTo(tutorials1);

    }

    @Test
    void throwNewTutorialAlreadyExistsExceptionWhenTutorialAllReadyExists() {

        Tutorials tutorials1 = new Tutorials();
        tutorials1.setId(1L);
        tutorials1.setDescription("hello1");
        tutorials1.setTitle("good1");
        tutorials1.setPublished(true);

        Tutorials tutorials2 = new Tutorials();
        tutorials2.setId(1L);
        tutorials2.setDescription("hello1");
        tutorials2.setTitle("good1");
        tutorials2.setPublished(true);

        List<Tutorials> tutorials = new ArrayList<>();
        tutorials.add(tutorials1);
        when(tutorialRepository.findAll()).thenReturn(tutorials);

        assertEquals(tutorials2, tutorials1);
        assertThrows(TutorialAlreadyExistsException.class, () -> tutorialService.createTutorial(tutorials2));
        verify(tutorialRepository).findAll();


    }


}
