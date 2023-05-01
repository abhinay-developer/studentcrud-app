package com.tcs.student.crud.service;

import com.tcs.student.crud.entity.Student;
import com.tcs.student.crud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return  studentRepository.save(student);
    }

    @Override
    public Student findStudentById(Long id) {
        return  studentRepository.findById(id).orElseThrow(()->new RuntimeException("Student Id Not Found:"+id));
    }

    @Override
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void deleteStudentById(Long id) {
       studentRepository.deleteById(id);
    }

    @Override
    public Student updateStudent(Student student, Long id) {
        Optional<Student> optionalStudent= studentRepository.findById(id);
        Student updateStu=optionalStudent.get();
        updateStu.setEmail(student.getEmail());
        updateStu.setFirstName(student.getFirstName());
        updateStu.setLastName(student.getLastName());
        updateStu.setMobileNumber(student.getMobileNumber());
        return  studentRepository.save(updateStu);
    }
}
