package com.example.pms.Controller;

import com.example.pms.Business.InfoUpdate;
import com.example.pms.Business.StudentService;
import com.example.pms.Model.Job;
import com.example.pms.Model.Student;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Students")
public class StudentController {

    @Autowired
    StudentService student;

    @GetMapping
    ResponseEntity<List<Student>> findStudents(){
        List<Student>studentObject = student.findAllStudents();
        return new  ResponseEntity<>(studentObject, HttpStatus.OK);
    }
    @GetMapping("/{studentId}")
        ResponseEntity<Student>getStudent(@PathVariable Long studentId){
        Optional<Student>studentObject = student.findStudentById(studentId);
        Student student1 = studentObject.get();
            return new ResponseEntity<>(student1, HttpStatus.OK);
        }
    @GetMapping("/studentName")
    ResponseEntity<Student>getStudent(InfoUpdate infoUpdate){
        Optional<Student>studentObject = student.findBystudentName(infoUpdate.studentName);
        Student student1 = studentObject.get();
        return new ResponseEntity<>(student1, HttpStatus.OK);
    }
    @PostMapping
    ResponseEntity<String> addStudent(@RequestBody Student studentObject){
        String message = student.saveStudent(studentObject);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }
    @DeleteMapping("/{studentId}")
    ResponseEntity<String> deleteStudent(@PathVariable Long studentId){
        String  message = student.deleteStudentById(studentId);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}
