package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.skhu.entity.City;
import net.skhu.entity.District;
import net.skhu.repository.CityRepository;
import net.skhu.repository.DistrictRepository;

@Controller
@RequestMapping("/city")
public class CityController {

	@Autowired
	CityRepository cityRepository;
	@Autowired
	DistrictRepository districtRepository;

	@RequestMapping("list")
	public String list(Model model) {
		List<City> cities = cityRepository.findAll();
		model.addAttribute("cities", cities);
		return "city/list";
	}

	@GetMapping("create")
	public String create(Model model) {
		City city = new City();
		List<District> districts = districtRepository.findAll();
		model.addAttribute("student", city);
		model.addAttribute("districts", districts);
		return "city/edit";
	}

	@PostMapping("create")
	public String create(Model model, City city) {
		cityRepository.save(city);
		return "redirect:list";
	}

	@GetMapping("edit")
	public String edit(Model model, @RequestParam("id") int id) {
		City city = cityRepository.findById(id).get();
		List<District> districts = districtRepository.findAll();
		model.addAttribute("city", city);
		model.addAttribute("districts", districts);
		return "city/edit";
	}

	@PostMapping("edit")
	public String edit(Model model, City city) {
		cityRepository.save(city);
		return "redirect:list";
	}

	@RequestMapping("delete")
	public String delete(Model model, @RequestParam("id") int id) {
		cityRepository.deleteById(id);
		return "redirect:list";
	}
}
