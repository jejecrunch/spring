package net.skhu;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

	@GetMapping("test2")
	public String test2(Model model) {
		model.addAttribute("student", new Student());
		return "third/test2";
	}

	@PostMapping("test2")
	public String test2(Model model, Student student) {
		// TODO: 저장하는 코드를 구현해야 함.
		model.addAttribute("message", "저장되었습니다");
		return "third/test2";
	}

	/*@RequestMapping(value="test3", method=RequestMethod.GET)
	public String test3(Model model) {
		model.addAttribute("student", new Student());
		return "third/test2";
	}

	@RequestMapping(value="test3", method=RequestMethod.POST)
	public String test3(Model model, Student student) {
		// TODO: 저장하는 코드를 구현해야 함.
		model.addAttribute("message", "저장되었습니다");
		return "third/test2";
	}*/
}
