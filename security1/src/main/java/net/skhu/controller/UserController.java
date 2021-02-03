package net.skhu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	// 로그인한 사용자 정보를 보여주는 페이지 액션 메소드
    @RequestMapping("user/index")
    public String index(Model model) {
        return "user/index";
    }

    @RequestMapping("user/redirect")
    public String redirect(Model model, HttpServletRequest request) {
        // 현재 사용자의 권한에 따라 리다이렉트하는 URL이 달라짐
    	// 관리자권한과 교수권한이 같이 있으면 관리자 URL로 리다이렉트함
    	if (request.isUserInRole("ROLE_ADMIN"))
            return "redirect:/admin/index";
        if (request.isUserInRole("ROLE_PROFESSOR")) {
            return "redirect:/professor/index";
        }
        return "redirect:/user/index";
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping("user/admin_only")
    public String admin_only(Model model) {
        return "user/admin_only";
    }

    @Secured("ROLE_PROFESSOR")
    @RequestMapping("user/professor_only")
    public String professor_only(Model model) {
        return "user/professor_only";
    }

}

