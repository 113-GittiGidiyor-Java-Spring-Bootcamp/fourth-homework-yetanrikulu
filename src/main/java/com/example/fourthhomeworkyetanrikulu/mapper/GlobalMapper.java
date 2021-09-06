package com.example.fourthhomeworkyetanrikulu.mapper;

import com.example.fourthhomeworkyetanrikulu.dto.CourseDTO;
import com.example.fourthhomeworkyetanrikulu.dto.StudentDTO;
import com.example.fourthhomeworkyetanrikulu.entity.Course;
import com.example.fourthhomeworkyetanrikulu.entity.Student;
import org.mapstruct.Mapper;

@Mapper
public interface GlobalMapper {

    Student mapFromStudentDTOtoStudent(StudentDTO studentDTO);

    Course mapFromCourseDTOtoCourse(CourseDTO courseDTO);


}
