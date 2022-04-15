package com.liu.dao.impl;

import com.liu.dao.CourseDao;
import com.liu.domain.Course;
import com.liu.domain.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class CourseDaoImpl implements CourseDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Course> findAll() {
        String sql = "select * from course ";
        List<Course> courseList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Course>(Course.class));
//        System.out.println(courseList);
        return courseList;
    }

    @Override
    public void save(Course course) {
        String sql = "insert into course values(null,?,?) ";
        jdbcTemplate.update(sql, course.getCname(), course.getCredit());
    }

    @Override
    public List<Course> findCourseByTeacherId(Integer teacherId) {
        String sql = "select * from t_teacher_course tc, course c where tc.courseID = c.id and tc.teacherID = ? ";
        List<Course> courses = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Course>(Course.class), teacherId);
        return courses;
    }

}
