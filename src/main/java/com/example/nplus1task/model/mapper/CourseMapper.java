package com.example.nplus1task.model.mapper;

import com.example.nplus1task.dao.entity.CourseEntity;
import com.example.nplus1task.model.dto.CourseDTO;

public class CourseMapper {
    public static CourseDTO buildCourseDto(CourseEntity courseEntity){
        return CourseDTO.builder().
                id(courseEntity.getId()).
                title(courseEntity.getTitle()).
                build();
    }
}
