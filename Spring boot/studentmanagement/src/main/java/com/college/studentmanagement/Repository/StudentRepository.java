package com.college.studentmanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.studentmanagement.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}