package com.jeanjuste.springmid24229.services.impl;

import com.jeanjuste.springmid24229.models.CourseDefinition;
import com.jeanjuste.springmid24229.repositories.CourseDefinitionRepository;
import com.jeanjuste.springmid24229.services.CourseDefinitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseDefinitionServiceImpl implements CourseDefinitionService {
    private CourseDefinitionRepository courseDefinitionRepository;

    @Autowired
    public CourseDefinitionServiceImpl (CourseDefinitionRepository courseDefinitionRepository){
        this.courseDefinitionRepository = courseDefinitionRepository;

    }
    @Override
    public List<CourseDefinition> findAllCourseDefinitions() {
        List<CourseDefinition> courseDefinitions = courseDefinitionRepository.findAll();
        return courseDefinitions;
    }

    @Override
    public CourseDefinition saveCourseDefinition(CourseDefinition courseDefinition) {
        return courseDefinitionRepository.save(courseDefinition);
    }
}
