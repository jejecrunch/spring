package net.skhu.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import net.skhu.dto.Pagination;
import net.skhu.dto.StudentDto;
import net.skhu.entity.Student;
import net.skhu.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired StudentRepository studentRepository;
    @Autowired ModelMapper modelMapper;

    public List<StudentDto> findAll(Pagination pagination) {
        return studentRepository.findAll(pagination)
                                .stream()
                                .map(student -> modelMapper.map(student, StudentDto.class))
                                .collect(Collectors.toList());
    }

    public StudentDto findById(int id) {
        Student student = studentRepository.findById(id).get();
        return modelMapper.map(student, StudentDto.class);
    }

    public int count() {
        return (int)studentRepository.count();
    }

    public void insert(StudentDto studentDto) {
        Student student = modelMapper.map(studentDto, Student.class);
        studentRepository.save(student);
    }

    public void update(StudentDto studentDto) {
        Student student = modelMapper.map(studentDto, Student.class);
        studentRepository.save(student);
    }

    public void deleteById(int id) {
        studentRepository.deleteById(id);
    }

    public boolean hasErrors(StudentDto studentDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return true;
        Student student = studentRepository.findByStudentNo(studentDto.getStudentNo());
        if (student != null) {
            if (studentDto.getId() == 0) { // insert
                bindingResult.rejectValue("studentNo", null, "학번이 중복됩니다.");
                return true;
            }
            if (studentDto.getId() != student.getId()) { // update
                bindingResult.rejectValue("studentNo", null, "학번이 중복됩니다.");
                return true;
            }
        }
        return false;
    }
}
