package com.labs.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="lesson")
@NamedQueries(value = {@NamedQuery(name = "Lesson.getAll", query = "SELECT u from Lesson u"),
@NamedQuery(name = "Lesson.getByStudent", query = "SELECT u FROM Lesson u WHERE u.student_id = :ID")
})
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private java.time.LocalDateTime localDateTime;
    private Long student_id;

    public Lesson(LocalDateTime localDateTime, Long student_id) {
        this.localDateTime = localDateTime;
        this.student_id = student_id;
    }

    public Lesson() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }
}
