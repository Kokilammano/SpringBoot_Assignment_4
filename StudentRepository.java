//Student Repository Interface

package com.abc.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.model.Student;

public interface StudentRepository extends JpaRepository<Student,Integer> {
	
}
