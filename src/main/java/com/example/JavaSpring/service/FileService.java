package com.example.JavaSpring.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileService {
    private final Path root = Paths.get("uploads");


    public void save(MultipartFile file) {
        try{
            file.transferTo(this.root.resolve(file.getOriginalFilename()));
        }catch (IOException e){
            e.printStackTrace();
            throw  new RuntimeException();
        }
//        try {
////            Files.copy(file.getInputStream(),
////                    this.root.resolve(file.getOriginalFilename()));
//
//        } catch (Exception e) {
//            if (e instanceof FileAlreadyExistsException) {
//                throw new RuntimeException("A file of that name already exists.");
//            }
//            throw new RuntimeException(e.getMessage());
//        }
    }
}

