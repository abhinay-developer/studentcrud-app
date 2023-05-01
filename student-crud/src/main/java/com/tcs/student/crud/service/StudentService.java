package com.tcs.student.crud.service;

import com.tcs.student.crud.entity.Student;

import java.util.List;

public interface StudentService {

    /**  Create Student**/
      Student saveStudent(Student student);
      /** GET One Student **/

      Student  findStudentById(Long id);

      /** GET All Student **/
      List<Student> findAllStudents();

      /** DELETE Student By Id **/
      void  deleteStudentById(Long id);

      /** UPDATE Student BY Id **/
      Student   updateStudent(Student student,Long id);
}
