package com.haftom.spring_boot_mongo.controller;

import com.haftom.spring_boot_mongo.entity.Student;
import com.haftom.spring_boot_mongo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //Create a Student
    @PostMapping("/student")
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    //Fetch Student by Id
    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable String id) {
        return studentService.getStudent(id);
    }

    //Fetch all Students
    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentService.getAllStudents();
    }

    //Update a Student
    @PutMapping("/student")
    public Student updateStudent(@RequestBody Student student){
        //this works for saving(if no id provided in the request body) or updating a student
        return studentService.updateStudent(student);
    }

    //Delete a Student by id
    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable String id){
        return studentService.deleteStudent(id);
    }

}
