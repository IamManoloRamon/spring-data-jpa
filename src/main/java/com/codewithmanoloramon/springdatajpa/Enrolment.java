package com.codewithmanoloramon.springdatajpa;

import javax.persistence.*;
import java.time.LocalDateTime;
@Entity(name = "Enrolment")
public class Enrolment {
    @EmbeddedId
    private EnrolmentId id;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(
            name = "student_id",
            foreignKey = @ForeignKey(
                    name = "enrolment_student_fk"
            )
    )
    private Student1 student;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(
            foreignKey = @ForeignKey(
                    name = "enrolment_course_id_fk"
            )
    )
    private Course course;
    private LocalDateTime createAt;

    public Enrolment() {
    }

    public Enrolment(EnrolmentId id, Student1 student, Course course, LocalDateTime createAt) {
        this.id = id;
        this.student = student;
        this.course = course;
        this.createAt = createAt;
    }

    public Enrolment(Student1 student, Course course, LocalDateTime createAt) {
        this.student = student;
        this.course = course;
        this.createAt = createAt;
    }

    public EnrolmentId getId() {
        return id;
    }

    public void setId(EnrolmentId id) {
        this.id = id;
    }

    public Student1 getStudent() {
        return student;
    }

    public void setStudent(Student1 student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }
}
