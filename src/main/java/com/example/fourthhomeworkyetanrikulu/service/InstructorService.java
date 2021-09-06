package com.example.fourthhomeworkyetanrikulu.service;

import com.example.fourthhomeworkyetanrikulu.entity.Instructor;
import com.example.fourthhomeworkyetanrikulu.repository.InstructorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InstructorService {

    private final InstructorRepository instructorRepository;


    public List<Instructor> findAll() {
        List<Instructor> instructorList = new ArrayList<>();
        instructorRepository.findAll().forEach(instructorList::add);
        return instructorList;
    }

    public Instructor findById(long id) {
        return instructorRepository.findById(id).get();
    }

    public Instructor save(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    public Instructor update(Instructor instructor) {
        return save(instructor);
    }

    public void deleteById(long id) {
        instructorRepository.deleteById(id);
    }

    public void deleteByObject(Instructor instructor) {
        long id = instructor.getId();
        deleteById(id);
    }

    public List<Instructor> findIncludeName(String name) {
        return instructorRepository.findByNameContains(name);
    }

    public void deleteByName(String name) {
        instructorRepository.deleteInstructorByName(name);
    }

}
