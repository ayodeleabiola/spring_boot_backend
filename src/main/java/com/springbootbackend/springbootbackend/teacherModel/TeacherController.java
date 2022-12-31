package com.springbootbackend.springbootbackend.teacherModel;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/teacher")
public class TeacherController {
    TeacherRepository teacherRepository;

    @GetMapping()
    public List<Teacher> getTeacher()
    {
        return teacherRepository.findAll();
    }
    @PostMapping
    public Teacher saveTeacher(@RequestBody Teacher teacher)
    {
        return teacherRepository.save(teacher);
    }
}

