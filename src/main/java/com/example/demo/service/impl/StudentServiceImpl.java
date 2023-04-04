package com.example.demo.service.impl;

import com.example.demo.dto.StudentDetailDto;
import com.example.demo.dto.StudentDto;
import com.example.demo.entities.Student;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.IdBlankException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.StudentDetailMapper;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.repositories.StudentRepository;
import com.example.demo.service.iface.StudentService;
import java.text.Normalizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

  private final StudentRepository studentRepository;
  private final StudentMapper studentMapper;

  @Autowired
  private StudentDetailMapper studentDetailMapper;

  @Autowired
  public StudentServiceImpl(StudentRepository studentRepository, StudentMapper studentMapper) {
    this.studentRepository = studentRepository;
    this.studentMapper = studentMapper;
  }

  @Override
  public List<Student> getStudents() {
    return studentRepository.findAll();
  }

  @Override
  public StudentDetailDto getStudentById(Long id) throws IdBlankException, ResourceNotFoundException, BadRequestException {
    if (id == null) {
      throw new IdBlankException("Id không được để trống!");
    }
    if (id <= 0) {
      throw new BadRequestException("Id bắt buộc lớn hơn 0!");
    }
    Optional<Student> studentOptional = studentRepository
        .findStudentById(id);
    if (studentOptional.isEmpty()) {
      throw new ResourceNotFoundException("Hồ sơ này không tồn tại!");
    }
    StudentDetailDto detailDto = studentDetailMapper.toDto(studentOptional.get());

    return detailDto;
  }

  @Override
  public Long createNewStudent(StudentDto dto) throws Exception {
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
    Student studentMapping = studentMapper.fromDto(dto);

    Student student = studentRepository.save(studentMapping);

    return student.getId();
  }
}
