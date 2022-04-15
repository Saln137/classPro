package com.liu.dao;

import com.liu.domain.Course;

import java.util.List;

public interface CourseDao {
    List<Course> findAll();

    void save(Course course);


    List<Course> findCourseByTeacherId(Integer teacherId);
}
