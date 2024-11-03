package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.List;

import static java.util.Calendar.MAY;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner (StudentRepository repository) {

        return args -> {
                    Student mantas = new Student(
                            "vadw",
                            "fadw",
                            LocalDate.of(2002, Month.MAY, 3));
                    Student aleksas = new Student(
                            "aleks",
                            "aleks@gmail.com",
                            LocalDate.of(2232, Month.MAY, 3));

                    repository.saveAll(List.of(mantas, aleksas));

        };
    }

}
