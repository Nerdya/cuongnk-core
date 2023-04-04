package com.example.demo.mapper;

import com.example.demo.dto.StudentDto;
import com.example.demo.entities.Student;
import java.text.Normalizer;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

/**
 * @author cuongnk
 * @created_date 15/03/2023
 */
@Mapper(componentModel = "spring")
@Component
public abstract class StudentMapper {

  public abstract StudentDto toDto(Student student);

  public abstract Student fromDto(StudentDto dto);

  @BeforeMapping
  public void formatSourceDto(@MappingTarget StudentDto dto) {
    dto.setFirstName(dto.getFirstName().trim());
    dto.setLastName(dto.getLastName().trim());
  }
}
