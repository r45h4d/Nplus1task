package com.example.nplus1task.model.mapper;

import com.example.nplus1task.dao.entity.StudentEntity;
import com.example.nplus1task.model.dto.StudentDTO;
import lombok.Builder;

@Builder
public class StudentMapper {
    public static StudentDTO buildStudentDto(StudentEntity studentEntity){
        return StudentDTO.builder().
                id(studentEntity.getId()).
                name(studentEntity.getName()).
                build();
    }
}
