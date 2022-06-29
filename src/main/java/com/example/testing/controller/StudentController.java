package com.example.testing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.testing.repository.StudentRepository;

@Controller
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;
    
    @GetMapping("/name/{name}")
    public boolean selectName(@PathVariable("name") String name){
        System.out.println(studentRepository.existName("Haris"));
        return studentRepository.existName(name);
    }
}
