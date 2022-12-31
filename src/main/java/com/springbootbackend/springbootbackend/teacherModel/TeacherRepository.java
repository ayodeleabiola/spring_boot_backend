package com.springbootbackend.springbootbackend.teacherModel;

import com.springbootbackend.springbootbackend.subjectModel.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {
}

