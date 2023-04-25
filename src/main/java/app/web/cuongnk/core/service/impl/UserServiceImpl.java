package app.web.cuongnk.core.service.impl;

import app.web.cuongnk.core.dto.user.UserDto;
import app.web.cuongnk.core.entities.User;
import app.web.cuongnk.core.mapper.UserMapper;
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
  private final UserMapper userMapper;

  public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
    this.userRepository = userRepository;
    this.userMapper = userMapper;
  }

  @Override
  public UserDto createUser(UserDto userDto) {

    // TODO: Do checks

    User user = new User();
    userMapper.updateModel(user, userDto);
    userRepository.save(user);
    return userMapper.toDto(user);
  }
}
