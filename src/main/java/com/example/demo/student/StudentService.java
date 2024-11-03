package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> GetAllStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent()) {
            throw new IllegalStateException("Student already exists");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if(!exists) {
            throw new IllegalStateException("Student does not exist");
        }
        studentRepository.deleteById(studentId);
    }

    public void updateStudent(Long studentId, Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentById(studentId);
        if (studentOptional.isPresent()) {
            Student studentToUpdate = studentOptional.get();
            studentToUpdate.setName(student.getName());
            studentToUpdate.setEmail(student.getEmail());
        }
        else {
            throw new IllegalStateException("Student does not exist");
        }

    }
}
