package com.example.pms.Business;
import com.example.pms.Model.Student;
import com.example.pms.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public String saveStudent(Student student) {
       List<Student> StudentList = new ArrayList<>();
        StudentList.add(student);
        studentRepository.save(student);
        return "Student Saved";
        }
        public String deleteStudentById(Long studentId){
            studentRepository.deleteById(studentId);
            return "Data has been deleted";
        }
        public List<Student> findAllStudents(){
             return studentRepository.findAll();
        }
        public Optional<Student> findStudentById(Long studentId){
             return studentRepository.findById(studentId);
        }
        public Optional<Student>findBystudentName(String studentName){
        return studentRepository.findBystudentName(studentName);
        }
}
