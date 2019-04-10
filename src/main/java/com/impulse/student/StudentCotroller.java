package com.impulse.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/student")
@Api(value = "students", tags = "学生")
public class StudentCotroller {
  @Autowired
  private StudentService studentService;

  @ApiOperation(value = "Get a student by ID")
  @GetMapping(path = "/get/{id}")
  public Student get(@ApiParam(value = "The id of a student, who will be found",
      required = true) @RequestParam(value = "id", defaultValue = "1") final String id) {
    return this.studentService.getStudentById(Integer.parseInt(id));
  }

  @ApiOperation(value = "Search for student list")
  @GetMapping(path = "/search")
  public List<Student> search() {
    return this.studentService.getStudents();
  }

  @ApiOperation(value = "Delete a student by ID")
  @DeleteMapping(path = "/delete/{id}")
  public ResponseEntity<?> delete(@ApiParam(value = "The id of a student, who will be deleted",
      required = true) @PathVariable final String id) {
    final Student student = this.studentService.getStudentById(Integer.parseInt(id));
    this.studentService.deleteStudent(student);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @ApiOperation(value = "Create a student")
  @PostMapping(path = "/add")
  public ResponseEntity<?> add(@ApiParam(value = "The student object will be created",
      required = true) @RequestBody final Student student) {
    this.studentService.addOrUpdateStudent(student);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @ApiOperation(value = "update a student")
  @PutMapping(path = "/update")
  public ResponseEntity<?> update(@ApiParam(value = "The student object will be updated",
      required = true) @RequestBody final Student student) {
    this.studentService.addOrUpdateStudent(student);
    return new ResponseEntity<>(HttpStatus.OK);
  }

}
