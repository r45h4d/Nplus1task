package com.example.nplus1task.service;

import com.example.nplus1task.dao.entity.StudentEntity;
import com.example.nplus1task.dao.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    @Transactional
    @Query("SELECT s FROM StudentEntity s JOIN FETCH s.courses")
    public List<StudentEntity> getAllStudents() {
        return studentRepository.findAll();
    }

    @Transactional
    @Query("SELECT s FROM StudentEntity s JOIN FETCH s.courses WHERE s.id = :id")
    public StudentEntity getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }
}

