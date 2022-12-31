package com.springbootbackend.springbootbackend.service;

import com.springbootbackend.springbootbackend.dataRepository.StudentRepo;
import com.springbootbackend.springbootbackend.exception.ResourceNotFoundException;
import com.springbootbackend.springbootbackend.model.Student;
import com.springbootbackend.springbootbackend.service.impl.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepo studentRepo;

    public StudentServiceImpl(StudentRepo studentRepo)
    {
     this.studentRepo =studentRepo;
    }
    @Override
    public Student saveStudent(Student student)
    {
        return studentRepo.save(student);
    }
    @Override
    public List<Student>getStudents(){
        return studentRepo.findAll();
    }
    @Override
    public Student getStudentById(long  id)
    {
        //Optional<Student> studentOptional =studentRepo.findById(id);
       // if (studentOptional.isPresent()){
        //    return studentOptional.get();
       // }
       // else
        //    throw new ResourceNotFoundException("employee","id", id);
        return studentRepo.findById(id).orElseThrow(()->
                                                new ResourceNotFoundException("student", "id", id));
    }
    @Override
    public Student updateStudent(Student student, long studentId){
        Student existStudent =  studentRepo.findById(studentId).orElseThrow(()->
                                new ResourceNotFoundException("student","id",studentId));
        existStudent.setFirstname(student.getFirstname());
        existStudent.setLastname(student.getLastname());
        existStudent.setEmail(student.getEmail());
        existStudent.setAge(student.getAge());
        existStudent.setDob(student.getDob());
        studentRepo.save(existStudent);
        return existStudent;

    }
    @Override
    public void deleteStudents(long studentId){
        studentRepo.findById(studentId).orElseThrow(() ->new
                                                    ResourceNotFoundException("student","id",studentId));
        studentRepo.deleteById(studentId);
    }
}
