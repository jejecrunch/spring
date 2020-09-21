package net.skhu;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/third")
public class ThirdController {

	@RequestMapping("test1")
	public String test1(Model model) {
		// Student 객체 생성 및 값 대입
		Student student = new Student(123, "201632035", "한지혜", "de1et_@naver.com");
		// Model 객체에 Student 객체 삽입
		model.addAttribute("std", student);
		return "third/test1";
	}
}
