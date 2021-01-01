package net.skhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.skhu.entity.Person;
import net.skhu.entity.Relationship;
import net.skhu.repository.PersonRepository;
import net.skhu.repository.RelationshipRepository;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired PersonRepository personRepository;
    @Autowired RelationshipRepository relationshipRepository;

    @RequestMapping("list")
    public String list(Model model) {
        model.addAttribute("people", personRepository.findAll());
        model.addAttribute("relationships", relationshipRepository.findAll());
        return "person/list";
    }

    @GetMapping("edit")
    public String edit(Model model, @RequestParam("id") int id) {
        Person person = personRepository.findById(id).get();
        List<Relationship> relationships = relationshipRepository.findAll();
        model.addAttribute("person", person);
        model.addAttribute("relationships", relationships);
        return "person/edit";
    }

    @PostMapping("edit")
    public String edit(Model model, Person person) {
    	personRepository.save(person);
    	return "redirect:list";
    }
}

