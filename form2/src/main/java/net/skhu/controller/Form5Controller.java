package net.skhu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.skhu.entity.Department;
import net.skhu.model.Form5;
import net.skhu.repository.DepartmentRepository;
import net.skhu.repository.StudentRepository;

@Controller
@RequestMapping("form5")
public class Form5Controller {

    @Autowired DepartmentRepository departmentRepository;
    @Autowired StudentRepository studentRepository;


    @RequestMapping("list")
    public String list(Model model) {
        model.addAttribute("departments", departmentRepository.findAll());
        return "form5/list";
    }

    @RequestMapping(value="process", method=RequestMethod.POST, params="cmd=save")
    public String save(Model model, Form5 form5) {
        for (int i = 0; i < form5.getId().length; ++i) {
            Department department = new Department();
            department.setId(form5.getId()[i]);
            department.setName(form5.getName()[i]);
            department.setShortName(form5.getShortName()[i]);
            department.setPhone(form5.getPhone()[i]);
            if (department.getName().trim().length() > 0)
                departmentRepository.save(department);
        }
        return "redirect:list";
    }

    @RequestMapping(value="process", method=RequestMethod.POST, params="cmd=delete")
    public String delete(Model model, int[] idChecked) {
        for (int i = 0; i < idChecked.length; ++i)
            if (studentRepository.countByDepartmentId(idChecked[i]) == 0)
                departmentRepository.deleteById(idChecked[i]);
        return "redirect:list";
    }

}

