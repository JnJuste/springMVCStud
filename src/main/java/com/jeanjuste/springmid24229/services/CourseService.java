package com.jeanjuste.springmid24229.services;

import com.jeanjuste.springmid24229.models.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {
    List<Course> findAllCourses();
    Course saveCourse(Course course);
}
