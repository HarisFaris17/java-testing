package com.example.testing.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.testing.model.Student;

import static org.assertj.core.api.Assertions.*;


@DataJpaTest
public class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    void testExistName() {
        String name = "Haris";
        Student student = new Student(1L,name,"Karawang");
        studentRepository.save(student);
        boolean isTrueNameExist = studentRepository.existName(name);
        assertThat(isTrueNameExist).isTrue();
    }
}
