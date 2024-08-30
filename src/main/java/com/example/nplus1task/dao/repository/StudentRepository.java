package com.example.nplus1task.dao.repository;

import com.example.nplus1task.dao.entity.StudentEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    @EntityGraph(attributePaths = {"courses"})
    List<StudentEntity> findAll();

    @EntityGraph(attributePaths = {"courses"})
    @Query("SELECT s FROM StudentEntity s JOIN s.courses c WHERE c.id = :courseId")
    List<StudentEntity> findStudentsByCourseId(@Param("courseId") Long courseId);
}

