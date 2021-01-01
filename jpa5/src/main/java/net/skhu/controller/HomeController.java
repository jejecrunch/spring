package net.skhu.controller;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.skhu.entity.Student;

@Controller
public class HomeController {

    @Autowired JpaContext jpaContext;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("search")
    @ResponseBody
    public Object search(String jpql) {
        EntityManager manager = jpaContext.getEntityManagerByManagedType(Student.class);
        Query query = manager.createQuery(jpql);
        return query.getResultList();
    }

}

