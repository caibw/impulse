package com.impulse.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
  @Autowired
  StudentRepository studentRepository;

  public Student getStudentById(final int id) {
    return this.studentRepository.getById(id);
  }
  
  public void addOrUpdateStudent(final Student student) {
    this.studentRepository.addOrUpdate(student);
  }

  public List<Student> getStudents() {
    return this.studentRepository.findAll();
  }

  public void deleteStudent(final Student student) {
    this.studentRepository.delete(student);
  }

}
