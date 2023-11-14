package com.jeanjuste.springmid24229.repositories;

import com.jeanjuste.springmid24229.models.StudentCourse;
import com.jeanjuste.springmid24229.models.StudentRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@EnableJpaRepositories
public interface StudentCourseRepository extends JpaRepository<StudentCourse, UUID> {
    // get Students By Course
    @Query(
            "SELECT c.course_id, st.regNo, st.studNames, cd.courseCode, cd.courseName " +
                    "FROM StudentCourse sc " +
                    "JOIN sc.course c " +
                    "JOIN c.courseDefinition cd " +
                    "JOIN sc.studentRegistration stu " +
                    "JOIN stu.student st " +
                    "WHERE sc.course.course_id = :courseId"
    )
    List<Object[]> getStudentsByCourse(UUID courseId);

    // get Courses By Student
    @Query(
            "SELECT s.studReg_id, stu.regNo, stu.studNames, cd.courseCode, cd.courseName " +
                    "FROM StudentCourse sc " +
                    "JOIN sc.course c " +
                    "JOIN c.courseDefinition cd " +
                    "JOIN sc.studentRegistration s " +
                    "JOIN s.student stu " +
                    "WHERE s.studReg_id = :stud_id"
    )
    List<Object[]> getCoursesByStudent(UUID stud_id);
}
