package com.example.JavaSpring.service.impl;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.JavaSpring.entity.Tutorials;
import com.example.JavaSpring.exception.TutorialAlreadyExistsException;
import com.example.JavaSpring.exception.TutorialNotFoundException;
import com.example.JavaSpring.exception.TutorialNotNullException;
import com.example.JavaSpring.repository.TutorialRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {TutorialServiceImpl.class})
@ExtendWith(SpringExtension.class)
class TutorialServiceImplTestByDiffBlue {
    @MockBean
    private TutorialRepository tutorialRepository;

    @Autowired
    private TutorialServiceImpl tutorialServiceImpl;

    /**
     * Method under test: {@link TutorialServiceImpl#getAllTutorials()}
     */
    @Test
    void testGetAllTutorials() {
        ArrayList<Tutorials> tutorialsList = new ArrayList<>();
        when(tutorialRepository.findAll()).thenReturn(tutorialsList);
        List<Tutorials> actualAllTutorials = tutorialServiceImpl.getAllTutorials();
        assertSame(tutorialsList, actualAllTutorials);
//        assertTrue(actualAllTutorials.isEmpty());
        verify(tutorialRepository).findAll();
    }

    /**
     * Method under test: {@link TutorialServiceImpl#getAllTutorials()}
     */
    @Test
    void testGetAllTutorials2() {
        when(tutorialRepository.findAll()).thenThrow(new TutorialNotNullException("An error occurred"));
        assertThrows(TutorialNotNullException.class, () -> tutorialServiceImpl.getAllTutorials());
        verify(tutorialRepository).findAll();
    }

    /**
     * Method under test: {@link TutorialServiceImpl#createTutorial(Tutorials)}
     */
    @Test
    void testCreateTutorial() {
        Tutorials tutorials = new Tutorials();
        tutorials.setDescription("The characteristics of someone or something");
        tutorials.setId(123L);
        tutorials.setPublished(true);
        tutorials.setTitle("Dr");
        when(tutorialRepository.save((Tutorials) any())).thenReturn(tutorials);
        when(tutorialRepository.findAll()).thenReturn(new ArrayList<>());

        Tutorials tutorials1 = new Tutorials();
        tutorials1.setDescription("The characteristics of someone or something");
        tutorials1.setId(123L);
        tutorials1.setPublished(true);
        tutorials1.setTitle("Dr");
        assertSame(tutorials, tutorialServiceImpl.createTutorial(tutorials1));
        verify(tutorialRepository).save((Tutorials) any());
        verify(tutorialRepository).findAll();
    }

    /**
     * Method under test: {@link TutorialServiceImpl#createTutorial(Tutorials)}
     */
    @Test
    void testCreateTutorial2() {
        Tutorials tutorials = new Tutorials();
        tutorials.setDescription("The characteristics of someone or something");
        tutorials.setId(123L);
        tutorials.setPublished(true);
        tutorials.setTitle("Dr");

        Tutorials tutorials1 = new Tutorials();
        tutorials1.setDescription("The characteristics of someone or something");
        tutorials1.setId(123L);
        tutorials1.setPublished(true);
        tutorials1.setTitle("Dr");

        ArrayList<Tutorials> tutorialsList = new ArrayList<>();
        tutorialsList.add(tutorials1);
        when(tutorialRepository.save((Tutorials) any())).thenReturn(tutorials);
        when(tutorialRepository.findAll()).thenReturn(tutorialsList);

        Tutorials tutorials2 = new Tutorials();
        tutorials2.setDescription("The characteristics of someone or something");
        tutorials2.setId(123L);
        tutorials2.setPublished(true);
        tutorials2.setTitle("Dr");
        assertThrows(TutorialAlreadyExistsException.class, () -> tutorialServiceImpl.createTutorial(tutorials2));
        verify(tutorialRepository).findAll();
    }

    /**
     * Method under test: {@link TutorialServiceImpl#createTutorial(Tutorials)}
     */
    @Test
    void testCreateTutorial3() {
        Tutorials tutorials = new Tutorials();
        tutorials.setDescription("The characteristics of someone or something");
        tutorials.setId(123L);
        tutorials.setPublished(true);
        tutorials.setTitle("Dr");
        when(tutorialRepository.save((Tutorials) any())).thenReturn(tutorials);
        when(tutorialRepository.findAll()).thenReturn(new ArrayList<>());
        Tutorials tutorials1 = mock(Tutorials.class);
        when(tutorials1.getTitle()).thenReturn("");
        doNothing().when(tutorials1).setDescription((String) any());
        doNothing().when(tutorials1).setId((Long) any());
        doNothing().when(tutorials1).setPublished((Boolean) any());
        doNothing().when(tutorials1).setTitle((String) any());
        tutorials1.setDescription("The characteristics of someone or something");
        tutorials1.setId(123L);
        tutorials1.setPublished(true);
        tutorials1.setTitle("Dr");
        assertThrows(TutorialNotNullException.class, () -> tutorialServiceImpl.createTutorial(tutorials1));
        verify(tutorials1).getTitle();
        verify(tutorials1).setDescription((String) any());
        verify(tutorials1).setId((Long) any());
        verify(tutorials1).setPublished((Boolean) any());
        verify(tutorials1).setTitle((String) any());
    }

    /**
     * Method under test: {@link TutorialServiceImpl#getTutorialById(Long)}
     */
    @Test
    void testGetTutorialById() {
        Tutorials tutorials = new Tutorials();
        tutorials.setDescription("The characteristics of someone or something");
        tutorials.setId(123L);
        tutorials.setPublished(true);
        tutorials.setTitle("Dr");
        Optional<Tutorials> ofResult = Optional.of(tutorials);
        when(tutorialRepository.findById((Long) any())).thenReturn(ofResult);
        assertSame(tutorials, tutorialServiceImpl.getTutorialById(123L));
        verify(tutorialRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link TutorialServiceImpl#getTutorialById(Long)}
     */

    /**
     * Method under test: {@link TutorialServiceImpl#getTutorialById(Long)}
     */
    @Test
    void testGetTutorialById3() {
        when(tutorialRepository.findById((Long) any())).thenThrow(new TutorialNotNullException("An error occurred"));
        assertThrows(TutorialNotNullException.class, () -> tutorialServiceImpl.getTutorialById(123L));
        verify(tutorialRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link TutorialServiceImpl#deleteTutorialById(Long)}
     */
    @Test
    void testDeleteTutorialById() {
        Tutorials tutorials = new Tutorials();
        tutorials.setDescription("The characteristics of someone or something");
        tutorials.setId(123L);
        tutorials.setPublished(true);
        tutorials.setTitle("Dr");
        Optional<Tutorials> ofResult = Optional.of(tutorials);
        when(tutorialRepository.findById((Long) any())).thenReturn(ofResult);
        doNothing().when(tutorialRepository).deleteById((Long) any());
        tutorialServiceImpl.deleteTutorialById(123L);
        verify(tutorialRepository).findById((Long) any());
        verify(tutorialRepository).deleteById((Long) any());
    }

    /**
     * Method under test: {@link TutorialServiceImpl#deleteTutorialById(Long)}
     */
    @Test
    void testDeleteTutorialById2() {
        when(tutorialRepository.findById((Long) any())).thenReturn(null);
        doNothing().when(tutorialRepository).deleteById((Long) any());
        assertThrows(TutorialNotFoundException.class, () -> tutorialServiceImpl.deleteTutorialById(123L));
        verify(tutorialRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link TutorialServiceImpl#deleteTutorialById(Long)}
     */
    @Test
    void testDeleteTutorialById3() {
        when(tutorialRepository.findById((Long) any())).thenThrow(new TutorialNotFoundException("An error occurred"));
        doThrow(new TutorialNotFoundException("An error occurred")).when(tutorialRepository).deleteById((Long) any());
        assertThrows(TutorialNotFoundException.class, () -> tutorialServiceImpl.deleteTutorialById(123L));
        verify(tutorialRepository).findById((Long) any());
    }
}

