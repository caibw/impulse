package com.impulse.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/students")
public class StudentCotroller {
  @Autowired
  private StudentService studentService;

  @GetMapping(path = "/get")
  public Student get(@RequestParam final int id) {
    return this.studentService.getStudentById(id);
  }

  @GetMapping(path = "/search")
  public List<Student> search() {
    return this.studentService.getStudents();
  }

  @PostMapping(path = "/add")
  public void add(@RequestParam final Student student) {
    this.studentService.addOrUpdateStudent(student);
  }

  @PutMapping(path = "/update")
  public void update(@RequestParam final Student student) {
    this.studentService.addOrUpdateStudent(student);
  }

  @DeleteMapping(path = "/delete")
  public void delete(@RequestParam final Student student) {
    this.studentService.deleteStudent(student);
  }

}
