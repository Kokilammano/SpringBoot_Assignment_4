//Student Service Class

package com.abc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abc.model.Student;
import com.abc.repo.StudentRepository;

@Service
@Transactional
public class StudentService {
	@Autowired
	private StudentRepository repo;
	
	public List<Student> listAll(){
		return repo.findAll();
	}
	
	public Student get(int roll_no) {
		return repo.findById(roll_no).get();
	}
	
	public void save(Student student) {
		repo.save(student);
	}
	
	public void delete(int roll_no) {
		repo.deleteById(roll_no);
	}
}
