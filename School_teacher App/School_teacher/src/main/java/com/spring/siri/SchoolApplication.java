package com.spring.siri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.siri.entities.School;
import com.spring.siri.repo.SchoolRepo;

@SpringBootApplication
public class SchoolApplication implements ApplicationRunner {

    @Autowired
    private SchoolRepo schoolRepository;

    public static void main(String[] args) {
        SpringApplication.run(SchoolApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Sample data
        School s1 = new School(null, "Sunshine School", "Hyderabad");
        School s2 = new School(null, "Greenfield School", "Warangal");
        schoolRepository.save(s1);
        schoolRepository.save(s2);
    }
}