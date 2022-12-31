package com.springbootbackend.springbootbackend.service.impl;

import com.springbootbackend.springbootbackend.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    public List<Student>getStudents();
    public Student  getStudentById(long id);
   // public Optional<Student>deleteStudentById(Long id);
    public void deleteStudents(long id);
   // public Optional<Student>deleteById(Long id);
     public Student updateStudent(Student student, long id);
     Student saveStudent(Student student);

}
