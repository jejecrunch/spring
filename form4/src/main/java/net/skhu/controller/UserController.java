package net.skhu.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.skhu.model.UserRegistration;
import net.skhu.service.DepartmentService;
import net.skhu.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired UserService userService;
    @Autowired DepartmentService departmentService;

    @GetMapping("register")
    public String register(Model model) {
        model.addAttribute(new UserRegistration());
        model.addAttribute("departments", departmentService.findAll());
        return "user/register";
    }

    @PostMapping("register")
    public String register(Model model,
            @Valid UserRegistration userRegistration, BindingResult bindingResult)
    {
        if (userService.hasErrors(userRegistration, bindingResult)) {
            model.addAttribute("departments", departmentService.findAll());
            return "user/register";
        }
        userService.save(userRegistration);
        return "redirect:success";
    }

    @RequestMapping("success")
    public String success() {
        return "user/success";
    }
}

