package com.impulse.course;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
  @Autowired
  private CourseMapper courseMapper;

  public Course getCourseById(final int id) {
    return this.courseMapper.selectByPrimaryKey(id);
  }

  public void addOrUpdateCourse(final Course course) {

  }

  public List<Course> getCourses() {
    return null;
  }

  public void deleteStudent(final Course course) {}

}
