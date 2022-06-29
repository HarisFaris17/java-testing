package com.example.testing.repository;

import org.junit.jupiter.api.AfterEach;
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

    /*seharusnya ketika testExistName dijalankan, maka kan menyimpan di dalam database student Haris, namun anehnya testing testDoesntExistName lulus
     * sehingga tidak dibutuhkan deleteStudentAfterEachTest yang tujuannya untuk menghapus student Haris setelah testExistName dijalankan
    */
    // @AfterEach
    // void deleteStudentAfterEachTest(){
    //     studentRepository.deleteAll();
    // }

    @Test
    void testExistName() {
        String name = "Haris";
        Student student = new Student(1L,name,"Karawang");
        studentRepository.save(student);
        boolean isTrueNameExist = studentRepository.existName(name);
        assertThat(isTrueNameExist).isTrue();
    }

    @Test
    void testDoesntExistName() {
        String name = "Haris";
        boolean isTrueNameExist = studentRepository.existName(name);
        assertThat(isTrueNameExist).isFalse();
    }
}
