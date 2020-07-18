package com.ynz.front.demothymeleaf.controllers;

import com.ynz.front.demothymeleaf.domain.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller

public class FrontController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/hello")
    public String hello(@RequestParam("name") String name, Model model) {
        model.addAttribute("greetingPersonName", name);
        return "hello";
    }

    @GetMapping("/students")
    public String getStudents(Model model) {
        Student student1 = Student.builder().studentId(1).name("Daoqi Yang").build();
        Student student2 = Student.builder().studentId(2).name("Haley Jena").build();
        model.addAttribute("students", Arrays.asList(student1, student2));
        return "students";
    }

}
