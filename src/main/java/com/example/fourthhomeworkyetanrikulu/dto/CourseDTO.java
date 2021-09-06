package com.example.fourthhomeworkyetanrikulu.dto;

import com.example.fourthhomeworkyetanrikulu.entity.Instructor;
import com.example.fourthhomeworkyetanrikulu.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {


    @NotBlank
    private String courseName;
    @NotBlank
    private String courseCode;
    @NotNull
    private int creditScore;

    private Instructor instructor;

    private List<Student> studentList = new ArrayList<>();

}
