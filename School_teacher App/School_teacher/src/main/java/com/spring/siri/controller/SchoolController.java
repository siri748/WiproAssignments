package com.spring.siri.controller;

import com.spring.siri.entities.School;
import com.spring.siri.services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schools")
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    @PostMapping("/saveSchool")	
    public School saveSchool(@RequestBody School school) {
        return schoolService.save(school);
    }

    @GetMapping
    public List<School> getAll() {
        return schoolService.findAll();
    }

    @GetMapping("/getSchoolById/{id}")
    public School getSchoolById(@PathVariable Long id) {
        return schoolService.findById(id);
    }

    @PutMapping("/updateSchoolById/{id}")
    public School updateSchoolById(@PathVariable Long id, @RequestBody School school) {
        return schoolService.update(id, school);
    }

    @PatchMapping("/patchUpdateSchoolById/{id}")
    public School patchUpdateSchoolById(@PathVariable Long id, @RequestParam String name) {
        return schoolService.patchUpdate(id, name);
    }

    @DeleteMapping("/deleteSchoolById/{id}")
    public String deleteSchoolById(@PathVariable Long id) {
        schoolService.delete(id);
        return "Deleted Successfully";
    }

    // Custom JPQL
    @GetMapping("/by-name/{name}")
    public List<School> getByName(@PathVariable String name) {
        return schoolService.findBySchoolName(name);
    }

    // Native Query
    @GetMapping("/by-address/{address}")
    public List<School> getByAddress(@PathVariable String address) {
        return schoolService.findBySchoolAddress(address);
    }
}