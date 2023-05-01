package com.tcs.student.crud.controller;

import com.tcs.student.crud.entity.Student;
import com.tcs.student.crud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student newStudent = studentService.saveStudent(student);
        return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student student = studentService.findStudentById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> studentList = studentService.findAllStudents();
        return new ResponseEntity<List<Student>>(studentList, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HashMap<String, Long>> deleteStudentById(@PathVariable Long id) {
        HashMap<String, Long> hashMap = new HashMap<>();
        hashMap.put("Deleted Successfully", id);
        studentService.deleteStudentById(id);
        return new ResponseEntity<>(hashMap, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public  ResponseEntity<Student> updateStudentById(@RequestBody Student student ,@PathVariable Long id){
        Student updateStudent=studentService.updateStudent(student,id);
        return new ResponseEntity<>(updateStudent,HttpStatus.OK);
    }
}
