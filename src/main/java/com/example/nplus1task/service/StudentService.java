package com.example.nplus1task.service;

import com.example.nplus1task.dao.entity.StudentEntity;
import com.example.nplus1task.dao.repository.StudentRepository;
import com.example.nplus1task.model.dto.StudentDTO;
import com.example.nplus1task.model.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    @Query("SELECT s FROM StudentEntity s JOIN FETCH s.courses WHERE s.id = :id")
    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll().stream().map(StudentMapper::buildStudentDto).toList();
    }

    public List<StudentDTO> getStudentsByCourse(Long courseId) {
        List<StudentEntity> studentEntities = studentRepository.findStudentsByCourseId(courseId);
        return studentEntities.stream().map(StudentMapper::buildStudentDto).toList();
    }
}

