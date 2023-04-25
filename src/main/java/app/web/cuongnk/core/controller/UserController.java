package app.web.cuongnk.core.controller;

import app.web.cuongnk.core.dto.StudentDto;
import app.web.cuongnk.core.dto.user.UserDto;
import app.web.cuongnk.core.service.iface.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cuongnk
 * @since 25/04/2023
 */
@RestController
@RequestMapping("/users")
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/register")
  public ResponseEntity<?> register(@RequestBody UserDto userDto) {
    userService.register(userDto);
    return ResponseEntity.ok().build();
  }
}
