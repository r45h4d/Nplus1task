package com.example.nplus1task.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CourseDTO {
    private Long id;
    private String title;
}
