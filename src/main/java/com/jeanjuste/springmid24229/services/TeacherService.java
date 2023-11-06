package com.jeanjuste.springmid24229.services;

import com.jeanjuste.springmid24229.models.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeacherService {
    List<Teacher> findAllTeachers();
    Teacher saveTeacher(Teacher teacher);
}
