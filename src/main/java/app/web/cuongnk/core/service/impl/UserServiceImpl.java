package app.web.cuongnk.core.service.impl;

import app.web.cuongnk.core.dto.user.UserDto;
import app.web.cuongnk.core.entities.User;
import app.web.cuongnk.core.repositories.UserRepository;
import app.web.cuongnk.core.service.iface.UserService;
import org.springframework.stereotype.Service;

/**
 * @author cuongnk
 * @since 25/04/2023
 */
@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public void register(UserDto userDto) {
    User user = new User();
    user.setUsername(userDto.getUsername());
    user.setPassword(userDto.getPassword());
    user.setEmail(userDto.getEmail());
    user.setFirstName(userDto.getFirstName());
    user.setLastName(userDto.getLastName());
    userRepository.save(user);
  }
}
