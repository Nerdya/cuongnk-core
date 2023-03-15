package com.example.demo.service.iface;

import com.example.demo.dto.StudentDto;
import com.example.demo.entities.Student;
import java.util.List;

/**
 * @author cuongnk
 * @created_date 14/03/2023
 */
public interface StudentService {
  List<Student> getStudents();

//  Optional<Student> getStudentById(Long studentId);

  StudentDto createNewStudent(StudentDto student) throws Exception;
}
