package com.example.nplus1task.controller;

import com.example.nplus1task.model.dto.StudentDTO;
import com.example.nplus1task.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/students")
    public List<StudentDTO> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/courses/{courseId}/students")
    public List<StudentDTO> getStudentsByCourse(@PathVariable Long courseId) {
        return studentService.getStudentsByCourse(courseId);
    }
}
