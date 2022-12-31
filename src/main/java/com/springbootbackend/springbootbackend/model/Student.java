package com.springbootbackend.springbootbackend.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.springbootbackend.springbootbackend.subjectModel.Subject;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Getter
@Setter

public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "student_table")
    @SequenceGenerator(name = "Student_table",
                            sequenceName = "Student-table",
                            allocationSize = 1)
    private long  id;
    @ManyToMany(mappedBy = "enrollStudent")
    private Set<Subject> enrollStudent = new HashSet<>();
    private String firstname;
    private String lastname;
    private String email;
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "yyyy-dd-mm")
    private String dob;
    private int age;
}
