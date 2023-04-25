package app.web.cuongnk.core.service.iface;

import app.web.cuongnk.core.dto.user.UserDto;

/**
 * @author cuongnk
 * @since 25/04/2023
 */
public interface UserService {
  UserDto createUser(UserDto userDto);
}
