package com.jeanjuste.springmid24229.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "student_course")
public class StudentCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID stud_CourseId;
    @ManyToOne
    private Course course;
    @ManyToOne
    private StudentRegistration studentRegistration;
    private BigDecimal results;
    private Integer credits;

}
