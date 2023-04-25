package app.web.cuongnk.core.mapper;

import app.web.cuongnk.core.dto.StudentDto;
import app.web.cuongnk.core.entities.Student;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

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
