package com.example.rest.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "student_seq")
    @SequenceGenerator(name = "student_seq",allocationSize = 1)
    @Column(name = "student_id")
    private int StudentId;
    @Column(name = "student_name",nullable = false)
    private String StudentName;
    @Column(name = "student_gender")
    private StudentGender studentGender;
    @Column(name = "student_dob",columnDefinition = "DATE",nullable = false)
    private LocalDate StudentDOB;
    @Column(name = "student_mobile",nullable = false)
    private String StudentMobile;
    @Column(name = "student_email")
    private String StudentEmail;
}
