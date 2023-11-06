package com.jeanjuste.springmid24229.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID course_id;
    @ManyToOne
    private AcademicUnit accUnit;
    @ManyToOne
    private CourseDefinition courseDefinition;
    @ManyToOne
    private Teacher tutor;
    @ManyToOne
    private Teacher assistant;
    @ManyToOne
    private Semester semester;
}
