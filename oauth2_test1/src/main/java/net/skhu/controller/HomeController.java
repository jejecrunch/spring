package net.skhu.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("user")
    public Object user(Model model, @AuthenticationPrincipal OAuth2User principal) {
        model.addAttribute("login", principal.getAttribute("login"));
        model.addAttribute("name", principal.getAttribute("name"));
        model.addAttribute("email", principal.getAttribute("email"));
        model.addAttribute("avatar_url", principal.getAttribute("avatar_url"));
        model.addAttribute("picture", principal.getAttribute("picture"));
        return "user";
    }

}

