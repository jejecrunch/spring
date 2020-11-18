package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.skhu.dto.Department;
import net.skhu.dto.Employee;
import net.skhu.mapper.DepartmentMapper;
import net.skhu.mapper.EmployeeMapper;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired EmployeeMapper employeeMapper;
    @Autowired DepartmentMapper departmentMapper;

    @RequestMapping("list")
    public String list(Model model) {
        List<Employee> employees = employeeMapper.findAll();
        model.addAttribute("employees", employees);
        return "employee/list";
    }

    @GetMapping("create")
    public String create(Model model) {
        Employee employee = new Employee();
        List<Department> departments = departmentMapper.findAll();
        model.addAttribute("employee", employee);
        model.addAttribute("departments", departments);
        return "employee/edit";
    }

    @PostMapping("create")
    public String create(Model model, Employee user) {
    	employeeMapper.insert(user);
        return "redirect:list ";
    }

    @GetMapping("edit")
    public String edit(Model model, @RequestParam("id") int id) {
        Employee employee = employeeMapper.findOne(id);
        List<Department> departments = departmentMapper.findAll();
        model.addAttribute("employee", employee);
        model.addAttribute("departments", departments);
        return "employee/edit";
    }

    @PostMapping("edit")
    public String edit(Model model, Employee employee) {
    	employeeMapper.update(employee);
        return "redirect:list";
    }

    @RequestMapping("delete")
    public String delete(Model model, @RequestParam("id") int id) {
    	employeeMapper.delete(id);
        return "redirect:list";
    }
}

