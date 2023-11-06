package com.jeanjuste.springmid24229.services.impl;

import com.jeanjuste.springmid24229.models.Teacher;
import com.jeanjuste.springmid24229.repositories.TeacherRepository;
import com.jeanjuste.springmid24229.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    private TeacherRepository teacherRepository;

    @Autowired
    public TeacherServiceImpl (TeacherRepository teacherRepository){
        this.teacherRepository = teacherRepository;

    }
    @Override
    public List<Teacher> findAllTeachers() {
        List<Teacher> teachers = teacherRepository.findAll();
        return teachers;
    }

    @Override
    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }
}
