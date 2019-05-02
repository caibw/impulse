package com.impulse.course;

import com.impulse.course.Course;
import com.impulse.course.CourseExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CourseMapper {
  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * course
   *
   * @mbggenerated Thu May 02 12:36:53 CST 2019
   */
  int countByExample(CourseExample example);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * course
   *
   * @mbggenerated Thu May 02 12:36:53 CST 2019
   */
  int deleteByExample(CourseExample example);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * course
   *
   * @mbggenerated Thu May 02 12:36:53 CST 2019
   */
  int deleteByPrimaryKey(Integer id);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * course
   *
   * @mbggenerated Thu May 02 12:36:53 CST 2019
   */
  int insert(Course record);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * course
   *
   * @mbggenerated Thu May 02 12:36:53 CST 2019
   */
  int insertSelective(Course record);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * course
   *
   * @mbggenerated Thu May 02 12:36:53 CST 2019
   */
  List<Course> selectByExample(CourseExample example);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * course
   *
   * @mbggenerated Thu May 02 12:36:53 CST 2019
   */
  Course selectByPrimaryKey(Integer id);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * course
   *
   * @mbggenerated Thu May 02 12:36:53 CST 2019
   */
  int updateByExampleSelective(@Param("record") Course record,
      @Param("example") CourseExample example);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * course
   *
   * @mbggenerated Thu May 02 12:36:53 CST 2019
   */
  int updateByExample(@Param("record") Course record, @Param("example") CourseExample example);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * course
   *
   * @mbggenerated Thu May 02 12:36:53 CST 2019
   */
  int updateByPrimaryKeySelective(Course record);

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * course
   *
   * @mbggenerated Thu May 02 12:36:53 CST 2019
   */
  int updateByPrimaryKey(Course record);
}
