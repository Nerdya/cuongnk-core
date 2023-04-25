package app.web.cuongnk.core.service.iface;

import app.web.cuongnk.core.dto.StudentDetailDto;
import app.web.cuongnk.core.exception.BadRequestException;
import app.web.cuongnk.core.exception.IdBlankException;
import app.web.cuongnk.core.exception.ResourceNotFoundException;
import app.web.cuongnk.core.dto.StudentDto;
import app.web.cuongnk.core.entities.Student;
import java.util.List;

public interface StudentService {
  List<Student> getStudents();

  StudentDetailDto getStudentById(Long id) throws IdBlankException, ResourceNotFoundException, BadRequestException;

  Long createNewStudent(StudentDto student) throws Exception;
}
