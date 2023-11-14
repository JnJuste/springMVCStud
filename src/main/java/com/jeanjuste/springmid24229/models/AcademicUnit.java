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
@Table(name = "academic_unit")
public class AcademicUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID acc_id;
    private String acc_codeNumb;
    private String name;
    @Enumerated(EnumType.STRING)
    private EAcademicUnit unit;
}
