package com.example.testing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testing.model.Student;
import com.example.testing.repository.StudentRepository;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    public List<Student> getAllStudent5times(){
        studentRepository.findAll();
        studentRepository.findAll();
        studentRepository.findAll();
        studentRepository.findAll();
        return studentRepository.findAll();

    }
}
