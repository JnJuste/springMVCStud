package com.jeanjuste.springmid24229.services;

import com.jeanjuste.springmid24229.models.CourseDefinition;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseDefinitionService {
    List<CourseDefinition> findAllCourseDefinitions();
    CourseDefinition saveCourseDefinition(CourseDefinition courseDefinition);
}
