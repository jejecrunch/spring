package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.skhu.dto.Student;
import net.skhu.mapper.DepartmentMapper;
import net.skhu.mapper.StudentMapper;
import net.skhu.model.Pagination;

@Controller
@RequestMapping("student")
public class StudentController {

    @Autowired StudentMapper studentMapper;
    @Autowired DepartmentMapper departmentMapper;

    @RequestMapping("list")
    public String list(Model model, Pagination pagination) {
        List<Student> students = studentMapper.findByDepartmentId(pagination);
        pagination.setRecordCount(studentMapper.count(pagination));
        model.addAttribute("students", students);
        model.addAttribute("departments", departmentMapper.findAll());
        return "student/list";
    }

    @GetMapping("create")
    public String create(Model model, Pagination pagination) {
        model.addAttribute("student", new Student());
        model.addAttribute("departments", departmentMapper.findAll());
        return "student/edit";
    }

    @PostMapping("create")
    public String create(Model model, Student student, Pagination pagination) {
        studentMapper.insert(student);
        pagination.setDi(0);
        int lastPage = (int)Math.ceil((double)studentMapper.count(pagination) / pagination.getSz());
        pagination.setPg(lastPage);
        return "redirect:list?" + pagination.getQueryString();
    }

    @GetMapping("edit")
    public String edit(Model model, @RequestParam("id") int id, Pagination pagination) {
        Student student = studentMapper.findById(id);
        model.addAttribute("student", student);
        model.addAttribute("departments", departmentMapper.findAll());
        return "student/edit";
    }

    @PostMapping(value="edit", params="cmd=save")
    public String edit(Model model, Student student, Pagination pagination) {
        studentMapper.update(student);
        return "redirect:list?" + pagination.getQueryString();
    }

    @PostMapping(value="edit", params="cmd=delete")
    public String delete(Model model, @RequestParam("id") int id, Pagination pagination) {
        studentMapper.deleteById(id);
        return "redirect:list?" + pagination.getQueryString();
    }
}

