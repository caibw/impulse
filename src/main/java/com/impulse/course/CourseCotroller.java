package com.impulse.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/course")
@Api(value = "Courses", tags = "课程")
public class CourseCotroller {
  @Autowired
  private CourseService courseService;

  @ApiOperation(value = "Get a course by ID")
  @GetMapping(path = "/get/{id}")
  public Course get(@ApiParam(value = "The id of a course, whose will be found",
      required = true) @RequestParam(value = "id", defaultValue = "1") final String id) {
    return this.courseService.getCourseById(Integer.parseInt(id));
  }

}
