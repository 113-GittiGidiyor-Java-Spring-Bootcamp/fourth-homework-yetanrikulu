package com.example.fourthhomeworkyetanrikulu.service;

import com.example.fourthhomeworkyetanrikulu.entity.Student;
import com.example.fourthhomeworkyetanrikulu.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;


    public List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();
        studentRepository.findAll().forEach(studentList::add);
        return studentList;
    }

    public Student findById(long id) {
        return studentRepository.findById(id).get();
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public Student update(Student student) {
        return save(student);
    }

    public void deleteById(long id) {
        studentRepository.deleteById(id);
    }

    public void deleteByObject(Student student) {
        long id = student.getId();
        deleteById(id);
    }

    public List<Student> findIncludeName(String name) {
        return studentRepository.findByNameContains(name);
    }

    public List<?> groupByGender() {
        return studentRepository.groupByGender();
    }

    public void deleteByName(String name) {
        studentRepository.deleteStudentByName(name);
    }
}

