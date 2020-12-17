package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.skhu.entity.Assignment;
import net.skhu.repository.AssignmentRepository;

@Controller
public class AssignmentController {

	@Autowired
	AssignmentRepository assignmentRepository;

	 @RequestMapping("exam/test3") // 프로젝트 아이디로 프로젝트에 참가하고 있는 직원 목록 출력
	 public @ResponseBody List<Assignment> test3(Model model, @RequestParam("id") int id) {
		 return assignmentRepository.findByProjectId(id);
	}


}
