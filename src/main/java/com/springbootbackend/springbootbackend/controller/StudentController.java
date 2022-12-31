package com.springbootbackend.springbootbackend.controller;

import com.springbootbackend.springbootbackend.model.Student;
import com.springbootbackend.springbootbackend.service.StudentServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/student")
public class StudentController {
    public StudentServiceImpl studentServiceImpl;

    public StudentController(StudentServiceImpl studentServiceImpl)
    {
        this.studentServiceImpl=studentServiceImpl;
    }
    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
       return new ResponseEntity<Student>(studentServiceImpl.saveStudent(student),HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") long studentId){
        return new ResponseEntity<Student>(studentServiceImpl.getStudentById(studentId),HttpStatus.OK);
    }
    @GetMapping()
    public List<Student>getStudents(){
        return studentServiceImpl.getStudents();
    }
    @PutMapping("{id}")
    public ResponseEntity<Student>updateStudent(@PathVariable("id") long id,
                                                        @RequestBody Student student){
        return new ResponseEntity<Student>(studentServiceImpl.updateStudent(student,id),HttpStatus.OK);

    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudents(@PathVariable("id") long id){
        studentServiceImpl.deleteStudents(id);
        String str ="Student with" + " "+ id + "deleted succesfully.";
        return new ResponseEntity<String>(str,HttpStatus.OK);
    }

}
