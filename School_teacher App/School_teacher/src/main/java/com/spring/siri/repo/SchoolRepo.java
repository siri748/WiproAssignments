package com.spring.siri.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.siri.entities.School;

@Repository
public interface SchoolRepo extends JpaRepository<School, Long> {

    List<School> findBySchoolName(String schoolName);

    List<School> findByTeacher_TeacherName(String teacherName); // ✅ correct syntax

    // If you're using native query, define it explicitly with @Query
    // @Query(value = "SELECT * FROM school WHERE school_address = ?1", nativeQuery = true)
    // List<School> findBySchoolAddressNative(String address);

    // @Query(value = "SELECT * FROM school WHERE LOWER(school_name) = LOWER(?1)", nativeQuery = true)
    // List<School> findBySchoolNameIgnoreCaseNative(String name);
}