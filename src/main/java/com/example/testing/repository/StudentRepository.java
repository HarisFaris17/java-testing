package com.example.testing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.testing.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long>{
    @Query("SELECT CASE WHEN COUNT(student)>0 THEN TRUE ELSE FALSE END FROM Student student WHERE :name=student.name")
    public boolean existName(@Param("name") String name);
}
