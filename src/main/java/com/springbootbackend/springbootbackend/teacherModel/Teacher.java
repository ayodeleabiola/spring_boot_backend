package com.springbootbackend.springbootbackend.teacherModel;

import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;

@Data
@Entity

public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                     generator = "teacher_Table"
    )
    @SequenceGenerator(name = "Teacher_table",
                        sequenceName = "Teacher_table",
                        allocationSize = 1)
    private long id;
    private String teacherName;
}
