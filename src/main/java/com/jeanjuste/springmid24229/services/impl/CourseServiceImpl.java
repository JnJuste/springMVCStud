package com.jeanjuste.springmid24229.services.impl;

import com.jeanjuste.springmid24229.models.Course;
import com.jeanjuste.springmid24229.repositories.*;
import com.jeanjuste.springmid24229.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private CourseRepository courseRepository;
    private AcademicUnitRepository academicUnitRepository;
    private CourseDefinitionRepository courseDefinitionRepository;
    private TeacherRepository teacherRepository;
    private SemesterRepository semesterRepository;

    @Autowired
    public CourseServiceImpl (CourseRepository courseRepository, AcademicUnitRepository academicUnitRepository,
                              CourseDefinitionRepository courseDefinitionRepository, TeacherRepository teacherRepository,
                              SemesterRepository semesterRepository){
        this.courseRepository = courseRepository;
        this.courseDefinitionRepository = courseDefinitionRepository;
        this.academicUnitRepository = academicUnitRepository;
        this.teacherRepository = teacherRepository;
        this.semesterRepository = semesterRepository;
    }
    @Override
    public List<Course> findAllCourses() {
        List<Course> courses = courseRepository.findAll();
        return courses;
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }
}
