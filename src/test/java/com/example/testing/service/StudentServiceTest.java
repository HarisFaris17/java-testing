//jika sebuah class ingin kita unit testing-kan, sedangkan class tersebut memiliki dependency terhadap class lain, maka kita perlu melakukan mocking
//mocking adalah suatu kegiatan untuk membuat objek dari class yang class yang kita uji memiliki dependency terhadapnya menjadi sebuah tiruan. mocking deoendency class tidak benar-benar meniru, hanya sebagai kepalsuan sedemikian seakan-akan class yang kita uji berinteraksi benar-benar berkomunikasi dengan class dependencynya, sehingga class yang akan kita uji benar-benar menjadi teriosalasi dari ketergantungan dependency eksternal. Hal ini diperlukan karena dalam unit testing hanya boleh menguji 1 class saja, bukan 2 atau lebih class yang salah satu atau keduanya memiliki ketergantungan satu sama lain.
package com.example.testing.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.testing.repository.StudentRepository;

public class StudentServiceTest {
    //class yang akan kita mock/tiru
    @Mock
    private StudentRepository studentRepository;
    private StudentService studentService;  
    //AutoClosebale biasanya dignakan untuk "memegang" file sampai ditutup. Dalam konteks ini memegang class ini StudentServiceTest
    private AutoCloseable autoCloseable;

    @BeforeEach
    void setUp() {
        autoCloseable= MockitoAnnotations.openMocks(this);
        studentService = new StudentService(studentRepository);
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    //testing apakah studentService memanggil findAll() sekali  dari class studentRepository
    @Test
    void testGetAllStudent() {
        studentService.getAllStudent();
        verify(studentRepository).findAll();
    }

    //testing ini membuktikan bahwa mocks bisa menghitng berapa kali class yang menjadi dependency dipanggil
    //menguji findAll() pada studentRepository dipanggil 5 
    @Test
    void testGetAllStudent5times(){
        studentService.getAllStudent5times();
        verify(studentRepository,times(5)).findAll();

    }

}
