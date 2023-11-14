package com.jeanjuste.springmid24229.repositories;

import com.jeanjuste.springmid24229.models.StudentRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface StudentRegistrationRepository extends JpaRepository<StudentRegistration, UUID> {
    // get Students By Semester
    @Query(
            "SELECT sem.semID, st.regNo, st.studNames  " +
                    "FROM StudentRegistration stu  " +
                    "JOIN stu.student st " +
                    "JOIN stu.semester sem " +
                    "WHERE sem.semID = :semId"
    )
    List<Object[]> getStudentsBySemester(UUID semId);

    // get Students By Department
    @Query(
            "SELECT st.student_id, st.regNo, st.studNames, acc.name  " +
                    "FROM StudentRegistration stu  " +
                    "JOIN stu.academicUnit acc " +
                    "JOIN stu.student st " +
                    "WHERE acc.acc_id = :accId"
    )
    List<Object[]> getStudentsByDepartment(UUID accId);
}
