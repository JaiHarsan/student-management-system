package com.college.studentmanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.college.studentmanagement.entity.Student;
import com.college.studentmanagement.Repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student updateStudent(Long id, Student student) {

        Student existingStudent = studentRepository.findById(id).orElse(null);

        if (existingStudent == null) {
            return null;
        }

        existingStudent.setName(student.getName());
        existingStudent.setEmail(student.getEmail());

        return studentRepository.save(existingStudent);
    }

    public String deleteStudent(Long id) {

        Student existingStudent = studentRepository.findById(id).orElse(null);

        if (existingStudent == null) {
            return "Student not found";
        }

        studentRepository.delete(existingStudent);

        return "Student deleted successfully";
    }
}