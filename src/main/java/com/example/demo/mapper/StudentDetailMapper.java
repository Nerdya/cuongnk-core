package com.example.demo.mapper;

import com.example.demo.dto.StudentDetailDto;
import com.example.demo.dto.StudentDto;
import com.example.demo.entities.Student;
import java.text.Normalizer;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

/**
 * @author cuongnk
 * @created_date 15/03/2023
 */
@Mapper(componentModel = "spring")
@Component
public abstract class StudentDetailMapper {

  public abstract StudentDetailDto toDto(Student student);

  @BeforeMapping
  public void formatSourceDto(@MappingTarget StudentDetailDto dto, Student student) {
    // Đổi tên về chữ latin
    dto.setFirstName(convert(student.getFirstName()));
    dto.setLastName(convert(student.getLastName()));
  }

  public static String convert(String input) {
    if (input == null) {
      return null;
    }
    String output = Normalizer.normalize(input, Normalizer.Form.NFD)
        .replaceAll("\\p{M}", "")
        .replaceAll("đ", "d")
        .replaceAll("Đ", "D");
    return output;
  }
}
