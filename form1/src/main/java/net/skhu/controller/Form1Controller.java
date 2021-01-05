package net.skhu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import net.skhu.model.Form1;
import net.skhu.repository.DepartmentRepository;

@Controller
public class Form1Controller {

    @Autowired
    DepartmentRepository departmentRepository;

    @ModelAttribute
    public void addSomething(Model model) {
        model.addAttribute("departments", departmentRepository.findAll());
    }

    @GetMapping("form1/edit1")
    public String edit1(Model model) {
        model.addAttribute("form1", new Form1());
        return "form1/edit1";
    }

    @PostMapping("form1/edit1")
    public String edit1(Model model, Form1 form1) {
        return "form1/edit1";
    }

    @GetMapping("form1/edit2")
    public String edit2(Model model) {
        model.addAttribute("form1", new Form1());
        return "form1/edit2";
    }

    @PostMapping("form1/edit2")
    public String edit2(Model model, Form1 form1) {
        return "form1/edit2";
    }

    @GetMapping("form1/edit3")
    public String edit3(Model model) {
        model.addAttribute("form1", new Form1());
        return "form1/edit3";
    }

    @PostMapping("form1/edit3")
    public String edit3(Model model, Form1 form1) {
        return "form1/edit3";
    }

}

