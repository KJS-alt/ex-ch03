package com.kim.mybatis.controller;

import com.kim.mybatis.domain.Student;
import com.kim.mybatis.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
//     list 화면: 전체 학생 목록
    @GetMapping
    public String list(Model model){
        model.addAttribute("students", studentService.getAllStudents());

        return "student/list";
    }

//    등록폼: form 화면: 새로운 학생 정보를 입력하기 위한 빈 화면.
    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("student",  new Student());
        return "student/form";
    }
//    등록처리: 학생정보 기록 후 저장버튼 클릭을 하면, 학생 정보를 insert
    @PostMapping
    public String create(@ModelAttribute Student student){
//        이미 학생 저장이 완료돼요
        studentService.createStudent(student);
        return "redirect:/students";
    }
//    수정(form) 폼
    @GetMapping("/{id}/edit")
    public String updateForm(@PathVariable Long id, Model model){
        model.addAttribute("student", studentService.getstudent(id));
        return "student/form";
    }


//    http://localhost:8080/students/11/edit
//    수정처리:
    @PostMapping("/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Student student){

        student.setId(id);
        studentService.updateStudent(student);
        return "redirect:/students";
    }

//    http://localhost:8080/students/11/delete
//    삭제처리:
    @PostMapping("{id}/delete")
    public String delete(@PathVariable Long id){
        studentService.deleteStudent(id);
        return "redirect:/students";
    }

}
