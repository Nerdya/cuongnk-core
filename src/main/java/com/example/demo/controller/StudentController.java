package com.example.demo.controller;

import com.example.demo.dto.StudentDto;
import com.example.demo.entities.Student;
import com.example.demo.service.iface.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

  private final StudentService studentService;

  @Autowired
  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping(path = "/students")
  public List<Student> getStudents() {
    return studentService.getStudents();
  }

//  @GetMapping(path = "/student/{id}")
//  public Optional<Student> getStudentById(
//      @PathVariable("id") Long id) {
//    return studentService.getStudentById(id);
//  }

  @PostMapping(path = "/student")
  public StudentDto createNewStudent(
      @RequestBody StudentDto student) throws Exception {
    return studentService.createNewStudent(student);
  }

//  @PutMapping(path = "/student/{id}")
//  public Student updateStudent(
//      @PathVariable("id") Long id,
//      @RequestParam(required = false) String name,
//      @RequestParam(required = false) String email) {
//    return studentService.updateStudent(id, name, email);
//  }

//  @DeleteMapping(path = "/student/{id}")
//  public String deleteStudent(
//      @PathVariable("id") Long id) {
//    return studentService.deleteStudent(id);
//  }
}
