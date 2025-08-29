package com.siri.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siri.student.entities.Student;

import com.siri.student.repo.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<Student> getAll() {
		
		return studentRepository.findAll();
	}

	@Override
	public void save(Student student) {
		studentRepository.save(student);
		
	}

	@Override
	public Student getById(Long id) {
		return studentRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		studentRepository.deleteById(id);
		
	}
}
