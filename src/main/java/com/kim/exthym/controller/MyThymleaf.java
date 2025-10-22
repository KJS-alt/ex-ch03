package com.kim.exthym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// @Controller 값이 아니고, 화면 페이지의 이름을 return하는 컨트롤러
// 스프링화면 템플릿: 타임리프: https://www.thymleaf.org/index.html
// 스프링화면 템플릿: 머스테치: https://mustache.github.io/


@Controller
public class MyThymleaf {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/thym")
    public String thymleaf(Model model){
        model.addAttribute("message", "스프링부트 타임리프 화면");
        return "hello_thym";
    }

    @GetMapping("/mustache")
    public String mustache(Model model){
        model.addAttribute("message", "머스테치 화면");
        return "hello_mu";
    }

}
