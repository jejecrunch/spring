package net.skhu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.skhu.entity.Department;
import net.skhu.repository.DepartmentRepository;

@Controller
@RequestMapping("form2")
public class Form2Controller {

    @Autowired
    DepartmentRepository departmentRepository;

    @RequestMapping("list")
    public String list(Model model) {
        model.addAttribute("departments", departmentRepository.findAll());
        return "form2/list";
    }

    @PostMapping("insert")
    public String insert(Model model, Department department) {
        departmentRepository.save(department);
        return "redirect:list";
    }

}

