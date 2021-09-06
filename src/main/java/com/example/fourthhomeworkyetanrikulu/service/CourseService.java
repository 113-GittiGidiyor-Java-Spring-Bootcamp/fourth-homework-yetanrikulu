package com.example.fourthhomeworkyetanrikulu.service;

import com.example.fourthhomeworkyetanrikulu.entity.Course;
import com.example.fourthhomeworkyetanrikulu.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public List<Course> findAll() {
        List<Course> courseList = new ArrayList<>();
        courseRepository.findAll().forEach(courseList::add);
        return courseList;
    }

    public Course findById(long id) {
        return courseRepository.findById(id).get();
    }

    public Course save(Course course) {
        return courseRepository.save(course);
    }

    public Course update(Course course) {
        return save(course);
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
