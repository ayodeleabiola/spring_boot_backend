package com.springbootbackend.springbootbackend.dataRepository;

import com.springbootbackend.springbootbackend.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
public interface StudentRepo extends JpaRepository<Student,Long> {
}
