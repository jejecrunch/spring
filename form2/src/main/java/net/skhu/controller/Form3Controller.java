package net.skhu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.skhu.entity.Department;
import net.skhu.repository.DepartmentRepository;

@Controller
@RequestMapping("form3")
public class Form3Controller {

    @Autowired
    DepartmentRepository departmentRepository;

    @RequestMapping("list")
    public String list(Model model) {
        model.addAttribute("departments", departmentRepository.findAll());
        return "form3/list";
    }

    @PostMapping("insert")
    public String insert(Model model, Department department) {
        departmentRepository.save(department);
        return "redirect:list";
    }

    @RequestMapping("delete")
    public String delete(Model model, int id) {
        departmentRepository.deleteById(id);
        return "redirect:list";
    }

}

