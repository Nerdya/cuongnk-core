package com.example.demo.service.impl;

import com.example.demo.dto.StudentDto;
import com.example.demo.entities.Student;
import com.example.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements com.example.demo.service.iface.StudentService {

  private final StudentRepository studentRepository;

  @Autowired
  public StudentServiceImpl(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  @Override
  public List<Student> getStudents() {
    return studentRepository.findAll();
  }

//  @Override
//  public Optional<Student> getStudentById(Long studentId) {
//    Optional<Student> studentOptional = studentRepository
//        .findStudentById(studentId);
//    if (studentOptional.isEmpty()) {
//      throw new IllegalStateException("This id does not exist");
//    }
//    return studentOptional;
//  }

  @Override
  public StudentDto createNewStudent(StudentDto dto) throws Exception {
    // Kiểm tra dữ liệu hợp lệ
    if (dto.getFirstName() == null || dto.getLastName() == null) {
      throw new Exception("Họ đệm hoặc tên không được trống!");
    }

    // Kiểm tra email trùng
    Optional<Student> studentOptional = studentRepository.findStudentByEmail(dto.getEmail());
    if (studentOptional.isPresent()) {
      throw new Exception("Email này đã đăng ký trên hệ thống!");
    }

    // Mapping
    Student studentMapping = new Student();
    studentMapping.setFirstName(dto.getFirstName());
    studentMapping.setLastName(dto.getLastName());
    studentMapping.setEmail(dto.getEmail());
    studentMapping.setDob(dto.getDob());

    Student student = studentRepository.save(studentMapping);

    StudentDto studentDto = new StudentDto();
    studentDto.setFirstName(student.getFirstName());
    studentDto.setLastName(student.getLastName());
    studentDto.setEmail(student.getEmail());
    studentDto.setDob(student.getDob());

    return studentDto;
  }
}
