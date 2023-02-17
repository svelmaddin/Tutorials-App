package com.example.JavaSpring.controller;

import com.example.JavaSpring.entity.Tutorials;
import com.example.JavaSpring.service.impl.FileService;
import com.example.JavaSpring.service.TutorialService;
import com.example.JavaSpring.service.impl.TutorialServiceImpl;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Api(tags = "Employee Controller")
public class TutorialController implements TutorialService{

    private final TutorialServiceImpl tutorialService;
    private final FileService fileService;


    @GetMapping("/get")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Getting All Tutorials")
    public List<Tutorials> getAllTutorials(){
        List<Tutorials> allTutorials = tutorialService.getAllTutorials();
        return allTutorials;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create Tutorial")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 201, message = "Tutorial created"),
                    @ApiResponse(code = 400, message = "Bad request"),
                    @ApiResponse(code = 500, message = "Something went wrong")
            })
    public ResponseEntity<Tutorials> createTutorial(@RequestBody Tutorials tutorial) {
        return new ResponseEntity<>(tutorialService.createTutorial(tutorial), HttpStatus.CREATED);
    }


    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ApiOperation(value = "Get Tutorial by Id")
    public Tutorials getTutorialById(@PathVariable("id") Long id) {
       Tutorials tutorials = tutorialService.getTutorialById(id);
       return tutorials;
    }


    @ApiOperation(value = "Delete Tutorial by Id")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTutorialById(@PathVariable("id") Long id) {
        tutorialService.deleteTutorialById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @PostMapping("/upload")
    public void uploadFile(
            @RequestParam("file") MultipartFile file) {
            fileService.save(file);
    }


}
