package net.skhu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.skhu.mapper.DistrictMapper;

@Controller
@RequestMapping("district")
public class DistrictController {

    @Autowired DistrictMapper districtMapper;

    @RequestMapping("list")
    public String list(Model model) {
        model.addAttribute("districts", districtMapper.findAll());
        return "district/list";
    }

}

