package com.jeanjuste.springmid24229.repositories;

import com.jeanjuste.springmid24229.models.AcademicUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AcademicUnitRepository extends JpaRepository<AcademicUnit, UUID> {
}
