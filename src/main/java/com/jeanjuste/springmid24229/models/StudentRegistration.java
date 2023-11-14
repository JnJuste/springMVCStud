package com.jeanjuste.springmid24229.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "student_registration")
public class StudentRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID studReg_id;
    @OneToOne
    private Student student;
    @OneToOne
    private AcademicUnit academicUnit;
    @OneToOne
    private Semester semester;
    @Enumerated(EnumType.STRING)
    private ERegistrationStatus eRegistrationStatus;
    private LocalDate registrationDate;
}
