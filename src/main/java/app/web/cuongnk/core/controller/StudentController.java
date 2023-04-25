package app.web.cuongnk.core.controller;

import app.web.cuongnk.core.dto.StudentDetailDto;
import app.web.cuongnk.core.entities.Student;
import app.web.cuongnk.core.exception.BadRequestException;
import app.web.cuongnk.core.exception.IdBlankException;
import app.web.cuongnk.core.exception.ResourceNotFoundException;
import app.web.cuongnk.core.service.iface.StudentService;
import app.web.cuongnk.core.dto.StudentDto;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

  private final StudentService studentService;

  @Autowired
  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping(path = "/students")
  public ResponseEntity<?> getStudents() {
    try {
      List<Student> students = studentService.getStudents();
      return new ResponseEntity<>(students, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
    }
  }

  @GetMapping("/student/{id}")
  public ResponseEntity<?> getStudentById(
      HttpServletRequest request,
      @PathVariable("id") Long id) {
    String token = request.getHeader("token");
    if (token == null || token.isBlank()) {
      return new ResponseEntity<>("Bạn không có quyền truy cập!", HttpStatus.UNAUTHORIZED);
    }
    try {
      StudentDetailDto dto = studentService.getStudentById(id);
      return new ResponseEntity<>(dto, HttpStatus.OK);
    } catch (IdBlankException e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    } catch (ResourceNotFoundException e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    } catch (BadRequestException e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    } catch (Exception e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping(path = "/student")
  public Long createNewStudent(
      @RequestBody StudentDto student) throws Exception {
    return studentService.createNewStudent(student);
  }

//  @PutMapping(path = "/student/{id}")
//  public Student updateStudent(
//      @PathVariable("id") Long id,
//      @RequestParam(required = false) String name,
//      @RequestParam(required = false) String email) {
//    return studentService.updateStudent(id, name, email);
//  }

//  @DeleteMapping(path = "/student/{id}")
//  public String deleteStudent(
//      @PathVariable("id") Long id) {
//    return studentService.deleteStudent(id);
//  }
}
