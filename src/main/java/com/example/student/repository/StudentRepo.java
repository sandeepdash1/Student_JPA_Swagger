package com.example.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.student.dao.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

}
