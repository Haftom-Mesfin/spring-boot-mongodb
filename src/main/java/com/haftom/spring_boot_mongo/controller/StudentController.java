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
    public Student updateStudent(@RequestBody Student student) {
        //this works for saving(if no id provided in the request body) or updating a student
        return studentService.updateStudent(student);
    }

    //Delete a Student by id
    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable String id) {
        return studentService.deleteStudent(id);
    }

    //Retrieve documents using Student name
    @GetMapping("/students/{name}")
    public List<Student> getStudentByName(@PathVariable String name){
        return studentService.getStudentsByName(name);
    }

    //Retrieve documents using Student name and email
    @GetMapping("/students/byNameAndEmail")
    public List<Student> getStudentsByNameAndEmail(@RequestParam String name, @RequestParam String email){
        return studentService.getStudentsByNameAndEmail(name, email);
    }

    //Retrieve documents using Student name or email
    @GetMapping("/students/byNameOrEmail")
    public List<Student> getStudentsByNameOrEmail(@RequestParam String name, @RequestParam String email){
        return studentService.getStudentsByNameOrEmail(name, email);
    }

    //Retrieve Students based on pagination
    @GetMapping("/students/pages")
    public List<Student> getStudentsPagination(@RequestParam int pageNo, @RequestParam int pageSize){
        return studentService.getStudentsWithPagination(pageNo, pageSize);
    }

    //Sort Students by name
    @GetMapping("/students/sort")
    public List<Student> getAndSortStudents(){
        return studentService.getAndSortStudents();
    }

}
