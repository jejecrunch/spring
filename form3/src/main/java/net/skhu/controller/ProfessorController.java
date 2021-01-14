package net.skhu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.skhu.entity.Department;
import net.skhu.entity.Professor;
import net.skhu.model.ProfessorForm;
import net.skhu.repository.DepartmentRepository;
import net.skhu.repository.LectureRepository;
import net.skhu.repository.ProfessorRepository;

@Controller
@RequestMapping("professor")
public class ProfessorController {

    @Autowired DepartmentRepository departmentRepository;
    @Autowired ProfessorRepository professorRepository;
    @Autowired LectureRepository lectureRepository;


    @RequestMapping("list")
    public String list(Model model) {
        model.addAttribute("departments", departmentRepository.findAll());
        model.addAttribute("professors", professorRepository.findAll());
        return "professor/list";
    }

    @RequestMapping(value="process", method=RequestMethod.POST, params="cmd=save")
    public String save(Model model, ProfessorForm form) {
        for (int i = 0; i < form.getId().length; ++i) {
            Professor professor = new Professor();
            professor.setId(form.getId()[i]);
            professor.setName(form.getName()[i]);
            professor.setDepartment(new Department());
            professor.getDepartment().setId(form.getDepartmentId()[i]);
            professor.setPhone(form.getPhone()[i]);
            professor.setEmail(form.getEmail()[i]);
            professor.setOffice(form.getOffice()[i]);
            if (professor.getName().trim().length() > 0)
                professorRepository.save(professor);
        }
        return "redirect:list";
    }

    @RequestMapping(value="process", method=RequestMethod.POST, params="cmd=delete")
    public String delete(Model model, int[] idChecked) {
        for (int i = 0; i < idChecked.length; ++i)
            if (lectureRepository.countByProfessorId(idChecked[i]) == 0)
                professorRepository.deleteById(idChecked[i]);
        return "redirect:list";
    }

}

