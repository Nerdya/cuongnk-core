package com.example.demo.service.iface;

import com.example.demo.dto.StudentDetailDto;
import com.example.demo.dto.StudentDto;
import com.example.demo.entities.Student;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.IdBlankException;
import com.example.demo.exception.ResourceNotFoundException;
import java.util.List;

public interface StudentService {
  List<Student> getStudents();

  StudentDetailDto getStudentById(Long id) throws IdBlankException, ResourceNotFoundException, BadRequestException;

  Long createNewStudent(StudentDto student) throws Exception;
}
