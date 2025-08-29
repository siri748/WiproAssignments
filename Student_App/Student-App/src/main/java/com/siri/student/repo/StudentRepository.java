package com.siri.student.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siri.student.StudentAppApplication;
import com.siri.student.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
