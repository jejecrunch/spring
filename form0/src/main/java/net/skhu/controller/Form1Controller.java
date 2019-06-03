package net.skhu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Form1Controller {

    // 첫 페이지
    @RequestMapping("/")
    public String index(Model model) {
        return "index";
    }

    // edit1
    @RequestMapping(value="/form1/edit1", method=RequestMethod.GET)
    public String edit1(Model model) {
        return "edit1";
    }

    @RequestMapping(value="/form1/edit1", method=RequestMethod.POST)
    public String edit1(Model model, @RequestParam("title") String title,
                                     @RequestParam("color") int color) {
        model.addAttribute("title", title);
        model.addAttribute("color", color);
        System.out.printf("제목: %s. 색: %d\n", title, color);
        return "edit1";
    }
}
