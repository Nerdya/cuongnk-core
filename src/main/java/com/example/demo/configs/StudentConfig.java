package com.example.demo.configs;

import com.example.demo.entities.Student;
import com.example.demo.repositories.StudentRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.yml")
public class StudentConfig {

  @Bean
  CommandLineRunner commandLineRunner(StudentRepository repository) {
    return args -> {
      Student dia = new Student(
          1L,
          "Dia",
          "diag00gle@gmail.com",
          LocalDate.of(2002, 2, 18)
      );

      Student cuong = new Student(
          2L,
          "Cuong",
          "cuongctcp182@gmail.com",
          LocalDate.of(2000, 1, 1)
      );

      repository.saveAll(
          List.of(dia, cuong)
      );
    };
  }

}
