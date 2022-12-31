package com.springbootbackend.springbootbackend.subjectModel;
import com.springbootbackend.springbootbackend.model.Student;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;

import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "student_table")
    @SequenceGenerator(name = "student_Table",
                        sequenceName = "student_table",
                        allocationSize = 1)

    private long id;
    @ManyToMany
    @JoinTable(name = "student_enroll",
               joinColumns = @JoinColumn(name = "subject_id"),
               inverseJoinColumns = @JoinColumn(name = "student_id"))

    private Set<Student> enrollStudent = new HashSet<>();
    private String subjectName;

    public Set<Student> getEnrollStudent() {
        return enrollStudent;
    }

    public void setEnrollStudent(Student student) {
        this.enrollStudent = enrollStudent;
    }
}
