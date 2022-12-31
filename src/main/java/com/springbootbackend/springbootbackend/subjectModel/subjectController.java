package com.springbootbackend.springbootbackend.subjectModel;

import com.springbootbackend.springbootbackend.dataRepository.StudentRepo;
import com.springbootbackend.springbootbackend.model.Student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/subject")
public class subjectController {
    @Autowired
    SubjectRepository subjectRepository;
    StudentRepo studentRepo;
    Subject subject;

    @GetMapping()
    public List<Subject> getSubject()
    {
        return subjectRepository.findAll();
    }
    @PostMapping()
    public Subject saveSubject(@RequestBody Subject subject)
    {
       return subjectRepository.save(subject);
    }
    @PutMapping("{subjectId}/{studentId}")
    public Subject getSubjectById(@PathVariable long subjectId,
                                  @PathVariable long studentId )
    {
        Subject subject= subjectRepository.getOne(subjectId);
        Student student = studentRepo.getOne(studentId);
        subject.setEnrollStudent(student);
        return subjectRepository.save(subject);


    }
}
