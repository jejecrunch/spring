package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.skhu.entity.Engineer;
import net.skhu.repository.EngineerRepository;

@Controller
public class EngineerController {

	@Autowired
	EngineerRepository engineerRepository;

	@RequestMapping("exam/test1")
	public @ResponseBody List<Engineer> test1(Model model, @RequestParam("id") int id) {
		return engineerRepository.findByRoleId(id);
	}

	@RequestMapping("exam/test2")
	public @ResponseBody List<Engineer> test2(Model model, @RequestParam("id") int id) {
		return engineerRepository.findByRoleIdOrderByNameAsc(id);
	}

}
