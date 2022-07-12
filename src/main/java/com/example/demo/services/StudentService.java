package com.example.demo.services;

import com.example.demo.entities.Student;
import com.example.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

  private final StudentRepository studentRepository;

  @Autowired
  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public List<Student> getStudents() {
    return studentRepository.findAll();
  }

  public Optional<Student> getStudentById(Long studentId) {
    Optional<Student> studentOptional = studentRepository
        .findStudentById(studentId);
    if (studentOptional.isEmpty()) {
      throw new IllegalStateException("This id is not exist");
    }
    return studentOptional;
  }

//  public Optional<Student> getStudentByEmail(String email) {
//    Optional<Student> studentOptional = studentRepository
//        .findStudentByEmail(email);
//    if (studentOptional.isEmpty()) {
//      throw new IllegalStateException("This email is not exist");
//    }
//    return studentOptional;
//  }

  public Student addNewStudent(Student student) {
    Optional<Student> studentOptional = studentRepository
        .findStudentByEmail(student.getEmail());
    if (studentOptional.isPresent()) {
      throw new IllegalStateException("This email is taken");
    }
    return studentRepository.save(student);
  }

  public String deleteStudent(Long studentId) {
    boolean exists = studentRepository.existsById(studentId);
    if (!exists) {
      throw new IllegalStateException(
          "Student with id " + studentId + " does not exist"
      );
    }
    studentRepository.deleteById(studentId);
    return "Deleted student successfully";
  }

  @Transactional
  public Student updateStudent(Long studentId,
      String name,
      String email) {
    Student student = studentRepository.findById(studentId)
        .orElseThrow(() -> new IllegalStateException(
            "Student with id " + studentId + " does not exist"));

    if (name != null &&
        name.length() > 0 &&
        !student.getName().equals(name)) {
      student.setName(name);
    }

    if (email != null &&
        email.length() > 0 &&
        !student.getEmail().equals(email)) {
      Optional<Student> studentOptional = studentRepository
          .findStudentByEmail(email);
      if (studentOptional.isPresent()) {
        throw new IllegalStateException("This email is taken");
      }
      student.setEmail(email);
    }

    return student;
  }
}
