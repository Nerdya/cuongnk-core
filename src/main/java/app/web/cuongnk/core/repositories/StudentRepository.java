package app.web.cuongnk.core.repositories;

import app.web.cuongnk.core.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository
    extends JpaRepository<Student, Long> {

  Optional<Student> findStudentById(Long id);

  Optional<Student> findStudentByEmail(String email);
}
