package net.skhu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.skhu.entity.Department;
import net.skhu.repository.DepartmentRepository;
import net.skhu.repository.StudentRepository;

@Controller
@RequestMapping("form4")
public class Form4Controller {

    @Autowired DepartmentRepository departmentRepository;
    @Autowired StudentRepository studentRepository;


    @RequestMapping("list")
    public String list(Model model) {
        model.addAttribute("departments", departmentRepository.findAll());
        return "form4/list";
    }

    @RequestMapping(value="process", method=RequestMethod.POST, params="cmd=insert")
    public String insert(Model model, Department department) {
        departmentRepository.save(department);
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

