package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.skhu.entity.Student;
import net.skhu.repository.StudentRepository;

@RestController
public class StudentController {

    @Autowired StudentRepository studentRepository;

    @GetMapping("students")
    public List<Student> students() {
        return studentRepository.findAll();
    }

    @GetMapping("student/{id}")
    public Student student(@PathVariable("id") int id) {
        return studentRepository.findById(id).get();
    }

    @PostMapping("student")
    public String insert(@RequestBody Student student) {
        studentRepository.save(student);
        return "success";
    }

    @PutMapping("student")
    public String update(@RequestBody Student student) {
        studentRepository.save(student);
        return "success";
    }

    @DeleteMapping("student/{id}")
    public String delete(@PathVariable("id") int id) {
        studentRepository.deleteById(id);
        return "success";
    }
}

