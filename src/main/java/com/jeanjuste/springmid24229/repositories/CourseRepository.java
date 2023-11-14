package com.jeanjuste.springmid24229.repositories;

import com.jeanjuste.springmid24229.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CourseRepository extends JpaRepository<Course, UUID> {
    // get Courses By Department
    @Query(
            "SELECT c.course_id, cd.courseCode, cd.courseName " +
                    "FROM Course c " +
                    "JOIN c.courseDefinition cd " +
                    "JOIN c.accUnit acc " +
                    "WHERE acc.acc_id = :dep_id"
    )
    List<Object[]> getCoursesByDepartment(UUID dep_id);
}
