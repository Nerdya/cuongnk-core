package com.example.demo.repositories;

import com.example.demo.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository
    extends JpaRepository<Student, Long> {

  Optional<Student> findStudentById(Long id);

  Optional<Student> findStudentByEmail(String email);
}
