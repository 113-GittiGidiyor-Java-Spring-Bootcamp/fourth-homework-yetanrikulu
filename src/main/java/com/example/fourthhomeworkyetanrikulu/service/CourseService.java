package com.example.fourthhomeworkyetanrikulu.service;

import com.example.fourthhomeworkyetanrikulu.dto.CourseDTO;
import com.example.fourthhomeworkyetanrikulu.entity.Course;
import com.example.fourthhomeworkyetanrikulu.exception.CourseIsAlreadyExistException;
import com.example.fourthhomeworkyetanrikulu.mapper.GlobalMapper;
import com.example.fourthhomeworkyetanrikulu.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final GlobalMapper globalMapper;

    public List<Course> findAll() {
        List<Course> courseList = new ArrayList<>();
        courseRepository.findAll().forEach(courseList::add);
        return courseList;
    }

    public Course findById(long id) {
        return courseRepository.findById(id).get();
    }

    public Course save(CourseDTO courseDTO) {

        Course course = globalMapper.mapFromCourseDTOtoCourse(courseDTO);

        if (courseRepository.existsByCourseCode(course.getCourseCode())){
            throw new CourseIsAlreadyExistException();
        }
        return courseRepository.save(course);
    }

    public Course update(CourseDTO courseDTO) {
        Course course = globalMapper.mapFromCourseDTOtoCourse(courseDTO);
        return courseRepository.save(course);
    }

    public void deleteById(long id) {
        courseRepository.deleteById(id);
    }

    public void deleteByObject(Course course) {
        long id = course.getId();
        deleteById(id);
    }

    public List<Course> findIncludeName(String name) {
        return courseRepository.findByCourseNameContains(name);
    }

    public void deleteByName(String name) {
        courseRepository.deleteCourseByCourseName(name);
    }
}
