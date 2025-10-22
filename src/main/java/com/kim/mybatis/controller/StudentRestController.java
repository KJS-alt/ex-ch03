package com.kim.mybatis.controller;

import com.kim.mybatis.domain.Student;
import com.kim.mybatis.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentRestController {

    private final StudentService studentService;

    //    Dependency injection : 방법1
//    @Autowired
//    private StudentService studentService;

//    Depentdency injection : 방법2
//    private final StudentService studentService;
//    public StudentRestController(StudentService studentService){
//        this.studentService = studentService;
//    }

//    Dependency injection : 방법3 - 롬복
//    @RequiredArgsConstructor
//    public class StudentRestController{
//        private final StudentService studentService;
//}
// 전체 조회ㅣ GET: http://localhost:8080/api/students
    @GetMapping
    public List<Student> list() {
        return studentService.getAllStudents();
    }

//    단건 조회: GET http://localhost:8080/api/students/1
    @GetMapping("/{id}")
    public ResponseEntity<Student> detail(@PathVariable Long id) {
        Student student = studentService.getstudent(id);
        if(student == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

//  등록 : POST http://localhost:8080/api/students/
//{
//    "name" : "테스트3",
//    "email":"kk@nate.com",
//    "age":25
//}
    @PostMapping
    public ResponseEntity<Student> create(@RequestBody Student student) {
        studentService.createStudent(student);
        return ResponseEntity.ok(student);
    }

//    수정 put
    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@PathVariable Long id, @RequestBody Student student) {

        student.setId(id);
        studentService.updateStudent(student);
        return ResponseEntity.ok(student);
    }

    //    삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }

}
