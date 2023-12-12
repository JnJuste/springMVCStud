package com.jeanjuste.springmid24229.controllers;

import com.jeanjuste.springmid24229.models.Student;
import com.jeanjuste.springmid24229.repositories.StudentRepository;
import com.jeanjuste.springmid24229.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
public class StudentController {

    private StudentService studentService;
    private StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentService studentService, StudentRepository studentRepository ) {
        this.studentService = studentService;
        this.studentRepository = studentRepository;
    }

    @GetMapping("/students")
    public String createStudentForm(Model model) {
        Student student = new Student();
        List<Student> students = studentService.findAllStudents();
        model.addAttribute("students", students);
        model.addAttribute("student", student);
        return "Student/Student";
    }


    @PostMapping("/students/new")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    // get edit information
    @GetMapping("/{student_id}/edit")
    public String editStudentForm(@PathVariable("student_id") UUID student_id, Model model) {
        try {
            Optional<Student> student = studentRepository.findById(student_id);
            model.addAttribute("student", student);
            return "Student/Student-edit";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return "redirect:/all_students?fail";
        }
    }

    // update student
    @PostMapping("/{student_id}/edit")
    public String editStudent(@PathVariable("student_id") UUID student_id, @ModelAttribute("student") Student student) {
        try {
            student.setStudent_id(student_id);
            studentService.updateStudent(student);
            return "redirect:/all_students?success";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return "redirect:/all_students?fail";
        }
    }

    // delete student
    @GetMapping("/{studId}/delete")
    public String removeStudent(@PathVariable("studId") UUID studId) {
        try {
            studentService.deleteStudent(studId);
            return "redirect:/all_students?success";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return "redirect:/all_students?fail";
        }
    }

}
