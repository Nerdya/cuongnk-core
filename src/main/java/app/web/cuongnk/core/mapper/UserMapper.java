package app.web.cuongnk.core.mapper;

import app.web.cuongnk.core.dto.user.UserDto;
import app.web.cuongnk.core.entities.User;
import org.mapstruct.AfterMapping;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public abstract class UserMapper {

  public abstract UserDto toDto(User user);

  public abstract User fromDto(UserDto dto);

  public abstract void updateModel(@MappingTarget User user, UserDto dto);

  @AfterMapping
  public void formatSourceDto(@MappingTarget UserDto dto) {
    dto.setFirstName(dto.getFirstName().trim());
    dto.setLastName(dto.getLastName().trim());
  }
}
